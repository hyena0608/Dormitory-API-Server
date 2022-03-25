package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.DormitoryStudentInfoVo;
import com.example.dormi.mapper.vo.RoomInfoVo;
import com.example.dormi.service.CustomUserDetails;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateDormitoryStudentOutRoomHandler extends BaseHandler {

    private final DormiMapper mapper;

    public UpdateDormitoryStudentOutRoomResponse execute(CustomUserDetails user, UpdateDormitoryStudentOutRoomRequest req) {
        UpdateDormitoryStudentOutRoomResponse res = new UpdateDormitoryStudentOutRoomResponse();

        final long dormitoryStudentId = req.getDormitoryStudentId();
        final long studentId = req.getStudentId();
        int calType = 1;

//    if(emptyParam(dormitoryStudentId) || emptyParam(studentId)) {
//      res.setCode(ResultCode.BadParams);\
//      return res;
//    }

        try {

            DormitoryStudentInfoVo findDormitoryStudent = mapper.selectDormitoryStudentByDormitoryStudentId(dormitoryStudentId);

            isStudentAlreadyOut(findDormitoryStudent);

            long findRoomId = findDormitoryStudent.getRoomId();
            calType = isCurrentRoomCntOk(findRoomId, findDormitoryStudent);

            mapper.updateRoomCurrentCntByRoomId(findRoomId, calType);
            mapper.updateDormitoryStudentOutRoom(dormitoryStudentId, studentId);

            res.setCode(ResultCode.Success);
            return res;

        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }

    private void isStudentAlreadyOut(DormitoryStudentInfoVo findDormitoryStudent) {
        Timestamp deleteDt = findDormitoryStudent.getDormitoryStudentDeleteDt();
        if (deleteDt != null) {
            throw new IllegalArgumentException("이미 퇴실 처리된 학생입니다.");
        } else {
            mapper.updateDormitoryStudentDeleteDt(findDormitoryStudent.getDormitoryStudentId());
        }
    }

    private int isCurrentRoomCntOk(long findRoomId, DormitoryStudentInfoVo findDormitoryStudent) {
        int calType = 2;

        RoomInfoVo findRoom = mapper.selectRoomOneByIdNum(findRoomId, 0);

        int roomCurrentCnt = findRoom.getRoomCurrentCnt();
        if (roomCurrentCnt == 0) calType = 0;
        else if (roomCurrentCnt < 0)
            throw new IllegalArgumentException("현재 방 인원이 맞지 않습니다. (현 인원: -)");

        return calType;
    }
}

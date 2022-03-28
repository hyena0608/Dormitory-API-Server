package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.DormitoryStudentInfoVo;
import com.example.dormi.mapper.vo.RoomInfoVo;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class InsertDormitoryStudentInRoomHandler extends BaseHandler {

    private final DormiMapper mapper;

    public InsertDormitoryStudentInRoomResponse execute(CustomUserDetails user,
                                                        InsertDormitoryStudentInRoomRequest req) {
        InsertDormitoryStudentInRoomResponse res = new InsertDormitoryStudentInRoomResponse();

        final long dormitoryId = req.getDormitoryId();
        final long roomId = req.getRoomId();
        final long studentId = req.getStudentId();
        final int dormitoryStudentSemester = req.getDormitoryStudentSemester();

        if (emptyParam(dormitoryId) || emptyParam(roomId)
            || emptyParam(studentId) || emptyParam(dormitoryStudentSemester)) {
            res.setCode(ResultCode.BadParams);
            return res;
        }

        try {

            isStudentAlreadyInRoom(studentId);
            isRoomFull(roomId);

            long dormitoryStudentId =
                    mapper.insertDormitoryStudentInRoom(dormitoryId,
                                                        roomId,
                                                        studentId,
                                                        dormitoryStudentSemester);

            res.setDormitoryStudentId(dormitoryStudentId);
            return res;

        } catch (Exception e) {
            res.setCode(ResultCode.Failed);
            return res;
        }
    }

    private void isRoomFull(long roomId) {
        RoomInfoVo roomInfoVo = mapper.selectRoomOneByIdNum(roomId, 0);
        int roomLimitCnt = roomInfoVo.getRoomLimitCnt();
        int roomCurrentCnt = roomInfoVo.getRoomCurrentCnt();
        if (roomLimitCnt <= roomCurrentCnt) {
            throw new IllegalArgumentException("이미 가득 찬 방입니다.");
        }
    }

    private void isStudentAlreadyInRoom(long studentId) {
        List<DormitoryStudentInfoVo> dormitoryStudentInfoVoList =
                mapper.selectDormitoryStudentByStudentId(studentId);
        List<Timestamp> deleteDateList = dormitoryStudentInfoVoList
                .stream().map(DormitoryStudentInfoVo::getDormitoryStudentDeleteDt)
                .collect(Collectors.toList());

        for (Timestamp date : deleteDateList) {
            if (date == null) {
                throw new IllegalArgumentException("이미 방이 배정된 학생입니다.");
            }
        }
    }

}

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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteRoomByIdNumHandler extends BaseHandler {

    private final DormiMapper mapper;

    public DeleteRoomByIdNumResponse execute(CustomUserDetails user, DeleteRoomByIdNumRequest req) {
        DeleteRoomByIdNumResponse res = new DeleteRoomByIdNumResponse();

        final long roomId = req.getRoomId();
        final long roomNumber = req.getRoomNumber();

//    if(emptyParam(roomId) || emptyParam(roomNumber)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

        try {
            isRoomExist(roomId, roomNumber);
            setStudentsOutFromRoom(roomId);
            long deletedRoomId = mapper.deleteRoomByIdNum(roomId, roomNumber);

            res.setRoomId(deletedRoomId);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }

    private void isRoomExist(long roomdId, long roomNumber) {
        Optional<RoomInfoVo> roomInfoVo = Optional.ofNullable(mapper.selectRoomOneByIdNum(roomdId, roomNumber));
        if (roomInfoVo.isEmpty()) {
            throw new NullPointerException("존재하지 않는 방입니다.");
        } else if (roomInfoVo.get().getRoomDeleteDt() != null) {
            throw new IllegalArgumentException("이미 사라진 방입니다.");
        }
    }

    private void setStudentsOutFromRoom(long roomId) {
        List<DormitoryStudentInfoVo> dormitoryStudentInfoVoList = mapper.selectDormitoryStudentByRoomId(roomId);
        System.out.println("dormitoryStudentInfoVoList = " + dormitoryStudentInfoVoList);
        for (DormitoryStudentInfoVo vo : dormitoryStudentInfoVoList) {
            long dormitoryStudentId = vo.getDormitoryStudentId();
            System.out.println("dormitoryStudentId = " + dormitoryStudentId);
            mapper.updateDormitoryStudentDeleteDt(dormitoryStudentId);
        }
    }
}
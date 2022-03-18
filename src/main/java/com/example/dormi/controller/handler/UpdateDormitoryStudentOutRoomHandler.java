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

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateDormitoryStudentOutRoomHandler extends BaseHandler {

  private final DormiMapper mapper;

  public UpdateDormitoryStudentOutRoomResponse execute(CustomUserDetails user, UpdateDormitoryStudentOutRoomRequest req) {
    UpdateDormitoryStudentOutRoomResponse res = new UpdateDormitoryStudentOutRoomResponse();

    final long dormitoryStudentId = req.getDormitoryStudentId();
    final long studentId = req.getStudentId();

//    if(emptyParam(dormitoryStudentId) || emptyParam(studentId)) {
//      res.setCode(ResultCode.BadParams);\
//      return res;
//    }

    try {
      mapper.updateDormitoryStudentOutRoom(dormitoryStudentId, studentId);
      roomCurrentCount(res, dormitoryStudentId);
      return res;
    }
    catch(Exception e) {
      log.error(e.toString());
      res.setCode(ResultCode.Failed);
      return res;
    }
  }

  private void roomCurrentCount(UpdateDormitoryStudentOutRoomResponse res, long dormitoryStudentId) {
    DormitoryStudentInfoVo dormitoryStudentInfoVo = mapper.selectDormitoryStudentByDormitoryStudentId(dormitoryStudentId);
    long roomId = dormitoryStudentInfoVo.getRoomId();
    RoomInfoVo roomInfoVo = mapper.selectRoomOneByIdNum(roomId, 0);
    int roomCurrentCnt = roomInfoVo.getRoomCurrentCnt();
    if (roomCurrentCnt > 0) {
      mapper.updateRoomCurrentCntByRoomId(roomId, 2);
      res.setCode(ResultCode.Success);
    } else res.setCode(ResultCode.PeopleCntError);
  }
}

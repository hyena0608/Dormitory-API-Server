package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InsertDormitoryStudentInRoomHandler extends BaseHandler {

  private final DormiMapper mapper;

  public InsertDormitoryStudentInRoomResponse execute(CustomUserDetails user, InsertDormitoryStudentInRoomRequest req) {
    InsertDormitoryStudentInRoomResponse res = new InsertDormitoryStudentInRoomResponse();

    final long dormitoryId = req.getDormitoryId();
    final long roomId = req.getRoomId();
    final long studentId = req.getStudentId();
    final int dormitoryStudentSemester = req.getDormitoryStudentSemester();

    if(emptyParam(dormitoryId) || emptyParam(roomId) || emptyParam(studentId) || emptyParam(dormitoryStudentSemester)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      long d_s_id = mapper.insertDormitoryStudentInRoom(dormitoryId, roomId, studentId, dormitoryStudentSemester);
      mapper.updateRoomCurrentCntByRoomId(roomId, 1);

      res.setDormitoryStudentId(d_s_id);
      res.setCode(ResultCode.Success);
      return res;
    }
    catch(Exception e) {
      log.error(e.toString());
      res.setCode(ResultCode.Failed);
      return res;
    }
  }
}

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
public class InsertRoomHandler extends BaseHandler {

  private final DormiMapper mapper;

  public InsertRoomResponse execute(CustomUserDetails user, InsertRoomRequest req) {
    InsertRoomResponse res = new InsertRoomResponse();

    final long roomNumber = req.getRoomNumber();
    final int roomLimitCnt = req.getRoomLimitCnt();
    final long dormitoryId = req.getDormitoryId();

    if(emptyParam(roomNumber) || emptyParam(roomLimitCnt) || emptyParam(dormitoryId)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      long roomId = mapper.insertRoom(roomNumber, roomLimitCnt, dormitoryId);

      res.setRoomdId(roomId);
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

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
public class UpdateRoomLimitCntHandler extends BaseHandler {

  private final DormiMapper mapper;

  public UpdateRoomLimitCntResponse execute(CustomUserDetails user, UpdateRoomLimitCntRequest req) {
    UpdateRoomLimitCntResponse res = new UpdateRoomLimitCntResponse();

    final long roomId = req.getRoomId();
    final long roomNumber = req.getRoomNumber();
    final int roomLimitCnt = req.getRoomLimitCnt();

//    if(emptyParam(roomId) || emptyParam(roomNumber) || emptyParam(roomLimitCnt)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      long updatedRoomId = mapper.updateRoomLimitCnt(roomId, roomNumber, roomLimitCnt);

      res.setRoomdId(updatedRoomId);
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

package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.controller.util.Converter;
import com.example.dormi.controller.vo.RoomInfo;
import com.example.dormi.mapper.DormiMapper;
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
public class SelectRoomOneByIdNumHandler extends BaseHandler {

  private final DormiMapper mapper;

  public SelectRoomOneByIdNumResponse execute(CustomUserDetails user, SelectRoomOneByIdNumRequest req) {
    SelectRoomOneByIdNumResponse res = new SelectRoomOneByIdNumResponse();

    final long roomId = req.getRoomId();
    final long roomNumber = req.getRoomNumber();

//    if(emptyParam(roomId) || emptyParam(roomNumber)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      RoomInfoVo roomInfoVo = mapper.selectRoomOneByIdNum(roomId, roomNumber);
      RoomInfo roomInfo = Converter.convert(roomInfoVo, RoomInfo.class);

      res.setRoom(roomInfo);
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

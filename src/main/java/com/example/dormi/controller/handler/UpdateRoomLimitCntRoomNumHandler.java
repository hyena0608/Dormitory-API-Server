package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
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
public class UpdateRoomLimitCntRoomNumHandler extends BaseHandler {

  private final DormiMapper mapper;

  public UpdateRoomLimitCntRoomNumResponse execute(CustomUserDetails user, UpdateRoomLimitCntRoomNumRequest req) {
    UpdateRoomLimitCntRoomNumResponse res = new UpdateRoomLimitCntRoomNumResponse();

    final long roomId = req.getRoomId();
    final long roomNumber = req.getRoomNumber();
    final int roomLimitCnt = req.getRoomLimitCnt();

    if(emptyParam(roomId) || emptyParam(roomNumber) || emptyParam(roomLimitCnt)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {
      RoomInfoVo roomInfoVo = mapper.selectRoomOneByIdNum(roomId, roomNumber);
      isLimitLessThanCurrent(roomInfoVo, roomLimitCnt);
      isRoomNumberValidate(roomNumber, roomInfoVo);

      long updatedRoomId = mapper.updateRoomLimitCntRoomNum(roomId, roomNumber, roomLimitCnt);

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

  private void isRoomNumberValidate(long roomNumber, RoomInfoVo roomInfoVo) {
    if (roomInfoVo.getRoomNumber() == roomNumber) {
      throw new IllegalArgumentException("이미 존재하는 호수(ㅇㅇㅇ호)입니다.");
    }
  }

  private void isLimitLessThanCurrent(RoomInfoVo roomInfo, int roomLimitCnt) {
    int roomCurrentCnt = roomInfo.getRoomCurrentCnt();
    if (roomCurrentCnt > roomLimitCnt) {
      throw new IllegalArgumentException("변경할 제한 인원이 현 인원보다 적습니다.");
    }
  }
}

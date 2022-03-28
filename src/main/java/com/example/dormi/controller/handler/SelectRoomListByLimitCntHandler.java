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
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SelectRoomListByLimitCntHandler extends BaseHandler {

    private final DormiMapper mapper;

    public SelectRoomListByLimitCntResponse execute(CustomUserDetails user,
                                                    SelectRoomListByLimitCntRequest req) {
        SelectRoomListByLimitCntResponse res = new SelectRoomListByLimitCntResponse();

        final int roomLimitCnt = req.getRoomLimitCnt();

//    if (emptyParam(roomLimitCnt)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

        try {

            List<RoomInfoVo> roomInfoVoList = mapper.selectRoomListByLimitCnt(roomLimitCnt);
            List<RoomInfo> roomInfoList =
                    roomInfoVoList
                            .stream()
                            .map(o -> Converter.convert(o, RoomInfo.class))
                            .collect(Collectors.toList());

            res.setRooms(roomInfoList);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

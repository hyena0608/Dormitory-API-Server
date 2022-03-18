package com.example.dormi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.dormi.controller.handler.*;
import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.service.CustomUserDetails;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ApiRoomController {
  static Logger logger = LoggerFactory.getLogger(ApiRoomController.class);

  private InsertRoomHandler insertRoomHandler;

  @RequestMapping(method = RequestMethod.POST, value = "room/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "방 저장")
  InsertRoomResponse insertRoom(@RequestBody InsertRoomRequest req, HttpServletRequest request) {
    insertRoomHandler.setHttpServletRequest(request);
    return insertRoomHandler.execute(null, req);
  }

  private UpdateRoomLimitCntHandler updateRoomLimitCntHandler;

  @RequestMapping(method = RequestMethod.POST, value = "room/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "방 수정")
  UpdateRoomLimitCntResponse updateRoomLimitCnt(@RequestBody UpdateRoomLimitCntRequest req, HttpServletRequest request) {
    updateRoomLimitCntHandler.setHttpServletRequest(request);
    return updateRoomLimitCntHandler.execute(null, req);
  }

  private DeleteRoomByIdNumHandler deleteRoomByIdNumHandler;

  @RequestMapping(method = RequestMethod.POST, value = "room/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "방 삭제")
  DeleteRoomByIdNumResponse deleteRoomByIdNum(@RequestBody DeleteRoomByIdNumRequest req, HttpServletRequest request) {
    deleteRoomByIdNumHandler.setHttpServletRequest(request);
    return deleteRoomByIdNumHandler.execute(null, req);
  }

  private SelectRoomOneByIdNumHandler selectRoomOneByIdNumHandler;

  @RequestMapping(method = RequestMethod.GET, value = "room/select")
  @ApiOperation(value = "방 개별 조회")
  SelectRoomOneByIdNumResponse selectRoomOneByIdNum(@RequestParam("roomId") long roomId, @RequestParam("roomNumber") long roomNumber, HttpServletRequest request) {
    selectRoomOneByIdNumHandler.setHttpServletRequest(request);
    SelectRoomOneByIdNumRequest req = new SelectRoomOneByIdNumRequest();
    req.setRoomId(roomId);
    req.setRoomNumber(roomNumber);
    return selectRoomOneByIdNumHandler.execute(null, req);
  }

  private SelectRoomListByLimitCntHandler selectRoomListByLimitCntHandler;

  @RequestMapping(method = RequestMethod.GET, value = "room/select/list")
  @ApiOperation(value = "방 리스트 조회")
  SelectRoomListByLimitCntResponse selectRoomListByLimitCnt(@RequestParam("roomLimitCnt") int roomLimitCnt, HttpServletRequest request) {
    selectRoomListByLimitCntHandler.setHttpServletRequest(request);
    SelectRoomListByLimitCntRequest req = new SelectRoomListByLimitCntRequest();
    req.setRoomLimitCnt(roomLimitCnt);
    return selectRoomListByLimitCntHandler.execute(null, req);
  }
}

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
public class ApiDormitoryController {
  static Logger logger = LoggerFactory.getLogger(ApiDormitoryController.class);

  private InsertDormitoryHandler insertDormitoryHandler;

  @RequestMapping(method = RequestMethod.POST, value = "dormitory/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "기숙사 저장")
  InsertDormitoryResponse insertDormitory(@RequestBody InsertDormitoryRequest req, HttpServletRequest request) {
    insertDormitoryHandler.setHttpServletRequest(request);
    return insertDormitoryHandler.execute(null, req);
  }

  private UpdateDormitoryHandler updateDormitoryHandler;

  @RequestMapping(method = RequestMethod.POST, value = "dormitory/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "기숙사 수정")
  UpdateDormitoryResponse updateDormitory(@RequestBody UpdateDormitoryRequest req, HttpServletRequest request) {
    updateDormitoryHandler.setHttpServletRequest(request);
    return updateDormitoryHandler.execute(null, req);
  }

  private DeleteDormitoryHandler deleteDormitoryHandler;

  @RequestMapping(method = RequestMethod.POST, value = "dormitory/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "기숙사 삭제")
  DeleteDormitoryResponse deleteDormitory(@RequestBody DeleteDormitoryRequest req, HttpServletRequest request) {
    deleteDormitoryHandler.setHttpServletRequest(request);
    return deleteDormitoryHandler.execute(null, req);
  }

  private SelectDormitoryOneHandler selectDormitoryOneHandler;

  @RequestMapping(method = RequestMethod.GET, value = "dormitory/select")
  @ApiOperation(value = "기숙사 개별 조회")
  SelectDormitoryOneResponse selectDormitoryOne(@RequestParam("dormitoryId") long dormitoryId, @RequestParam("dormitoryName") String dormitoryName, HttpServletRequest request) {
    selectDormitoryOneHandler.setHttpServletRequest(request);
    SelectDormitoryOneRequest req = new SelectDormitoryOneRequest();
    req.setDormitoryId(dormitoryId);
    req.setDormitoryName(dormitoryName);
    return selectDormitoryOneHandler.execute(null, req);
  }

  private SelectDormitoryListHandler selectDormitoryListHandler;

  @RequestMapping(method = RequestMethod.GET, value = "dormitory/select/list")
  @ApiOperation(value = "기숙사 리스트 조회")
  SelectDormitoryListResponse selectDormitoryList(HttpServletRequest request) {
    selectDormitoryListHandler.setHttpServletRequest(request);
    SelectDormitoryListRequest req = new SelectDormitoryListRequest();
    return selectDormitoryListHandler.execute(null, req);
  }
}

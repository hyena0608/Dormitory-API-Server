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
public class ApiDormitoryStudentController {
  static Logger logger = LoggerFactory.getLogger(ApiDormitoryStudentController.class);

  private InsertDormitoryStudentInRoomHandler insertDormitoryStudentInRoomHandler;

  @RequestMapping(method = RequestMethod.POST, value = "dormitorystudent/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 방에 입실 (학기)")
  InsertDormitoryStudentInRoomResponse insertDormitoryStudentInRoom(@RequestBody InsertDormitoryStudentInRoomRequest req, HttpServletRequest request) {
    insertDormitoryStudentInRoomHandler.setHttpServletRequest(request);
    return insertDormitoryStudentInRoomHandler.execute(null, req);
  }

  private UpdateDormitoryStudentOutRoomHandler updateDormitoryStudentOutRoomHandler;

  @RequestMapping(method = RequestMethod.POST, value = "dormitorystudent/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 방에서 퇴실 (학기)")
  UpdateDormitoryStudentOutRoomResponse updateDormitoryStudentOutRoom(@RequestBody UpdateDormitoryStudentOutRoomRequest req, HttpServletRequest request) {
    updateDormitoryStudentOutRoomHandler.setHttpServletRequest(request);
    return updateDormitoryStudentOutRoomHandler.execute(null, req);
  }
}

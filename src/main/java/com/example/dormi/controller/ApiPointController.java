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
public class ApiPointController {
  static Logger logger = LoggerFactory.getLogger(ApiPointController.class);

  private InsertPointToStudentHandler insertPointToStudentHandler;

  @RequestMapping(method = RequestMethod.POST, value = "point/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 점수 부여")
  InsertPointToStudentResponse insertPointToStudent(@RequestBody InsertPointToStudentRequest req, HttpServletRequest request) {
    insertPointToStudentHandler.setHttpServletRequest(request);
    return insertPointToStudentHandler.execute(null, req);
  }

  private DeletePointToStudentHandler deletePointToStudentHandler;

  @RequestMapping(method = RequestMethod.POST, value = "point/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 점수 취소")
  DeletePointToStudentResponse deletePointToStudent(@RequestBody DeletePointToStudentRequest req, HttpServletRequest request) {
    deletePointToStudentHandler.setHttpServletRequest(request);
    return deletePointToStudentHandler.execute(null, req);
  }
}

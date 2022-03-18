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
public class ApiStudentController {
  static Logger logger = LoggerFactory.getLogger(ApiStudentController.class);

  private InsertStudentHandler insertStudentHandler;

  @RequestMapping(method = RequestMethod.POST, value = "student/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 저장")
  InsertStudentResponse insertStudent(@RequestBody InsertStudentRequest req, HttpServletRequest request) {
    insertStudentHandler.setHttpServletRequest(request);
    return insertStudentHandler.execute(null, req);
  }

  private UpdateStudentHandler updateStudentHandler;

  @RequestMapping(method = RequestMethod.POST, value = "student/update", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 수정")
  UpdateStudentResponse updateStudent(@RequestBody UpdateStudentRequest req, HttpServletRequest request) {
    updateStudentHandler.setHttpServletRequest(request);
    return updateStudentHandler.execute(null, req);
  }

  private DeleteStudentHandler deleteStudentHandler;

  @RequestMapping(method = RequestMethod.POST, value = "student/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "학생 삭제")
  DeleteStudentResponse deleteStudent(@RequestBody DeleteStudentRequest req, HttpServletRequest request) {
    deleteStudentHandler.setHttpServletRequest(request);
    return deleteStudentHandler.execute(null, req);
  }

  private SelectStudentOneByIdHakbunHandler selectStudentOneByIdHakbunHandler;

  @RequestMapping(method = RequestMethod.GET, value = "student/select")
  @ApiOperation(value = "학생 개별 조회")
  SelectStudentOneByIdHakbunResponse selectStudentOneByIdHakbun(@RequestParam("studentId") long studentId, @RequestParam("studentHakbun") long studentHakbun, HttpServletRequest request) {
    selectStudentOneByIdHakbunHandler.setHttpServletRequest(request);
    SelectStudentOneByIdHakbunRequest req = new SelectStudentOneByIdHakbunRequest();
    req.setStudentId(studentId);
    req.setStudentHakbun(studentHakbun);
    return selectStudentOneByIdHakbunHandler.execute(null, req);
  }

  private SelectStudentListBySexNameAgeHandler selectStudentListBySexNameAgeHandler;

  @RequestMapping(method = RequestMethod.GET, value = "student/select/list")
  @ApiOperation(value = "학생 리스트 조회")
  SelectStudentListBySexNameAgeResponse selectStudentListBySexNameAge(@RequestParam("studentSex") int studentSex, @RequestParam("studentName") String studentName, HttpServletRequest request) {
    selectStudentListBySexNameAgeHandler.setHttpServletRequest(request);
    SelectStudentListBySexNameAgeRequest req = new SelectStudentListBySexNameAgeRequest();
    req.setStudentSex(studentSex);
    req.setStudentName(studentName);
    return selectStudentListBySexNameAgeHandler.execute(null, req);
  }
}

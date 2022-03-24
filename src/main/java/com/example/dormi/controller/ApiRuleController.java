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
public class ApiRuleController {
  static Logger logger = LoggerFactory.getLogger(ApiRuleController.class);

  private InsertRuleHandler insertRuleHandler;

  @RequestMapping(method = RequestMethod.POST, value = "rule/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "규칙 추가")
  InsertRuleResponse insertRule(@RequestBody InsertRuleRequest req, HttpServletRequest request) {
    insertRuleHandler.setHttpServletRequest(request);
    return insertRuleHandler.execute(null, req);
  }

  private DeleteRuleHandler deleteRuleHandler;

  @RequestMapping(method = RequestMethod.POST, value = "rule/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "규칙 삭제")
  DeleteRuleResponse deleteRule(@RequestBody DeleteRuleRequest req, HttpServletRequest request) {
    deleteRuleHandler.setHttpServletRequest(request);
    return deleteRuleHandler.execute(null, req);
  }
}

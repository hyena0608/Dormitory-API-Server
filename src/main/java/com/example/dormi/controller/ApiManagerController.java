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
public class ApiManagerController {
  static Logger logger = LoggerFactory.getLogger(ApiManagerController.class);

  private InsertManagerHandler insertManagerHandler;

  @RequestMapping(method = RequestMethod.POST, value = "manager/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "관리자 등록")
  InsertManagerResponse insertManager(@RequestBody InsertManagerRequest req, HttpServletRequest request) {
    insertManagerHandler.setHttpServletRequest(request);
    return insertManagerHandler.execute(null, req);
  }
}

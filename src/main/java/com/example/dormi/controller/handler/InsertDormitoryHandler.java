package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InsertDormitoryHandler extends BaseHandler {

  private final DormiMapper mapper;

  public InsertDormitoryResponse execute(CustomUserDetails user, InsertDormitoryRequest req) {
    InsertDormitoryResponse res = new InsertDormitoryResponse();

    final String dormitoryName = req.getDormitoryName();
    final String dormitoryAddress = req.getDormitoryAddress();

    if(emptyParam(dormitoryName) || emptyParam(dormitoryAddress)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      long dormiId = mapper.insertDormitory(dormitoryName, dormitoryAddress);

      res.setDormitoryId(dormiId);
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

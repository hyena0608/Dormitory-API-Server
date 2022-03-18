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
public class UpdateDormitoryHandler extends BaseHandler {

  private final DormiMapper mapper;

  public UpdateDormitoryResponse execute(CustomUserDetails user, UpdateDormitoryRequest req) {
    UpdateDormitoryResponse res = new UpdateDormitoryResponse();

    final long dormitoryId = req.getDormitoryId();
    final String dormitoryName = req.getDormitoryName();
    final String dormitoryAddress = req.getDormitoryAddress();

//    if(emptyParam(dormitoryId) || emptyParam(dormitoryName) || emptyParam(dormitoryAddress)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      long dormiId = mapper.updateDormitory(dormitoryId, dormitoryName, dormitoryAddress);

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

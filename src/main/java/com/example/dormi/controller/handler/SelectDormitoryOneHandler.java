package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.service.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;
import java.util.List;

@Slf4j
@Component
public class SelectDormitoryOneHandler extends BaseHandler {

  public SelectDormitoryOneResponse execute(CustomUserDetails user, SelectDormitoryOneRequest req) {
    SelectDormitoryOneResponse res = new SelectDormitoryOneResponse();

    final long dormitoryId = req.getDormitoryId();
    final String dormitoryName = req.getDormitoryName();

    if(emptyParam(dormitoryId) || emptyParam(dormitoryName)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {
      // code here
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

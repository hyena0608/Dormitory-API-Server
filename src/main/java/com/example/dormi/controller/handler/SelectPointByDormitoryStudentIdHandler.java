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
public class SelectPointByDormitoryStudentIdHandler extends BaseHandler {

  private final DormiMapper mapper;

  public SelectPointByDormitoryStudentIdResponse execute(CustomUserDetails user, SelectPointByDormitoryStudentIdRequest req) {
    SelectPointByDormitoryStudentIdResponse res = new SelectPointByDormitoryStudentIdResponse();

    final long dormitoryStudentId = req.getDormitoryStudentId();

    if(emptyParam(dormitoryStudentId)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      int totalPoint = mapper.selectPointByDormitoryStudentId(dormitoryStudentId);

      res.setRulePoint(totalPoint);
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

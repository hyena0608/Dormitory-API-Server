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
public class InsertStudentHandler extends BaseHandler {

  public InsertStudentResponse execute(CustomUserDetails user, InsertStudentRequest req) {
    InsertStudentResponse res = new InsertStudentResponse();

    final long studentHakbun = req.getStudentHakbun();
    final int studentSex = req.getStudentSex();
    final String student_name = req.getStudent_name();
    final int student_age = req.getStudent_age();

    if(emptyParam(studentHakbun) || emptyParam(studentSex) || emptyParam(student_name) || emptyParam(student_age)) {
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

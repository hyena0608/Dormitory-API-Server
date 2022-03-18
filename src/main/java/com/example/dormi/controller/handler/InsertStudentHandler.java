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
public class InsertStudentHandler extends BaseHandler {

  private final DormiMapper mapper;

  public InsertStudentResponse execute(CustomUserDetails user, InsertStudentRequest req) {
    InsertStudentResponse res = new InsertStudentResponse();

    final long studentHakbun = req.getStudentHakbun();
    final int studentSex = req.getStudentSex();
    final String studentName = req.getStudentName();
    final int studentAge = req.getStudentAge();

    if(emptyParam(studentHakbun) || emptyParam(studentSex) || emptyParam(studentName) || emptyParam(studentAge)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {
      long studentId = mapper.insertStudent(studentHakbun, studentSex, studentName, studentAge);

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

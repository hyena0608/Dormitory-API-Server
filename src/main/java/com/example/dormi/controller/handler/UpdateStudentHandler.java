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
public class UpdateStudentHandler extends BaseHandler {

  private final DormiMapper mapper;

  public UpdateStudentResponse execute(CustomUserDetails user, UpdateStudentRequest req) {
    UpdateStudentResponse res = new UpdateStudentResponse();

    final long studentId = req.getStudentId();
    final long studentHakbun = req.getStudentHakbun();
    final int studentSex = req.getStudentSex();
    final String studentName = req.getStudentName();
    final int studentAge = req.getStudentAge();

//    if(emptyParam(studentId) || emptyParam(studentHakbun) || emptyParam(studentSex)
//      || emptyParam(studentName) || emptyParam(studentAge)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      long student = mapper.updateStudent(studentId, studentHakbun, studentSex, studentName, studentAge);

      res.setStudentId(student);
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

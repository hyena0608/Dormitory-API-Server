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
public class DeleteStudentHandler extends BaseHandler {

  private final DormiMapper mapper;

  public DeleteStudentResponse execute(CustomUserDetails user, DeleteStudentRequest req) {
    DeleteStudentResponse res = new DeleteStudentResponse();

    final long studentId = req.getStudentId();
    final long studentHakbun = req.getStudentHakbun();

//    if(emptyParam(studentId) || emptyParam(studentHakbun)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      long student = mapper.deleteStudent(studentId, studentHakbun);

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

package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.controller.util.Converter;
import com.example.dormi.controller.vo.StudentInfo;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.StudentInfoVo;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SelectStudentOneByIdHakbunHandler extends BaseHandler {

  private final DormiMapper mapper;

  public SelectStudentOneByIdHakbunResponse execute(CustomUserDetails user,
                                                    SelectStudentOneByIdHakbunRequest req) {
    SelectStudentOneByIdHakbunResponse res = new SelectStudentOneByIdHakbunResponse();

    final long studentId = req.getStudentId();
    final long studentHakbun = req.getStudentHakbun();


//    if(emptyParam(studentId) || emptyParam(studentHakbun)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

    try {

      StudentInfoVo studentInfoVo = mapper.selectStudentOneByIdHakbun(studentId, studentHakbun);
      StudentInfo studentInfo = Converter.convert(studentInfoVo, StudentInfo.class);

      res.setStudentInfo(studentInfo);
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

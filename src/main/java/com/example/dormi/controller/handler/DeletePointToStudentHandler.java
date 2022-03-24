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
public class DeletePointToStudentHandler extends BaseHandler {

  private final DormiMapper mapper;

  public DeletePointToStudentResponse execute(CustomUserDetails user, DeletePointToStudentRequest req) {
    DeletePointToStudentResponse res = new DeletePointToStudentResponse();

    final long pointId = req.getPointId();

    if(emptyParam(pointId)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      long deletedPointId = mapper.deletePointToStudent(pointId);

      res.setPointId(deletedPointId);
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

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
public class DeleteDormitoryHandler extends BaseHandler {

  private final DormiMapper mapper;

  public DeleteDormitoryResponse execute(CustomUserDetails user, DeleteDormitoryRequest req) {
    DeleteDormitoryResponse res = new DeleteDormitoryResponse();

    final long dormitoryId = req.getDormitoryId();
    final String dormitoryName = req.getDormitoryName();

    if(emptyParam(dormitoryId) || emptyParam(dormitoryName)) {
      res.setCode(ResultCode.BadParams);
      return res;
    }

    try {

      long dormiId = mapper.deleteDormitory(dormitoryId, dormitoryName);

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

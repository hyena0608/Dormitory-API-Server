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
public class InsertPointToStudentHandler extends BaseHandler {

    private final DormiMapper mapper;

    public InsertPointToStudentResponse execute(CustomUserDetails user, InsertPointToStudentRequest req) {
        InsertPointToStudentResponse res = new InsertPointToStudentResponse();

        final long dormitoryStudentId = req.getDormitoryStudentId();
        final long ruleId = req.getRuleId();
        final long managerId = req.getManagerId();

        if (emptyParam(dormitoryStudentId) || emptyParam(ruleId) || emptyParam(managerId)) {
            res.setCode(ResultCode.BadParams);
            return res;
        }

        try {

            long pointId = mapper.insertPointToStudent(dormitoryStudentId, ruleId, managerId);

            res.setPointId(pointId);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

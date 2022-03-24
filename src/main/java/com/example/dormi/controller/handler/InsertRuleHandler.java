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
public class InsertRuleHandler extends BaseHandler {

    private final DormiMapper mapper;

    public InsertRuleResponse execute(CustomUserDetails user, InsertRuleRequest req) {
        InsertRuleResponse res = new InsertRuleResponse();

        final String ruleContent = req.getRuleContent();
        final int ruleType = req.getRuleType();
        final int rulePoint = req.getRulePoint();

        if (emptyParam(ruleContent) || emptyParam(ruleType) || emptyParam(rulePoint)) {
            res.setCode(ResultCode.BadParams);
            return res;
        }

        try {

            long ruldId = mapper.insertRule(ruleContent, ruleType, rulePoint);

            res.setRuleId(ruldId);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

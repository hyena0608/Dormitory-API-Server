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
public class DeleteRuleHandler extends BaseHandler {

    private final DormiMapper mapper;

    public DeleteRuleResponse execute(CustomUserDetails user, DeleteRuleRequest req) {
        DeleteRuleResponse res = new DeleteRuleResponse();

        final long ruleId = req.getRuleId();

        if (emptyParam(ruleId)) {
            res.setCode(ResultCode.BadParams);
            return res;
        }

        try {
            mapper.deletePointToStudetByRuleId(ruleId);
            long deletedRuleId = mapper.deleteRule(ruleId);

            res.setRuleId(deletedRuleId);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

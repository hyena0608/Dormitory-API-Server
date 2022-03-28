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
public class InsertManagerHandler extends BaseHandler {

    private final DormiMapper mapper;

    public InsertManagerResponse execute(CustomUserDetails user,
                                         InsertManagerRequest req) {
        InsertManagerResponse res = new InsertManagerResponse();

        final int managerAge = req.getManagerAge();
        final String managerName = req.getManagerName();

        if (emptyParam(managerAge) || emptyParam(managerName)) {
            res.setCode(ResultCode.BadParams);
            return res;
        }

        try {

            long managerId = mapper.insertManager(managerAge, managerName);

            res.setManagerId(managerId);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

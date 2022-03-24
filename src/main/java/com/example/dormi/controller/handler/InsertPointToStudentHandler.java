package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.PointInfoVo;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;

import java.util.List;
import java.util.stream.Collectors;

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

            if (!isAllExists(dormitoryStudentId, ruleId, managerId)) {
                res.setCode(ResultCode.Failed);
                return res;
            }

            int totalPoint = getStudentTotalPoint(dormitoryStudentId);
            if (totalPoint <= -60) {
                res.setCode(ResultCode.Failed);
                return res;
            }

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

    private int getStudentTotalPoint(long dormitoryStudentId) {
        List<PointInfoVo> pointInfoVoList = mapper.selectPoint(dormitoryStudentId);
        int answer = pointInfoVoList.stream().mapToInt(o -> (int) o.getPointId()).sum();
        return answer;
    }

    private boolean isAllExists(long dormitoryStudentId, long ruleId, long managerId) {
        return mapper.selectManagerByManagerId(managerId).getManagerId() == managerId &&
                mapper.selectDormitoryStudentByDormitoryStudentId(dormitoryStudentId)
                        .getDormitoryStudentId() == dormitoryStudentId &&
                mapper.selectRule(ruleId).getRuleId() == ruleId;
    }
}

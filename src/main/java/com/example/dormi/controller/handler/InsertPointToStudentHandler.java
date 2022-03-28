package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.DormitoryStudentInfoVo;
import com.example.dormi.mapper.vo.ManagerInfoVo;
import com.example.dormi.mapper.vo.PointInfoVo;
import com.example.dormi.mapper.vo.RuleInfoVo;
import com.example.dormi.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.example.dormi.controller.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
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

            isStudentDangerousPoint(dormitoryStudentId);

            isAllExist(dormitoryStudentId, ruleId, managerId);

            long pointId = mapper.insertPointToStudent(dormitoryStudentId, ruleId, managerId);
            res.setPointId(pointId);
            res.setCode(ResultCode.Success);

        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
        return res;
    }

    // FIXME : 인자 3개 !! 인자를 줄여보자자
   private void isAllExist(long dormitoryStudentId, long ruleId, long managerId)  {
        Optional<ManagerInfoVo> findManager =
                Optional.ofNullable(mapper.selectManagerByManagerId(managerId));
        if (findManager.isEmpty()) {
            throw new NullPointerException("해당 관리자가 존재하지 않습니다 !");
        }

        Optional<DormitoryStudentInfoVo> findDormitoryStudent =
                Optional.ofNullable(
                        mapper.selectDormitoryStudentByDormitoryStudentId(dormitoryStudentId));
        if (findDormitoryStudent.isEmpty()) {
            throw new NullPointerException("해당 기숙 학생이 존재하지 않습니다 !");
        }

        Optional<RuleInfoVo> findRule = Optional.ofNullable(mapper.selectRule(ruleId));
        if (findRule.isEmpty()) {
            throw new NullPointerException("해당 규칙이 존재하지 않습니다 !");
        }
    }

    private void isStudentDangerousPoint(long dormitoryStudentId) {
        List<PointInfoVo> pointInfoVoList = mapper.selectPoint(dormitoryStudentId);
        int answer = pointInfoVoList.stream().mapToInt(o -> (int) o.getPointId()).sum();
        if (answer <= -60) {
            throw new IllegalArgumentException("이 학생은 벌점 -60점을 넘었습니다. 퇴실해야 합니다.");
        }
    }

}

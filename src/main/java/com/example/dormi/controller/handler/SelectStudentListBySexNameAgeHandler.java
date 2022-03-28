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
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class SelectStudentListBySexNameAgeHandler extends BaseHandler {

    private final DormiMapper mapper;

    public SelectStudentListBySexNameAgeResponse execute(CustomUserDetails user,
                                                         SelectStudentListBySexNameAgeRequest req) {
        SelectStudentListBySexNameAgeResponse res = new SelectStudentListBySexNameAgeResponse();

        final int studentSex = req.getStudentSex();
        final String studentName = req.getStudentName();

//    if(emptyParam(studentSex) || emptyParam(studentName)) {
//      res.setCode(ResultCode.BadParams);
//      return res;
//    }

        try {

            List<StudentInfoVo> studentInfoVoList =
                    mapper.selectStudentListBySexNameAge(studentSex, studentName);
            List<StudentInfo> studentInfoList = studentInfoVoList
                    .stream()
                    .map(o -> Converter.convert(o, StudentInfo.class))
                    .collect(Collectors.toList());

            res.setStudentInfos(studentInfoList);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

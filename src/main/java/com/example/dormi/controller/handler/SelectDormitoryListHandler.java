package com.example.dormi.controller.handler;

import com.example.dormi.controller.request.*;
import com.example.dormi.controller.response.*;
import com.example.dormi.controller.util.Converter;
import com.example.dormi.controller.vo.DormitoryInfo;
import com.example.dormi.mapper.DormiMapper;
import com.example.dormi.mapper.vo.DormitoryInfoVo;
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
public class SelectDormitoryListHandler extends BaseHandler {

    private final DormiMapper mapper;

    public SelectDormitoryListResponse execute(CustomUserDetails user,
                                               SelectDormitoryListRequest req) {
        SelectDormitoryListResponse res = new SelectDormitoryListResponse();

        try {

            List<DormitoryInfoVo> dormitoryInfoVoList = mapper.selectDormitoryList();
            List<DormitoryInfo> dormitoryInfoList =
                    dormitoryInfoVoList
                            .stream()
                            .map(o -> Converter.convert(o, DormitoryInfo.class))
                            .collect(Collectors.toList());

            res.setDormitories(dormitoryInfoList);
            res.setCode(ResultCode.Success);
            return res;
        } catch (Exception e) {
            log.error(e.toString());
            res.setCode(ResultCode.Failed);
            return res;
        }
    }
}

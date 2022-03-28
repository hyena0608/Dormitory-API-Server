package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "기숙학생 점수 조회")
@Data
public class SelectPointByDormitoryStudentIdResponse extends BaseResponse {

  public int rulePoint = 0;
}

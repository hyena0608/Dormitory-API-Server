package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "상/벌점 정보")
@Data
public class PointInfo {

  public long pointId = 0;

  public long dormitoryStudentId = 0;

  public long ruleId = 0;

  public long managerId = 0;
}

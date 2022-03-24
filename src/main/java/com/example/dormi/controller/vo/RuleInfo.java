package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "규칙 정보")
@Data
public class RuleInfo {

  public long ruleId = 0;

  public String ruleContent = "";

  public int ruleType = 0;

  public int rulePoint = 0;
}

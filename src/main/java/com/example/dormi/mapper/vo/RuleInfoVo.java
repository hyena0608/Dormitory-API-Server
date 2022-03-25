package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class RuleInfoVo {

  public long ruleId;

  public String ruleContent;

  public int rulueType;

  public int rulePoint;
}

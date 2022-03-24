package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
public class RuleInfoVo {

  public long ruleId;

  public String ruleContent;

  public int rulueType;

  public int rulePoint;

  public LocalDate ruleDeleteDt;
}

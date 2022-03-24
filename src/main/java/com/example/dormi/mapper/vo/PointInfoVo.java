package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
public class PointInfoVo {

  public long pointId;

  public long dormitoryStudentId;

  public long ruleId;

  public long managerId;

  public LocalDate pointDeleteDt;
}

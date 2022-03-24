package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class PointInfoVo {

  public long pointId;

  public long dormitoryStudentId;

  public long ruleId;

  public long managerId;

  public  pointDeleteDt;
}

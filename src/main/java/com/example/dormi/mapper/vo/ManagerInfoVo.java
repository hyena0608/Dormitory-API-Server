package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class ManagerInfoVo {

  public long managerId;

  public String managerName;

  public int managerAge;
}

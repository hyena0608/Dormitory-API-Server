package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class ManagerInfoVo {

  public long manager_id;

  public String manager_name;

  public int manager_age;
}

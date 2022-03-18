package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class StudentInfoVo {

  public long studentHakbun;

  public int studentSex;

  public String studentName;

  public int studentAge;
}

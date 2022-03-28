package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class DormitoryStudentInfoVo {

  public long dormitoryStudentId;

  public int dormitoryStudentSemester;

  public long dormitoryId;

  public long roomId;

  public long studentId;

  public Timestamp dormitoryStudentDeleteDt;
}

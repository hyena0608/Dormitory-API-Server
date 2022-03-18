package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class DormitoryStudentInfoVo {

  public long dormitoryStudentId;

  public int dormitoryStudentSemester;

  public long dormitoryId;

  public long roomId;

  public long studentId;
}

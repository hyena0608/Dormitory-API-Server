package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "기숙학생 정보")
@Data
public class DormitoryStudentInfo {

  public long dormitoryStudentId = 0;

  public int dormitoryStudentSemester = 0;

  public long dormitoryId = 0;

  public long roomId = 0;

  public long studentId = 0;

  public Timestamp dormitoryStudentDeleteDt;
}

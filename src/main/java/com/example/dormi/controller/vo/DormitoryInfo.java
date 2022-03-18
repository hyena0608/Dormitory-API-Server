package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "기숙사 정보")
@Data
public class DormitoryInfo {

  public String dormitoryName = "";

  public String dormitoryAddress = "";
}

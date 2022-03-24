package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "관리자 정보")
@Data
public class ManagerInfo {

  public long managerId = 0;

  public String managerName = "";

  public int managerAge = 0;
}

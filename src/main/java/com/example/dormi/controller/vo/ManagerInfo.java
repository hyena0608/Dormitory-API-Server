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

  public long manager_id = 0;

  public String manager_name = "";

  public int manager_age = 0;
}

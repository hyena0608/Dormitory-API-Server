package com.example.dormi.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@ApiModel(description = "방 정보")
@Data
public class RoomInfo {

  public long roomNumber = 0;

  public int roomLimitCnt = 0;

  public int roomCurrentCnt = 0;

  public  roomDeleteDt;
}

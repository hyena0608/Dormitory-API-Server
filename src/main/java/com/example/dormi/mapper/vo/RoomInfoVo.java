package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class RoomInfoVo {

  public long roomNumber;

  public int roomLimitCnt;

  public int roomCurrentCnt;

  public Timestamp roomDeleteDt;
}

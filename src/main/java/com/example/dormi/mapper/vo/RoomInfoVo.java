package com.example.dormi.mapper.vo;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;

@Data
public class RoomInfoVo {

  public long roomNumber;

  public int roomLimitCnt;

  public int roomCurrentCnt;
}

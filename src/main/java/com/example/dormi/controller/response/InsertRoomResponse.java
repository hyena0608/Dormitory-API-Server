package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "방 저장")
@Data
public class InsertRoomResponse extends BaseResponse {

  public long roomdId = 0;
}

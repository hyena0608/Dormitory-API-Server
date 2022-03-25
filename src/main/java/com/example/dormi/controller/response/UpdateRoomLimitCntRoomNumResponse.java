package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "방 수정")
@Data
public class UpdateRoomLimitCntRoomNumResponse extends BaseResponse {

  public long roomdId = 0;
}

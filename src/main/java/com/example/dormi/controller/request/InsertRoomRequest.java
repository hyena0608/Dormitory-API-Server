package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "방 저장")
@Data
public class InsertRoomRequest {

  @ApiParam(value = "null", required = true)
  private long roomNumber;

  @ApiParam(value = "null", required = true)
  private int roomLimitCnt;
}

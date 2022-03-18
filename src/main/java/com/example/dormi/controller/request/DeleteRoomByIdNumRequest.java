package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "방 삭제")
@Data
public class DeleteRoomByIdNumRequest {

  @ApiParam(value = "null", required = true)
  private long roomId;

  @ApiParam(value = "null", required = true)
  private long roomNumber;
}

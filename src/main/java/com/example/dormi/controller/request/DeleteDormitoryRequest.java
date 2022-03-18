package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "기숙사 삭제")
@Data
public class DeleteDormitoryRequest {

  @ApiParam(value = "null", required = true)
  private long dormitoryId;

  @ApiParam(value = "null", required = true)
  private String dormitoryName;
}

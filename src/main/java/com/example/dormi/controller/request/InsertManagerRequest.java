package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "관리자 등록")
@Data
public class InsertManagerRequest {

  @ApiParam(value = "null", required = true)
  private int managerAge;

  @ApiParam(value = "null", required = true)
  private String managerName;
}

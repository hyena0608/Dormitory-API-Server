package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 점수 취소")
@Data
public class DeletePointToStudentRequest {

  @ApiParam(value = "null", required = true)
  private long pointId;
}

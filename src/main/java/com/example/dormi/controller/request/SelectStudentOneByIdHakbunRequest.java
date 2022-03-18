package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 개별 조회")
@Data
public class SelectStudentOneByIdHakbunRequest {

  @ApiParam(value = "null", required = true)
  private long studentId;

  @ApiParam(value = "null", required = true)
  private long studentHakbun;
}

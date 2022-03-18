package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 수정")
@Data
public class UpdateStudentRequest {

  @ApiParam(value = "null", required = true)
  private long studentId;

  @ApiParam(value = "null", required = true)
  private long studentHakbun;

  @ApiParam(value = "null", required = true)
  private int studentSex;

  @ApiParam(value = "null", required = true)
  private String studentName;

  @ApiParam(value = "null", required = true)
  private int studentAge;
}

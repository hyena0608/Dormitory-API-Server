package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 저장")
@Data
public class InsertStudentRequest {

  @ApiParam(value = "null", required = true)
  private long studentHakbun;

  @ApiParam(value = "null", required = true)
  private int studentSex;

  @ApiParam(value = "null", required = true)
  private String student_name;

  @ApiParam(value = "null", required = true)
  private int student_age;
}

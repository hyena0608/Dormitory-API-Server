package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 리스트 조회")
@Data
public class SelectStudentListBySexNameAgeRequest {

  @ApiParam(value = "null", required = true)
  private int studentSex;

  @ApiParam(value = "null", required = true)
  private String studentName;
}

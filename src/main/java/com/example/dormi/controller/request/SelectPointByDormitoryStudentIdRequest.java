package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "기숙학생 점수 조회")
@Data
public class SelectPointByDormitoryStudentIdRequest {

  @ApiParam(value = "null", required = true)
  private long dormitoryStudentId;
}

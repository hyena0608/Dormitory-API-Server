package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "학생 방에서 퇴실 (학기)")
@Data
public class UpdateDormitoryStudentOutRoomRequest {

  @ApiParam(value = "null", required = true)
  private long dormitoryStudentId;

  @ApiParam(value = "null", required = true)
  private long studentId;
}

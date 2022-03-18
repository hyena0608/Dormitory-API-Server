package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "학생 방에 입실 (학기)")
@Data
public class InsertDormitoryStudentInRoomResponse extends BaseResponse {

  public long dormitoryStudentId = 0;
}

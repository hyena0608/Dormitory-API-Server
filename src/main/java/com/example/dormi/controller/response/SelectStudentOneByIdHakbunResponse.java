package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.dormi.controller.vo.StudentInfo;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "학생 개별 조회")
@Data
public class SelectStudentOneByIdHakbunResponse extends BaseResponse {

  public StudentInfo studentInfo = null;
}

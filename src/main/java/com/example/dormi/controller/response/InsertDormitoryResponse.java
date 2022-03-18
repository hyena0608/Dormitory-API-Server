package com.example.dormi.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "기숙사 저장")
@Data
public class InsertDormitoryResponse extends BaseResponse {

  public long dormitoryId = 0;
}

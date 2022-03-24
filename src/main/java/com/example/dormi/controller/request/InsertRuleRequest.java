package com.example.dormi.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@ApiModel(description = "규칙 추가")
@Data
public class InsertRuleRequest {

  @ApiParam(value = "null", required = true)
  private String ruleContent;

  @ApiParam(value = "null", required = true)
  private int ruleType;

  @ApiParam(value = "null", required = true)
  private int rulePoint;
}

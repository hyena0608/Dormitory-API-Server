package com.example.dormi.controller;


public class ResultCode {

  public static final int Success = 0; // 성공

  public static final int Failed = -1; // 실패

  public static final int Unauthorized = 401; // Unauthorized

  public static final int NotFoundUser = 1000; // 사용자를 찾을 수 없습니다.

  public static final int BadParams = 10100; // 파라미터가 유효하지 않습니다.

  public static final int DbFailed = 99999; // DB 실패

  public static final int PeopleCntError = 20000; // 인원수 오류

  public static String get(int code) {
    switch(code) {
      case 0: return "성공";
      case -1: return "실패";
      case 401: return "Unauthorized";
      case 1000: return "사용자를 찾을 수 없습니다.";
      case 10100: return "파라미터가 유효하지 않습니다.";
      case 99999: return "DB 실패";
      case 20000: return "인원수 오류";
    }
    return "Uknown";
  }
}

package com.example.dormi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.dormi.mapper.vo.*;
import java.util.List;
@Mapper
public interface DormiMapper {

  long insertDormitoryStudentInRoom(@Param("dormitoryId") long dormitoryId, @Param("roomId") long roomId, @Param("studentId") long studentId, @Param("dormitoryStudentSemester") int dormitoryStudentSemester);

  long updateDormitoryStudentOutRoom(@Param("dormitoryStudentId") long dormitoryStudentId, @Param("studentId") long studentId);

  DormitoryStudentInfoVo selectDormitoryStudentByDormitoryStudentId(@Param("dormitoryStudentId") long dormitoryStudentId);

  List<DormitoryStudentInfoVo> selectDormitoryStudentByStudentId(@Param("studentId") long studentId);

  void updateDormitoryStudentDeleteDt(@Param("dormitoryStudentId") long dormitoryStudentId);

  long insertDormitory(@Param("dormitoryName") String dormitoryName, @Param("dormitoryAddress") String dormitoryAddress);

  long updateDormitory(@Param("dormitoryId") long dormitoryId, @Param("dormitoryName") String dormitoryName, @Param("dormitoryAddress") String dormitoryAddress);

  long deleteDormitory(@Param("dormitoryId") long dormitoryId, @Param("dormitoryName") String dormitoryName);

  DormitoryInfoVo selectDormitoryOne(@Param("dormitoryId") long dormitoryId, @Param("dormitoryName") String dormitoryName);

  List<DormitoryInfoVo> selectDormitoryList();

  long insertStudent(@Param("studentHakbun") long studentHakbun, @Param("studentSex") int studentSex, @Param("studentName") String studentName, @Param("studentAge") int studentAge);

  long updateStudent(@Param("studentId") long studentId, @Param("studentHakbun") long studentHakbun, @Param("studentSex") int studentSex, @Param("studentName") String studentName, @Param("studentAge") int studentAge);

  long deleteStudent(@Param("studentId") long studentId, @Param("studentHakbun") long studentHakbun);

  StudentInfoVo selectStudentOneByIdHakbun(@Param("studentId") long studentId, @Param("studentHakbun") long studentHakbun);

  List<StudentInfoVo> selectStudentListBySexNameAge(@Param("studentSex") int studentSex, @Param("studentName") String studentName);

  long insertRoom(@Param("roomNumber") long roomNumber, @Param("roomLimitCnt") int roomLimitCnt, @Param("dormitoryId") long dormitoryId);

  long updateRoomLimitCnt(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber, @Param("roomLimitCnt") int roomLimitCnt);

  long deleteRoomByIdNum(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber);

  RoomInfoVo selectRoomOneByIdNum(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber);

  List<RoomInfoVo> selectRoomListByLimitCnt(@Param("roomLimitCnt") int roomLimitCnt);

  long updateRoomCurrentCntByRoomId(@Param("roomId") long roomId, @Param("how") int how);

  long insertManager(@Param("managerAge") int managerAge, @Param("managerName") String managerName);

  ManagerInfoVo selectManagerByManagerId(@Param("managerId") long managerId);

  long insertPointToStudent(@Param("dormitoryStudentId") long dormitoryStudentId, @Param("ruleId") long ruleId, @Param("managerId") long managerId);

  long deletePointToStudent(@Param("pointId") long pointId);

  List<PointInfoVo> selectPoint(@Param("dormitoryStudentId") long dormitoryStudentId);

  void deletePointToStudetByRuleId(@Param("ruleId") long ruleId);

  long insertRule(@Param("ruleContent") String ruleContent, @Param("ruleType") int ruleType, @Param("rulePoint") int rulePoint);

  long deleteRule(@Param("ruleId") long ruleId);

  RuleInfoVo selectRule(@Param("ruleId") long ruleId);
}

package com.example.dormi.mapper;

import com.example.dormi.mapper.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DormiMapperService {

  @Autowired
   DormiMapper mapper;

  public long insertDormitoryStudentInRoom(long dormitoryId, long roomId, long studentId, int dormitoryStudentSemester) {
    return mapper.insertDormitoryStudentInRoom(dormitoryId, roomId, studentId, dormitoryStudentSemester);
  }

  public long updateDormitoryStudentOutRoom(long dormitoryStudentId, long studentId) {
    return mapper.updateDormitoryStudentOutRoom(dormitoryStudentId, studentId);
  }

  public DormitoryStudentInfoVo selectDormitoryStudentByDormitoryStudentId(long dormitoryStudentId) {
    return mapper.selectDormitoryStudentByDormitoryStudentId(dormitoryStudentId);
  }

  public List<DormitoryStudentInfoVo> selectDormitoryStudentByStudentId(long studentId) {
    return mapper.selectDormitoryStudentByStudentId(studentId);
  }

  public void updateDormitoryStudentDeleteDt(long dormitoryStudentId) {
    mapper.updateDormitoryStudentDeleteDt(dormitoryStudentId);
  }

  public List<DormitoryStudentInfoVo> selectDormitoryStudentByRoomId(long roomId) {
    return mapper.selectDormitoryStudentByRoomId(roomId);
  }

  public long insertDormitory(String dormitoryName, String dormitoryAddress) {
    return mapper.insertDormitory(dormitoryName, dormitoryAddress);
  }

  public long updateDormitory(long dormitoryId, String dormitoryName, String dormitoryAddress) {
    return mapper.updateDormitory(dormitoryId, dormitoryName, dormitoryAddress);
  }

  public long deleteDormitory(long dormitoryId, String dormitoryName) {
    return mapper.deleteDormitory(dormitoryId, dormitoryName);
  }

  public DormitoryInfoVo selectDormitoryOne(long dormitoryId, String dormitoryName) {
    return mapper.selectDormitoryOne(dormitoryId, dormitoryName);
  }

  public List<DormitoryInfoVo> selectDormitoryList() {
    return mapper.selectDormitoryList();
  }

  public long insertStudent(long studentHakbun, int studentSex, String studentName, int studentAge) {
    return mapper.insertStudent(studentHakbun, studentSex, studentName, studentAge);
  }

  public long updateStudent(long studentId, long studentHakbun, int studentSex, String studentName, int studentAge) {
    return mapper.updateStudent(studentId, studentHakbun, studentSex, studentName, studentAge);
  }

  public long deleteStudent(long studentId, long studentHakbun) {
    return mapper.deleteStudent(studentId, studentHakbun);
  }

  public StudentInfoVo selectStudentOneByIdHakbun(long studentId, long studentHakbun) {
    return mapper.selectStudentOneByIdHakbun(studentId, studentHakbun);
  }

  public List<StudentInfoVo> selectStudentListBySexNameAge(int studentSex, String studentName) {
    return mapper.selectStudentListBySexNameAge(studentSex, studentName);
  }

  public long insertRoom(long roomNumber, int roomLimitCnt, long dormitoryId) {
    return mapper.insertRoom(roomNumber, roomLimitCnt, dormitoryId);
  }

  public long updateRoomLimitCntRoomNum(long roomId, long roomNumber, int roomLimitCnt) {
    return mapper.updateRoomLimitCntRoomNum(roomId, roomNumber, roomLimitCnt);
  }

  public long deleteRoomByIdNum(long roomId, long roomNumber) {
    return mapper.deleteRoomByIdNum(roomId, roomNumber);
  }

  public RoomInfoVo selectRoomOneByIdNum(long roomId, long roomNumber) {
    return mapper.selectRoomOneByIdNum(roomId, roomNumber);
  }

  public List<RoomInfoVo> selectRoomListByLimitCnt(int roomLimitCnt) {
    return mapper.selectRoomListByLimitCnt(roomLimitCnt);
  }

  public long updateRoomCurrentCntByRoomId(long roomId, int how) {
    return mapper.updateRoomCurrentCntByRoomId(roomId, how);
  }

  public long insertManager(int managerAge, String managerName) {
    return mapper.insertManager(managerAge, managerName);
  }

  public ManagerInfoVo selectManagerByManagerId(long managerId) {
    return mapper.selectManagerByManagerId(managerId);
  }

  public long insertPointToStudent(long dormitoryStudentId, long ruleId, long managerId) {
    return mapper.insertPointToStudent(dormitoryStudentId, ruleId, managerId);
  }

  public long deletePointToStudent(long pointId) {
    return mapper.deletePointToStudent(pointId);
  }

  public List<PointInfoVo> selectPoint(long dormitoryStudentId) {
    return mapper.selectPoint(dormitoryStudentId);
  }

  public void deletePointToStudetByRuleId(long ruleId) {
    mapper.deletePointToStudetByRuleId(ruleId);
  }

  public int selectPointByDormitoryStudentId(long dormitoryStudentId) {
    return mapper.selectPointByDormitoryStudentId(dormitoryStudentId);
  }

  public long insertRule(String ruleContent, int ruleType, int rulePoint) {
    return mapper.insertRule(ruleContent, ruleType, rulePoint);
  }

  public long deleteRule(long ruleId) {
    return mapper.deleteRule(ruleId);
  }

  public RuleInfoVo selectRule(long ruleId) {
    return mapper.selectRule(ruleId);
  }
}

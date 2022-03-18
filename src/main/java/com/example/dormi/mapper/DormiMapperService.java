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

  public void updateDormitoryStudentOutRoom(long dormitoryStudentId, long studentId) {
    mapper.updateDormitoryStudentOutRoom(dormitoryStudentId, studentId);
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

  public StudentInfoVo selectStudentOneByIdHakbun(int studentId, long studentHakbun) {
    return mapper.selectStudentOneByIdHakbun(studentId, studentHakbun);
  }

  public List<StudentInfoVo> selectStudentListBySexNameAge(int studentSex, String studentName) {
    return mapper.selectStudentListBySexNameAge(studentSex, studentName);
  }

  public long insertRoom(long roomNumber, int roomLimitCnt) {
    return mapper.insertRoom(roomNumber, roomLimitCnt);
  }

  public long updateRoomLimitCnt(long roomId, long roomNumber, int roomLimitCnt) {
    return mapper.updateRoomLimitCnt(roomId, roomNumber, roomLimitCnt);
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
}

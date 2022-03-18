package com.example.dormi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.dormi.mapper.vo.*;
import java.util.List;
@Mapper
public interface DormiMapper {

  long insertDormitoryStudentInRoom(@Param("dormitoryId") long dormitoryId, @Param("roomId") long roomId, @Param("studentId") long studentId, @Param("dormitoryStudentSemester") int dormitoryStudentSemester);

  void updateDormitoryStudentOutRoom(@Param("dormitoryStudentId") long dormitoryStudentId, @Param("studentId") long studentId);

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

  long insertRoom(@Param("roomNumber") long roomNumber, @Param("roomLimitCnt") int roomLimitCnt);

  long updateRoomLimitCnt(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber, @Param("roomLimitCnt") int roomLimitCnt);

  long deleteRoomByIdNum(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber);

  RoomInfoVo selectRoomOneByIdNum(@Param("roomId") long roomId, @Param("roomNumber") long roomNumber);

  List<RoomInfoVo> selectRoomListByLimitCnt(@Param("roomLimitCnt") int roomLimitCnt);
}

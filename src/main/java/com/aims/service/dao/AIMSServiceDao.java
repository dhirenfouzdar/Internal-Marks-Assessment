package com.aims.service.dao;

import java.util.List;

import com.aims.entity.IAEntity;
import com.aims.entity.LectureProfileEntity;
import com.aims.entity.LectureSubjectEntity;
import com.aims.entity.StudentProfileEntity;
import com.aims.entity.UserEntity;

/**
 * (C) SVARKS corporation
 *
 * File: AIMSServiceDaoImpl.java
 *Project Title: Attendance and internal assessment Management System
 * @version: 1.0 
 * Purpose: To facilitate the automation of attendance and internal assessment process
 * @author: Rajesh K 
 * Start Date: 23-08-2015
 * End Date: 
 * Limitations: 
 * Bug Id: 
 * Changes: 
 * Changed by: 
 * Changed on:
 *
 */
public interface AIMSServiceDao {
	public int validateUser(String usn,String password);
	public void addCredentials(UserEntity userEntity);
	public void updateUserdetails(UserEntity userEntity);
	public List<UserEntity> getLecturerList();
	public boolean isUserExists(String year);
	public void addUser(List<UserEntity> userList);
	public void updateUserDetails(UserEntity userentity);
	public List<UserEntity> getUsersByYear(String year);
	public boolean isMobileNumberExists(String mobileNumber);
	public void addLecturerProfile(LectureProfileEntity lectureProfileEntity);
	public void updateLecturerProfile(LectureProfileEntity lectureProfileEntity);
	public void addStudentProfile(StudentProfileEntity studentProfileEntity);
	public void updateStudentProfile(StudentProfileEntity studentProfileEntity);
	public void deleteUser(Integer id);
	public void deleteLecture(Integer id);
	public void deleteStudent(Integer id);
	public List<LectureProfileEntity> getLProfile(String usn);
    public List<StudentProfileEntity> getSProfile(String usn);
    public List<StudentProfileEntity> getStudentList(String yearOfPassing);
    public void updateSemDetails(String yearOfPassing, String sem);
    public void updateSubjectDetails(String yearOfPassing, String subject);
    public void addLectureSubject(LectureSubjectEntity lectureSubjectEntity);
	public List<LectureSubjectEntity> getSubjectList();
	public void deleteSubject(Integer id);
	public List<LectureSubjectEntity> getLecturerSubject(String empId);
	public LectureSubjectEntity getSubjectDetailsByName(String subject);
	public void addIAMDetails(IAEntity iAEntity);
	public List<IAEntity> getInternalDetails(String yearOfPassing, String subject);
	public void updateIAMarks(IAEntity iAEntity);
	public void updateAverageMarks(IAEntity iAEntity);
	public List<IAEntity> displayStudentDetail(String usn, String sem, String subject);
	public boolean validatePassword(String usn, String currentPassword);
	public void resetPassword(Integer usnValue,String newPassword);
	public Integer FindById(String usn);




}

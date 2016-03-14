package com.aims.service.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aims.entity.IAEntity;
import com.aims.entity.LectureProfileEntity;
import com.aims.entity.LectureSubjectEntity;
import com.aims.entity.StudentProfileEntity;
import com.aims.entity.UserEntity;
import com.aims.hibernate.listener.HibernateListener;
import com.aims.service.dao.AIMSServiceDao;
import com.sun.mail.iap.ParsingException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * (C) SVARKS corporation
 * 
 * File: AIMSServiceDaoImpl.java Project Title: Attendance and internal
 * assessment Management System
 * 
 * @version: 1.0 Purpose: To facilitate the automation of attendance and
 *           internal assessment process
 * @author: Rajesh K Start Date: 23-08-2015 End Date: Limitations: Bug Id:
 *          Changes: Changed by: Changed on:
 * 
 */

public class AIMSServiceDaoImpl implements AIMSServiceDao {

	private static Logger LOG = Logger.getLogger(AIMSServiceDaoImpl.class);
	private Session session = HibernateListener.getSessionFactory()
			.openSession();
	Transaction transaction = null;

	public int validateUser(String usn, String password) {
		LOG.info("Getting into validateUser method in DAOImpl");
		LOG.info("****USN:****" + usn);
		LOG.info("*****PASSWORD****" + password);
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from UserEntity u where u.usn = :usn  and u.password = :pass");
			query.setParameter("usn", usn);
			query.setParameter("pass", password);
			LOG.info(query);
			@SuppressWarnings("unchecked")
			List<UserEntity> userlist = query.list();
			if (userlist.size() > 0) {
				for (UserEntity userEntity : userlist) {
					if (userEntity.getUsertype().equals("admin"))
						return 1;
					else if (userEntity.getUsertype().equals("lecturer"))
						return 4;
					else {
						if (userEntity.getIsFirstTimeLogin()) {
							LOG.info("*************Is First Time Login Value::"
									+ userEntity.getIsFirstTimeLogin());
							UserEntity userEntity1 = (UserEntity) session.get(
									UserEntity.class, userEntity.getId());
							if (userEntity1 != null) {
								userEntity1.setIsFirstTimeLogin(false);
								session.update(userEntity1);
								transaction.commit();
							}
							return 3;
						} else {
							return 2;
						}
					}
				}
			}
			return 0;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception while validating usn and password:" + e);
			return 0;
		}
	}

	@Override
	public void addCredentials(UserEntity userEntity) {
		try {
			transaction = session.beginTransaction();
			session.save(userEntity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception while adding branch details:" + e);
		}
	}

	@Override
	public void updateUserdetails(UserEntity userEntity) {
		LOG.info("Getting info updateBranchdetails");
		try {
			LOG.info("Admin updating user Profile");
			transaction = session.beginTransaction();
			UserEntity user = (UserEntity) session.get(UserEntity.class,
					userEntity.getId());
			LOG.info("**USN updating***" + user.getId());
			if (user != null) {
				user.setUsn(userEntity.getUsn());
				// user.setGraduationType(userEntity.getGraduationType());
				user.setModifiedDate(new Date());
				session.update(user);
				LOG.info("Details Updated Successfully for:"
						+ user.getId());

			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updatingCompanyDetails ::" + e);
		}

	}

	@Override
	public List<UserEntity> getLecturerList() {
		List<UserEntity> userEntityList = null;
		try {
			userEntityList = new ArrayList<UserEntity>();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from UserEntity u where u.usertype= :usertype");
			query.setParameter("usertype", "lecturer");
			userEntityList = query.list();
			LOG.info("userListSize in dao:::::" + userEntityList.size());
		} catch (Exception e) {
			LOG.error("Exception while Getting user details:" + e);
		}
		return userEntityList ;
	}

	@Override
	public void addUser(List<UserEntity> userList) {
		LOG.info("Getting into addUser From method in DAOImpl");
		LOG.info("UserLIst size:::" + userList.size());
		try {
			for (UserEntity users : userList) {
				LOG.info("users::" + users.getUsn());
				transaction = session.beginTransaction();
				session.save(users);
				transaction.commit();
			}
		} catch (Exception e) {

			LOG.error("Exception occured in addUser:" + e);
		}

	}

	@Override
	public void updateUserDetails(UserEntity userentity) {
		LOG.info("Getting UpdateUserDetails method in DAOImpl");
		transaction = null;
		try {
			LOG.info("Updating UserEntity details admin..");
			transaction = session.beginTransaction();
			UserEntity uEntity = (UserEntity) session.get(UserEntity.class,
					userentity.getId());
			if (uEntity != null) {
				uEntity.setUsn(uEntity.getUsn());
				uEntity.setBranch(uEntity.getBranch());
				uEntity.setModifiedDate(new Date());
				uEntity.setGraduationType(uEntity.getGraduationType());
				uEntity.setYearOfJoining(uEntity.getYearOfJoining());
				uEntity.setYearOfPassing(uEntity.getYearOfPassing());
				session.update(uEntity);
				transaction.commit();
				LOG.info("UserDetials Updated Successfully:");
			}
		} catch (Exception e) {
			LOG.error("Exception occured while updating UserDetails ::" + e);
		}

	}

	@Override
	public boolean isUserExists(String year) {
		LOG.info("Getting into isUserExists method in DAOImpl");
		try {
			transaction = session.beginTransaction();
			List<UserEntity> userList = null;

			Query query = session
					.createQuery("from UserEntity u where u.yearOfJoining = ? and u.usertype= ? order by usn asc");
			query.setParameter(0, year);
			query.setParameter(1, "student");
			userList = query.list();
			if (userList.size() > 0 && !userList.isEmpty()) {
				LOG.info("UserExists for this" + "Year" + year + "in dao");
				return true;
			} else
				return false;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception while UserExists::" + e);
			return false;
		}
	}

	@Override
	public List<UserEntity> getUsersByYear(String year) {
		LOG.info("Getting into getUsersByYear method in DAOImpl");
		try {
			transaction = session.beginTransaction();
			LOG.info("*********Admin Student Grid in DAO class*****************");
			List<UserEntity> userList = null;
			Query query = session
					.createQuery("from UserEntity u where u.yearOfPassing = ? and u.usertype= ? order by usn asc");
			query.setParameter(0, year);
			query.setParameter(1, "student");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception while getting getUsersByBranchAndYear::" + e);
			return null;
		}/*
		 * finally { session.close(); }
		 */
	}

	@Override
	public boolean isMobileNumberExists(String mobileNumber) {
		LOG.info("Getting into isMobileNumberExists method in DAOImpl");
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from LectureProfileEntity l where l.mobileNumber = :mobileNumber");
			query.setParameter("mobileNumber", mobileNumber);
			List<LectureProfileEntity> list = query.list();
			transaction.commit();
			if (list.size() > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			LOG.error("Exception occured while checking mobile number:" + e);
			return false;
		}
	}

	@Override
	public void addLecturerProfile(LectureProfileEntity lectureProfileEntity) {
		try {
			LOG.info("Admin adding Lecturer Profile");

			transaction = session.beginTransaction();
			session.save(lectureProfileEntity);
			transaction.commit();
		} catch (Exception e) {
			LOG.error("Exception while adding lecturer profile details:" + e);
		}
	}

	@Override
	public void updateLecturerProfile(LectureProfileEntity lectureProfileEntity) {
		LOG.info("Getting info updateLecturerProfile************");
		try {
			LOG.info("Admin updating update Lecturer Profile");
			transaction = session.beginTransaction();
			LectureProfileEntity lEntity = (LectureProfileEntity) session.get(
					LectureProfileEntity.class, lectureProfileEntity.getId());
			LOG.info("**Profile Id while updating***" + lEntity.getId());
			if (lEntity != null) {
				lEntity.setFirstName(lectureProfileEntity.getFirstName());
				lEntity.setLastName(lectureProfileEntity.getLastName());
				lEntity.setMobileNumber(lectureProfileEntity.getMobileNumber());
				lEntity.setAlternateNumber(lectureProfileEntity.getAlternateNumber());
				lEntity.setDesignation(lectureProfileEntity.getDesignation());
				lEntity.setGender(lectureProfileEntity.getGender());
				lEntity.setEmailId(lectureProfileEntity.getEmailId());
				lEntity.setModifiedDate(new Date());
				session.update(lEntity);
				LOG.info("Profile Details Updated Successfully for:"
						+ lEntity.getFirstName());
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updatingProfileDetails ::" + e);
		}

	}

	@Override
	public void addStudentProfile(StudentProfileEntity studentProfileEntity) {
		try {
			LOG.info("Student adding Profile");
			transaction = session.beginTransaction();
			session.save(studentProfileEntity);
			transaction.commit();
		} catch (Exception e) {
			LOG.error("Exception while adding Student profile details:" + e);
		}
	}

	@Override
	public void updateStudentProfile(StudentProfileEntity studentProfileEntity) {
		LOG.info("Getting info updateLecturerProfile************");
		try {
			LOG.info("Admin updating update Lecturer Profile");
			transaction = session.beginTransaction();
			StudentProfileEntity sEntity = (StudentProfileEntity) session.get(
					StudentProfileEntity.class, studentProfileEntity.getId());
			LOG.info("**Profile Id while updating***" + sEntity.getId());
			if (sEntity != null) {
				sEntity.setFirstName(studentProfileEntity.getFirstName());
				sEntity.setLastName(studentProfileEntity.getLastName());
				sEntity.setMobileNumber(studentProfileEntity.getMobileNumber());
				sEntity.setAlternateNumber(studentProfileEntity
						.getAlternateNumber());
				sEntity.setAddress(studentProfileEntity.getAddress());
				sEntity.setEmailId(studentProfileEntity.getEmailId());
				sEntity.setGender(studentProfileEntity.getGender());
				sEntity.setYearofpassing(studentProfileEntity.getYearofpassing());
				sEntity.setModifiedDate(new Date());
				session.update(sEntity);
				LOG.info("Profile Details Updated Successfully for:"
						+ sEntity.getFirstName());
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updatingProfileDetails ::" + e);
		}

	}

	@Override
	public void deleteUser(Integer id) {
		 LOG.info("Deleting user details::"+id);
		  try {
	   LOG.info("Admin deleting user Details");
	   transaction = session.beginTransaction();
	   UserEntity userEntity = (UserEntity) session.get(
			   UserEntity.class, id);
	   if (userEntity != null) {
	    session.delete(userEntity);
	    transaction.commit();
	    LOG.info("**Deleted user detail successfully::**" + userEntity.getId());
	   }
	  }catch (Exception e) {
	   if(transaction != null)
	    transaction.commit();
	   LOG.error("Exception occured while deleting user ::" + e);
	  }

	}
	@Override
	public void deleteLecture(Integer id) {
		 LOG.info("Deleting Lecture details::"+id);
		  try {
	  LOG.info("Admin deleting lectureProfile Details");
	  transaction = session.beginTransaction();
	  LectureProfileEntity lectureProfileEntity = (LectureProfileEntity) session.get(
			  LectureProfileEntity.class, id);
	  if (lectureProfileEntity != null) {
	   session.delete(lectureProfileEntity);
	   transaction.commit();
	   LOG.info("**Deleted lecture detail successfully::**" + lectureProfileEntity.getId());
	  }
	 }catch (Exception e) {
	  if(transaction != null)
	   transaction.commit();
	  LOG.error("Exception occured while deleting room ::" + e);
	 }
	}

	@Override
	public void deleteStudent(Integer id) {
		 LOG.info("Deleting Student details::"+id);
		  try {
	   LOG.info("Admin deleting studentProfile Details");
	   transaction = session.beginTransaction();
	   StudentProfileEntity studentProfileEntity = (StudentProfileEntity) session.get(
			   StudentProfileEntity.class, id);
	   if (studentProfileEntity != null) {
	    session.delete(studentProfileEntity);
	    transaction.commit();
	    LOG.info("**Deleted user detail successfully::**" + studentProfileEntity.getId());
	   }
	  }catch (Exception e) {
	   if(transaction != null)
	    transaction.commit();
	   LOG.error("Exception occured while deleting student ::" + e);
	  }

	}


	public List<StudentProfileEntity> getStudentList(String yearOfPassing) {
		LOG.info("Getting into getPlacedStudentsByCompanyNameAndYear method in DAOImpl");
		List<StudentProfileEntity> studentuserList = null;
		try {
			transaction = session.beginTransaction();
		Query query = session
				.createQuery("from StudentProfileEntity u where  u.yearofpassing = :yearOfPassing");
		query.setParameter("yearOfPassing", yearOfPassing);
		studentuserList = query.list();
		transaction.commit();
		return studentuserList;
		}catch (Exception e) {
			LOG.error("Exception occured while getting getStudentList ::" + e);
			return null;
		}
	}

	@Override
	public List<LectureProfileEntity> getLProfile(String usn) {
		List<LectureProfileEntity> lecturerProfileList = null;
		transaction = session.beginTransaction();
		LOG.info("*****usn in impl******"+usn);
		Query query = session.createQuery("from LectureProfileEntity u where u.usn = :usn");
		query.setParameter("usn", usn);
		LOG.info(query);
		lecturerProfileList = query.list();
		return lecturerProfileList;
	}

	@Override
	public List<StudentProfileEntity> getSProfile(String usn) {
		List<StudentProfileEntity> studentProfileList = null;
		transaction = session.beginTransaction();
		LOG.info("*****usn in impl******"+usn);
		Query query = session.createQuery("from StudentProfileEntity u where u.usn = :usn");
		query.setParameter("usn", usn);
		LOG.info(query);
		studentProfileList = query.list();
		return studentProfileList;
	}

	@Override
	public void updateSemDetails(String yearOfPassing, String sem) {
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("Update StudentProfileEntity s set s.sem = :sem  where s.yearofpassing = :year");
			query.setParameter("sem", sem);
			query.setParameter("year", yearOfPassing);
			int result = query.executeUpdate();
			if (result > 0) {
				LOG.info("****Sem updated successfully***"+yearOfPassing);
			}
			transaction.commit();
			} catch (Exception e) {
			LOG.error("Exception while Getting user details:" + e);
		}
		
	}

	@Override
	public void updateSubjectDetails(String yearOfPassing, String subject) {
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("Update StudentProfileEntity s set s.subject = :subject  where s.yearofpassing = :year");
			query.setParameter("subject", subject);
			query.setParameter("year", yearOfPassing);
			int result = query.executeUpdate();
			if (result > 0) {
				LOG.info("****subject updated successfully for***"+yearOfPassing);
			}
			transaction.commit();
			} catch (Exception e) {
			LOG.error("Exception while Getting user details:" + e);
		}
		
	}

	@Override
	public void addLectureSubject(LectureSubjectEntity lectureSubjectEntity) {
		try {
			transaction = session.beginTransaction();
			session.save(lectureSubjectEntity);
			transaction.commit();
		} catch (Exception e) {
			LOG.error("Exception while adding subject details:" + e);
		}
	}

	@Override
	public List<LectureSubjectEntity> getSubjectList() {
		List<LectureSubjectEntity> lectureSubjectList = null;
		try {
			lectureSubjectList = new ArrayList<LectureSubjectEntity>();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from LectureSubjectEntity");
			lectureSubjectList = query.list();
			LOG.info("userListSize in dao:::::" + lectureSubjectList.size());
		} catch (Exception e) {
			LOG.error("Exception while Getting subject details:" + e);
		}
		return lectureSubjectList ;
	}

	@Override
	public void deleteSubject(Integer id) {
		 LOG.info("Deleting subject details::"+id);
		  try {
	   LOG.info("Lecture deleting subject Details");
	   transaction = session.beginTransaction();
	   LectureSubjectEntity sEntity = (LectureSubjectEntity) session.get(
			   LectureSubjectEntity.class, id);
	   if (sEntity != null) {
	    session.delete(sEntity);
	    transaction.commit();
	    LOG.info("**Deleted subject detail successfully::**" + sEntity.getId());
	   }
	  }catch (Exception e) {
	   if(transaction != null)
	    transaction.commit();
	   LOG.error("Exception occured while deleting subject ::" + e);
	  }

	}

	@Override
	public List<LectureSubjectEntity> getLecturerSubject(String empId) {
		List<LectureSubjectEntity> lecSubList = null;
		try {
			lecSubList = new ArrayList<LectureSubjectEntity>();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from LectureSubjectEntity l where l.usn= :empId");
			query.setParameter("empId", empId);
			lecSubList = query.list();
			LOG.info("userListSize in dao:::::" + lecSubList.size());
		} catch (Exception e) {
			LOG.error("Exception while Getting user details:" + e);
		}
		return lecSubList ;
	}

	@Override
	public LectureSubjectEntity getSubjectDetailsByName(String subject) {
		List<LectureSubjectEntity> lecSubList = null;
		try {
			lecSubList = new ArrayList<LectureSubjectEntity>();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from LectureSubjectEntity l where l.subject= :subject");
			query.setParameter("subject", subject);
			lecSubList = query.list();
			if(lecSubList != null && lecSubList.size() !=0){
				return lecSubList.get(0);
			}
			LOG.info("userListSize in dao:::::" + lecSubList.size());
		} catch (Exception e) {
			LOG.error("Exception while Getting user details:" + e);
		}
		return null;
	}

	@Override
	public void addIAMDetails(IAEntity iAEntity) {
		LOG.info("Getting into addIAMDetails From method in DAOImpl");
		try {
			LOG.info("IAAction adding IAA details:");
			transaction = session.beginTransaction();
			session.save(iAEntity);
			transaction.commit();
		} catch (Exception e) {
			LOG.error("Exception while adding lecturer profile details:" + e);
		}
		
	}

	@Override
	public List<IAEntity> getInternalDetails(String yearOfPassing, String subject) {
		List<IAEntity> iAEntity = new ArrayList<IAEntity>();
		try {
			iAEntity =null;
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from IAEntity l where l.yearofpassing= :yearOfPassing and l.subject=:subject");
			query.setParameter("yearOfPassing", yearOfPassing);
			query.setParameter("subject", subject);
			iAEntity = query.list();
			if(iAEntity != null && iAEntity.size() !=0)
				return iAEntity;
			LOG.info("userListSize in dao:::::" + iAEntity.size());
		} catch (Exception e) {
			LOG.error("Exception while getting internalDetails:" + e);
			return null;
		}
		return null ;
	}

	@Override
	public void updateIAMarks(IAEntity iAEntity) {
		LOG.info("Getting info updateLecturerProfile************");
		try {
			LOG.info("Admin updating update Lecturer Profile");
			transaction = session.beginTransaction();
			IAEntity iEntity = (IAEntity) session.get(
					IAEntity.class, iAEntity.getId());
			LOG.info("**Profile Id while updating***" + iEntity.getId());
			if (iEntity != null) {
				
				iEntity.setTest1(iAEntity.getTest1());
				iEntity.setTest2(iAEntity.getTest2());
				iEntity.setTest3(iAEntity.getTest3());
				iEntity.setModifiedDate(new Date());
				session.update(iEntity);
				LOG.info("Profile Details Updated Successfully for:"
						+ iEntity.getUsn());
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updateIAMarks ::" + e);
		}

	}

	@Override
	public void updateAverageMarks(IAEntity iAEntity) {
		LOG.info("Getting info updateAverageMarks************");
		try {
			LOG.info("Admin updating update average marks");
			transaction = session.beginTransaction();
			IAEntity iEntity = (IAEntity) session.get(
					IAEntity.class, iAEntity.getId());
			LOG.info("**Profile Id while updating***" + iEntity.getId());
			if (iEntity != null) {
				iEntity.setAverageMarks(iAEntity.getAverageMarks());
				iEntity.setModifiedDate(new Date());
				session.update(iEntity);
				LOG.info("Average Details Updated Successfully for:"
						+ iEntity.getUsn());
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updateAverageMarks ::" + e);
		}

	}

	@Override
	public List<IAEntity> displayStudentDetail(String usn, String sem, String subject) {
		List<IAEntity> iAEntity = new ArrayList<IAEntity>();
		LOG.info("usn"+usn);
		LOG.info("sem:"+sem);
		LOG.info("subject:"+subject);
		try {
			iAEntity =null;
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from IAEntity i where i.usn =:usn and i.sem =:sem and i.subject=:subject ");
			query.setParameter("usn", usn);
			query.setParameter("sem", sem);
			query.setParameter("subject", subject);
			iAEntity = query.list();
			iAEntity = query.list();
			if(iAEntity != null && iAEntity.size() !=0)
				return iAEntity;
			LOG.info("IAENTITY in dao:::::" + iAEntity.size());
		} catch (Exception e) {
			LOG.error("Exception while getting internalDetails:" + e);
			return null;
		}
		return null ;
	}

	@Override
	public boolean validatePassword(String usn, String currentPassword) {
		LOG.info("Getting into validatePassword method in DAOImpl");
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from UserEntity u where u.usn = :usn and u.password = :pass");
			query.setParameter("usn", usn);
			query.setParameter("pass", currentPassword);
			LOG.info(query);
			List<UserEntity> list = query.list();
		     transaction.commit();
		if (list != null && list.size() > 0) {
			LOG.info("Old password matches");
			return true;
		} else{
			LOG.info("Old password not matches");
			return false;
		}
		} catch (Exception e) {
			/*if (transaction != null)
				transaction.rollback();*/
			LOG.error("Exception occured while adding Company ::" + e);
			return false;
		}
	}

	@Override
	public void resetPassword(Integer usnValue, String newPassword) {
		LOG.info("Getting into resetPassword method in DAOImpl");
		try {
			LOG.info("Updating password..");
			transaction = session.beginTransaction();
			UserEntity userEntity = (UserEntity) session.get(UserEntity.class,usnValue);
			if (userEntity != null) {
				userEntity.setPassword(newPassword);
				session.update(userEntity);
				LOG.info("Password Updated Successfully:");
				transaction.commit();
			}
		}catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception occured in updateStudent ::" + e);
		}

	}

	@Override
	public Integer FindById(String usn) {
		LOG.info("Getting into FindById method in DAOImpl");
        try{
      	  transaction = session.beginTransaction();
      	  Query query = session.createQuery("from UserEntity u where u.usn = ?");
    		query.setParameter(0, usn);
		List<UserEntity> list = query.list();
		transaction.commit();
		if (list.size() > 0) {
			LOG.info("Getting Id by usn id::"+list.get(0).getId());
			return list.get(0).getId();
		} else
			return null;
        }catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			LOG.error("Exception while finding Id ::" + e);
			return null;
		}
	}

}
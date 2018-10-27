package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.examsys.business.dao.ClassDao;
import com.lingnan.examsys.business.dao.ExaminationDao;
import com.lingnan.examsys.business.dao.RecordDao;
import com.lingnan.examsys.business.dao.Stu_ClassDao;
import com.lingnan.examsys.business.dao.Tea_ClassDao;
import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class Tstudent_managementServiceImpl implements Tstudent_managementService{
	 
		//测试用指示常量：输出程序执行到的类名
			private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
			
			/**
			 * 用户Service类唯一实例(饿汉式)
			 */
			private static Tstudent_managementServiceImpl Tstudent_managementService = new Tstudent_managementServiceImpl();
			
			/**
			 * 获取唯一的Service实例
			 * @return Service实例
			 */
			public static Tstudent_managementService getInstance() {
				return Tstudent_managementService;
			}
			/**
			 * 黄润志2018.08.11
			 * 查看排名
			 */
			public List<RankingVO> findStudentAnswerRank(int user_id){
				Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
				List<RankingVO> list = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
					Tea_ClassDao RankingMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
					//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
					list = RankingMgrDao.findStudentAnswerRank(user_id);
				}catch(DaoException e){
					throw e;
				}catch(Exception e){
					throw new ServiceException("1Service:查找答题排名信息错误：",e);
				}finally{
					DBUtils.closeConnection(conn);
				}
				
				return list;
			}
			/**
			 * 查看学生答题记录
			 */
			public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user){
				Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
				List<Ans_RecordVO> list = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
					RecordDao RecordMgrDao = (RecordDao)DaoFactory.getDao(conn,EnumType.RECORD_DAO);			
					//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
					list = RecordMgrDao.findStudentAnswerRecord(user);
				}catch(DaoException e){
					throw e;
				}catch(Exception e){
					throw new ServiceException("1Service:查找答题记录错误：",e);
				}finally{
					DBUtils.closeConnection(conn);
				}
				
				return list;
			}
			/**
			 * 查看该老师所教班级
			 */
			public List<ClassVO> findClassByTeaId(int user_id){
				Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
				List<ClassVO> list = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
					Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
					//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
					list = classMgrDao.findClassByTeaId(user_id);
				}catch(DaoException e){
					throw e;
				}catch(Exception e){
					throw new ServiceException("1Service:查找班级信息错误：",e);
				}finally{
					DBUtils.closeConnection(conn);
				}
				
				return list;
			}
			
			/**
			 * 查找该班级是否存在
			 */
			 public boolean findClassByClassName(String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					boolean flag = false;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						flag = classMgrDao.findClassByClassName(class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:判断该班级是否存在时信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					return flag;
			 }
			 /**
			  * 查找该老师没教过的班级
			  */
			 public List<ClassVO> findNotClassByTeaId(int user_id){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					List<ClassVO> list = null;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						list = classMgrDao.findNotClassByTeaId(user_id);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:查找班级信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					
					return list;
			 }
			 /**
			  *该班级存在则查找该老师是否已经添加过该班级
			  */
			 
			 public boolean findClassByClassid(String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					boolean flag = false;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						flag = classMgrDao.findClassByClassid(class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:判断该班级是否被该老师添加过时信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					
					return flag;
			 }
			 /**
			  * 根据班级名查找班级编号
			  */
			 public ClassVO findClassIdByClassname(String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					ClassVO list = null;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						list = classMgrDao.findClassIdByClassname(class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:查找班级编号信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					
					return list;
			 }
			 /**
			  *  该班级存在并还未被该老师添加过则插入老师班级表
			  */
			 public  boolean insertClassByClassName(Tea_ClassVO tea_class){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					boolean flag = false;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						flag = classMgrDao.insertClassByClassName(tea_class);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:添加教师班级时信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					return flag;
			 }
			 /**
			  * 删除教师班级
			  */
			 public  boolean deleteTeaClass(ClassVO tea_class){
				 	Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					boolean flag = false;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Tea_ClassDao classMgrDao = (Tea_ClassDao)DaoFactory.getDao(conn,EnumType.TEA_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						flag = classMgrDao.deleteTeaClass(tea_class);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:删除教师班级时信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}
					return flag;
			 }
			 /**
			  * 模糊查询班级
			  */
			 public List<ClassVO> findClassByTeaIdAndCn(int user_id,String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					List<ClassVO> list = null;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						ClassDao classMgrDao = (ClassDao)DaoFactory.getDao(conn,EnumType.CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						list = classMgrDao.findClassByTeaIdAndCn(user_id, class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:模糊查询班级信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}		
					return list;
			 }
			 public int findSTNumberByCn(String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					int num = 0;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						Stu_ClassDao classMgrDao = (Stu_ClassDao)DaoFactory.getDao(conn,EnumType.STU_CLASS_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						num = classMgrDao.findSTNumberByCn(class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:统计班级人数时错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}		
					return num;
			 }
			 public List<ExaminationVO> findExamByUid(int user_id,String class_name){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					List<ExaminationVO> list = null;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						ExaminationDao examinationMgrDao = (ExaminationDao)DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						list = examinationMgrDao.findExamByUid(user_id,class_name);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:查找试卷时信息错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}		
					return list;
			 }
			 /**
			  * 查找学生完成情况
			  */
			 public List<StuFinishStatusVO> findStuStatus(int exam_id){
				 Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
					List<StuFinishStatusVO> list = null;
					try{
						//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
						conn = DBUtils.getConnection();
						//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
						ExaminationDao examinationMgrDao = (ExaminationDao)DaoFactory.getDao(conn,EnumType.EXAMUNATION_DAO);			
						//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
						list = examinationMgrDao.findStuStatus(exam_id);
					}catch(DaoException e){
						throw e;
					}catch(Exception e){
						throw new ServiceException("1Service:查找学生完成情况时错误：",e);
					}finally{
						DBUtils.closeConnection(conn);
					}		
					return list;
			 }
}

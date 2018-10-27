package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface Tea_ClassDao extends BaseDao {
	/**
	 * 黄润志2018.08.10
	 * @return 返回查找信息
	 */
	 public List<RankingVO> findStudentAnswerRank(int user_id);
	 /**
	  * 2018.08.12
	  * @param user_id 
	  * @return 返回班级信息
	  */
	 public List<ClassVO> findClassByTeaId(int user_id);
	 /**
	  * 查找班级是否存在
	  * @param class_name
	  * @return
	  */
	 public boolean findClassByClassName(String class_name);
	 /**
	  * 不存在则查找该老师还未添加的一个班级有哪些
	  * @param user_id
	  * @return
	  */
	 public List<ClassVO> findNotClassByTeaId(int user_id);
	 /**
	  * 该班级存在则查找该老师是否已经添加过该班级
	  * @param class_id
	  * @return
	  */
	 public boolean findClassByClassid(String class_name);
	 /**
	  * 查找该班级的编号
	  * @param class_name
	  * @return
	  */
	 public ClassVO findClassIdByClassname(String class_name);
	 /**
	  * 该班级存在并还未被该老师添加过则插入老师班级表
	  * @param tea_class
	  * @return
	  */
	 public  boolean insertClassByClassName(Tea_ClassVO tea_class);
	 /**
	  * 教师删除班级
	  * @param tea_class
	  * @return
	  */
	 public  boolean deleteTeaClass(ClassVO tea_class);
}

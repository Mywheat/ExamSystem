package com.lingnan.examsys.business.service;

import java.util.List;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;

public interface Tstudent_managementService {
	/**
	 * 黄润志2018.08.10
	 * @return 返回查找信息
	 */
	 public List<RankingVO> findStudentAnswerRank(int user_id);
	 /**
	  * 查看学生的答题记录
	  * @param user
	  * @return
	  */
	 public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user);
	 /**
	  * 查看该老师所教班级
	  * @param user_id
	  * @return
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
	  * 根据班级名查找班级id
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
	  * 删除教师班级
	  * @param tea_class
	  * @return
	  */
	 public  boolean deleteTeaClass(ClassVO tea_class);
	 /**
	  * 模糊查询班级
	  * @param user_id
	  * @param class_name
	  * @return
	  */
	 public List<ClassVO> findClassByTeaIdAndCn(int user_id,String class_name);
	/**
	 * 统计班级人数
	 * @param class_name
	 * @return
	 */
	 public int findSTNumberByCn(String class_name);
	 /**
	  * 查找试卷
	  * @param user_id
	  * @return
	  */
	 public List<ExaminationVO> findExamByUid(int user_id,String class_name);
	 /**
	  * 查找学生完成情况
	  * @param exam_id
	  * @return
	  */
	 public List<StuFinishStatusVO> findStuStatus(int exam_id);
}

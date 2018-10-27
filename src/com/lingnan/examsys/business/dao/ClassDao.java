package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface ClassDao extends BaseDao{
	/**
	 * 班级搜索搜索框
	 * 模糊查询
	 * @param user_id
	 * @param class_name
	 * @return
	 */
	 public List<ClassVO> findClassByTeaIdAndCn(int user_id,String class_name);
	 /**
	  * 
	  * @param class_name
	  * @return
	  */
	 public List<ClassVO> findClassID(String class_name);
}

package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface Stu_ClassDao extends BaseDao {
	/**
	 * 统计班级人数
	 * @param class_name
	 * @return
	 */
	public int findSTNumberByCn(String class_name);

	public List<Stu_ClassVO> findExam_Stu(int class_id);
}

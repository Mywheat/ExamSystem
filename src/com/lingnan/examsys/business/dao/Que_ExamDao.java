package com.lingnan.examsys.business.dao;

import com.lingnan.examsys.common.dao.BaseDao;

public interface Que_ExamDao extends BaseDao {

	/**
	 * 添加试卷的试题
	 * @param num 这张试卷一共要出几道试题
	 * @param Exam_id 这张试卷的Exam_id
	 * @param Que_id 选取题库中题目的Que_id
	 * @return
	 */
	public boolean addQue_Exam(int num,int Exam_id,int Que_id);
	
}

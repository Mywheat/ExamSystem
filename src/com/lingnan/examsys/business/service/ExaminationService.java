package com.lingnan.examsys.business.service;

import java.sql.Date;


public interface ExaminationService {

	/**
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间）
	 * 2.根据教师编号和试卷名从试卷表中（examination）找出试卷号（主键，自增）
	 */
	public boolean insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end);
	public int findExam_id(int user_id, String exam_name);
}

package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface ExaminationDao extends BaseDao {
	/**
	 *  查找该老师出的所有试卷
	 * @param user_id
	 * @param class_name
	 * @return
	 */

	public List<ExaminationVO> findExamByUid(int user_id,String class_name);
	/**
	 * 统计完成人数
	 * @param exam_id
	 * @return
	 */
	public int findFinishSt(int exam_id);
	/**
	 * 查看学生完成状态
	 * @param exam_id
	 * @return
	 */
	public List<StuFinishStatusVO> findStuStatus(int exam_id);
	/**
	 * 1.教师添加试卷，先完善试卷表（examination）中的信息（插入试卷名，考试开始时间和结束时间）
	 * 2.根据教师编号和试卷名从试卷表中（examination）找出试卷号（主键，自增）
	 */
	public boolean insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end);
	public int findExam_id(int user_id, String exam_name);

}

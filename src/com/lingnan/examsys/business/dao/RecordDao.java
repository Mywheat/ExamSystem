package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface RecordDao extends BaseDao {
	/**
	 * 黄润志2018.08.11
	 * 查看学生答题记录根据用户账号与用户名
	 * @param user  返回查找信息
	 * @return
	 */
	public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user);
}

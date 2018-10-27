package com.lingnan.examsys.business.dao;

import com.lingnan.examsys.common.dao.BaseDao;

public interface MissionDao extends BaseDao{
	public boolean insertMission(int exam_id, int user_id);
}

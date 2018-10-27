package com.lingnan.examsys.business.dao;

import java.util.List;

import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.dao.BaseDao;

public interface UserDao extends BaseDao {
	/**
	 * 黄润志2018.08.10
	 * 根据用户账号和密码查找用户
	 * @param user
	 * @return
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user);
	
}

package com.lingnan.examsys.business.service;

import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;

public interface UserService {
	/**
	 * 黄润志2018.08.10
	 * 根据用户账号和密码查找用户
	 * @param user
	 * @return
	 */
		public List<UserVO> findUserByIdAndPassword(UserVO user);
		

}

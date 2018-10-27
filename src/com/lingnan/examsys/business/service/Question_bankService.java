package com.lingnan.examsys.business.service;

import java.util.Vector;

import com.lingnan.examsys.business.domain.Question_bankVO;

public interface Question_bankService {

	//分页查看题库所有题目 2018/10/14 mai
	public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize);  
	//教师端添加试题 2018/10/24 mai
	public boolean insertQuestion(Question_bankVO qbVO);
}

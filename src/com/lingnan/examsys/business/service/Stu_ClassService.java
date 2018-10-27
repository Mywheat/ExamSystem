package com.lingnan.examsys.business.service;

import java.util.List;

import com.lingnan.examsys.business.domain.Stu_ClassVO;

public interface Stu_ClassService {

	public List<Stu_ClassVO> findExam_Stu(int class_id);
}

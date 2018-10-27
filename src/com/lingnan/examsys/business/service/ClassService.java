package com.lingnan.examsys.business.service;

import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;

public interface ClassService {

	public List<ClassVO> findClassID(String class_name);
}

package com.pythe.rest.service;

import java.util.List;

import com.pythe.pojo.TblSubject;



public interface SubjectService  {
	List<TblSubject> selectSubjectByPhase(Integer gradeId);
}

package com.pythe.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pythe.mapper.TblSubjectMapper;
import com.pythe.pojo.TblSubject;
import com.pythe.pojo.TblSubjectExample;
import com.pythe.rest.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private TblSubjectMapper subjectMapper;

	@Override
	public List<TblSubject> selectSubjectByPhase(Integer gradeId) {
		
		if (gradeId==-1) {
			TblSubjectExample example = new TblSubjectExample();
			return subjectMapper.selectByExample(example);
		}
		Integer phase = gradeId / 100;
		System.out.println(phase);
		TblSubjectExample example = new TblSubjectExample();
		if (1==phase) {
			List<Integer> list = new ArrayList<>();
		    list.add(1001);
		    list.add(1002);
		    list.add(1003);
		    list.add(1004);
		    list.add(1005);
		    list.add(1011);
		    list.add(1012);
			example.createCriteria().andSubjectidIn(list);
		}
		return subjectMapper.selectByExample(example);
	}

}

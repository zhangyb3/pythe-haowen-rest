package com.pythe.pojo;
import java.util.List;

public class Collection {
	private List<Long> questions;
	private List<Long> teacherIds;
	//为了能够让别人只能点击一次
	private List<Long> answers;


	public List<Long> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Long> answers) {
		this.answers = answers;
	}
	public List<Long> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Long> questions) {
		this.questions = questions;
	}
	public List<Long> getTeacherIds() {
		return teacherIds;
	}
	public void setTeacherIds(List<Long> teacherIds) {
		this.teacherIds = teacherIds;
	}

	
	
}

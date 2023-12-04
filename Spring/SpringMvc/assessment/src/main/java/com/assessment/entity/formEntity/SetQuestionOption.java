package com.assessment.entity.formEntity;

import java.util.List;

public class SetQuestionOption {
	private int classNo;
	private int testNo;

	private List<String> question;
	private List<String> option;

	private List<Integer> answer;

	@Override
	public String toString() {
		return "SetQuestionOption [question=" + question + ", option=" + option + " answer=" + answer + "]";
	}

	public List<String> getQuestion() {
		return question;
	}

	public void setQuestion(List<String> question) {
		this.question = question;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public List<Integer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Integer> answer) {
		this.answer = answer;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

}

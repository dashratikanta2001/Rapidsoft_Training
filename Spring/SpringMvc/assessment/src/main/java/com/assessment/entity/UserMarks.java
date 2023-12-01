package com.assessment.entity;

import java.util.List;

public class UserMarks {

	private String name;
	private String email;
	private int userClass;
	private List<TestDetails> testDetails;
	
	public static class TestDetails{
		private int testNo;
		private int totalMark;
		private int obtainedMark;
		private String grade;
		public TestDetails(int testNo, int totalMark, int obtainedMark, String grade) {
			super();
			this.testNo = testNo;
			this.totalMark = totalMark;
			this.obtainedMark = obtainedMark;
			this.grade = grade;
		}
		public int getTestNo() {
			return testNo;
		}
		public int getTotalMark() {
			return totalMark;
		}
		public int getObtainedMark() {
			return obtainedMark;
		}
		public String getGrade() {
			return grade;
		}
		
		
		
	}

	public UserMarks(String name, String email, int userClass, List<TestDetails> testDetails) {
		super();
		this.name = name;
		this.email = email;
		this.userClass = userClass;
		this.testDetails = testDetails;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getUserClass() {
		return userClass;
	}

	public List<TestDetails> getTestDetails() {
		return testDetails;
	}

	public UserMarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

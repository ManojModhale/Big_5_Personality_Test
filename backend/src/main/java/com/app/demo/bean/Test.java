package com.app.demo.bean;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Test")
public class Test 
{
	@Id
	@GeneratedValue
	private Long testId;
	private String username;
	private Date startExamDate;
	private int openness;
    private int conscientiousness;
    private int extraversion;
    private int agreeableness;
    private int neuroticism;
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(Long testId, String username, Date startExamDate, int openness, int conscientiousness, int extraversion,
			int agreeableness, int neuroticism) {
		super();
		this.testId = testId;
		this.username = username;
		this.startExamDate = startExamDate;
		this.openness = openness;
		this.conscientiousness = conscientiousness;
		this.extraversion = extraversion;
		this.agreeableness = agreeableness;
		this.neuroticism = neuroticism;
	}
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getStartExamDate() {
		return startExamDate;
	}
	public void setStartExamDate(Date startExamDate) {
		this.startExamDate = startExamDate;
	}
	public int getOpenness() {
		return openness;
	}
	public void setOpenness(int openness) {
		this.openness = openness;
	}
	public int getConscientiousness() {
		return conscientiousness;
	}
	public void setConscientiousness(int conscientiousness) {
		this.conscientiousness = conscientiousness;
	}
	public int getExtraversion() {
		return extraversion;
	}
	public void setExtraversion(int extraversion) {
		this.extraversion = extraversion;
	}
	public int getAgreeableness() {
		return agreeableness;
	}
	public void setAgreeableness(int agreeableness) {
		this.agreeableness = agreeableness;
	}
	public int getNeuroticism() {
		return neuroticism;
	}
	public void setNeuroticism(int neuroticism) {
		this.neuroticism = neuroticism;
	}
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", username=" + username + ", startExamDate=" + startExamDate + ", openness="
				+ openness + ", conscientiousness=" + conscientiousness + ", extraversion=" + extraversion
				+ ", agreeableness=" + agreeableness + ", neuroticism=" + neuroticism + "]";
	}

}

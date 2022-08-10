package com.example.demo.Model;


public class Mail1 {
	
	private String from;
	private String to;
	private String cc;
	
	private String subject;
	private String textbody;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTextbody() {
		return textbody;
	}
	public void setTextbody(String textbody) {
		this.textbody = textbody;
	}
	public Mail1(String from, String to, String cc, String subject, String textbody) {
		super();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.textbody = textbody;
	}
	public Mail1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mail1 [from=" + from + ", to=" + to + ", cc=" + cc + ", subject=" + subject + ", textbody=" + textbody
				+ "]";
	}
	
	

}

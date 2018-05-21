package exercise.bean;

import java.io.Serializable;

public class CandPBean implements Serializable{
	private String name;
	private String pass;
	private int code;

	public CandPBean(String name,String pass,int code) {
		this.name = name;
		this.pass = pass;
		this.code = code;
	}

	public CandPBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}

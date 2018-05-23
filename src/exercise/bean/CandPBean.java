package exercise.bean;

import java.io.Serializable;

public class CandPBean implements Serializable{
	private String name;
	private String pass;
	private int code;
	private String favomember;
	private String Birthday;

	public CandPBean(String name,String pass,int code,String favomember,String Birthday) {
		this.name = name;
		this.pass = pass;
		this.code = code;
		this.favomember = favomember;
		this.Birthday = Birthday;
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

	public String getFavomember() {
		return favomember;
	}

	public void setFavomember(String favomember) {
		this.favomember = favomember;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
}

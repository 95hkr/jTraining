package exercise.bean;

import java.io.Serializable;

public class MemberBean implements Serializable{
	private int memCode;
	private String memName;
	private int memHeight;
	private String memBirth;
	private String memBlood;

	public MemberBean(int memCode,String memName,int memHeight,String memBirth,String memBlood) {
		this.memCode = memCode;
		this.memName = memName;
		this.memHeight = memHeight;
		this.memBirth = memBirth;
		this.memBlood = memBlood;
	}

	public MemberBean() {

	}

	public int getMemCode() {
		return memCode;
	}

	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getMemHeight() {
		return memHeight;
	}

	public void setMemHeight(int memHeight) {
		this.memHeight = memHeight;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemBlood() {
		return memBlood;
	}

	public void setMemBlood(String memBlood) {
		this.memBlood = memBlood;
	}
}

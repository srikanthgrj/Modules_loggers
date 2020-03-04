package com.sri.mvc.DTO;

import org.apache.log4j.Logger;

import com.sri.mvc.DAO.SignupDAOImpl;

public class SignupDTO {
	private static  Logger logger = Logger.getLogger(SignupDAOImpl.class);
	private int id;
	private String username;
	private String email;
	private long mobnum;
	private String pwd;
	private String conpwd;

	public SignupDTO() {
		System.out.println("created  signup DTO");
		logger.info("created singnup DTO");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobnum() {
		return mobnum;
	}

	public void setMobnum(long mobnum) {
		this.mobnum = mobnum;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConpwd() {
		return conpwd;
	}

	public void setConpwd(String conpwd) {
		this.conpwd = conpwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SignupDTO(int id, String username, String email, long mobnum, String pwd, String conpwd) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobnum = mobnum;
		this.pwd = pwd;
		this.conpwd = conpwd;
	}

	@Override
	public String toString() {
		return "SignupDTO [id=" + id + ", username=" + username + ", email=" + email + ", mobnum=" + mobnum + ", pwd="
				+ pwd + ", conpwd=" + conpwd + "]";
	}

}

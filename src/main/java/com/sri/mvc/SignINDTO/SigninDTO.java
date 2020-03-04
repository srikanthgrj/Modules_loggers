package com.sri.mvc.SignINDTO;

public class SigninDTO {
	 private String signinemail;
	 private String singinpwd;
	 public SigninDTO() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
	public String getSigninemail() {
		return signinemail;
	}
	public void setSigninemail(String signinemail) {
		this.signinemail = signinemail;
	}
	public String getSinginpwd() {
		return singinpwd;
	}
	public void setSinginpwd(String singinpwd) {
		this.singinpwd = singinpwd;
	}
	public SigninDTO(String signinemail, String singinpwd) {
		this.signinemail = signinemail;
		this.singinpwd = singinpwd;
	}
	@Override
	public String toString() {
		return "SigninDTO [signinemail=" + signinemail + ", singinpwd=" + singinpwd + "]";
	}
	 
	 
}

package com.sri.mvc.DAO;

import com.sri.mvc.Entity.SignuEntity;

public interface SignupDAO {
	public void save(SignuEntity ent);
	public SignuEntity fetch(String email);
	public SignuEntity fetchbymailandpassword(String mail,String password);
	public String updatepassword(String mail,String password);
}

package com.sri.mvc.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.sri.mvc.DAO.SignupDAOImpl;
@Entity
@Table(name="letssignin")
@NamedQueries({
@NamedQuery(name = "fetchbyemail", query = "select  from SignuEntity  where email=:mail"),
@NamedQuery(name = "fetchbyemailandpassword", query = "select sign from SignuEntity sign where sign.email=:mail and sign.pwd=:pwd"),
@NamedQuery(name = "updatepasswordbyemail", query = "update SignuEntity  set pwd=:pwd where email =:mail")
})
public class SignuEntity implements Serializable {
	private static  Logger logger = Logger.getLogger(SignupDAOImpl.class);
	@Id
	@GenericGenerator (name="sri",strategy = "increment")
	@GeneratedValue(generator = "sri")
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="mobnum")
	private long mobnum;
	@Column(name="pwd")
	private String pwd;
	
	public SignuEntity() {
		System.out.println("created "+this.getClass().getSimpleName());
			logger.info("createdn"+this.getClass().getSimpleName());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "SignuEntity [id=" + id + ", username=" + username + ", email=" + email + ", mobnum=" + mobnum + ", pwd="
				+ pwd + ", conpwd=" + "]";
	}
	public SignuEntity(int id, String username, String email, long mobnum, String pwd, String conpwd) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobnum = mobnum;
		this.pwd = pwd;
		
		
		
	}
	
}

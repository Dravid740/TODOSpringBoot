package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



//@Component
//@Entity
@Entity
@Table(name = "User")
public class User {
//@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer uid;
	@Column
private String ufname;
	@Column
private String ulname;
	@Column
private int uage;
	@Column
private String uemail;
	@Column
private String upassword;
	@Column
private String uphoneNumber;
@OneToMany(mappedBy = "user")
@Column
private List<Post> post;
public User(String ufname, String ulname, int uage, String uemail, String upassword, String uphoneNumber) {
	super();
	this.ufname = ufname;
	this.ulname = ulname;
	this.uage = uage;
	this.uemail = uemail;
	this.upassword = upassword;
	this.uphoneNumber = uphoneNumber;
}
public User(int uid, String ufname, String ulname, int uage, String uemail, String upassword, String uphoneNumber) {
	super();
	this.uid = uid;
	this.ufname = ufname;
	this.ulname = ulname;
	this.uage = uage;
	this.uemail = uemail;
	this.upassword = upassword;
	this.uphoneNumber = uphoneNumber;
}

public User() {
	super();

}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getUfname() {
	return ufname;
}
public void setUfname(String ufname) {
	this.ufname = ufname;
}
public String getUlname() {
	return ulname;
}
public void setUlname(String ulname) {
	this.ulname = ulname;
}
public int getUage() {
	return uage;
}
public void setUage(int uage) {
	this.uage = uage;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}
public String getUphoneNumber() {
	return uphoneNumber;
}
public void setUphoneNumber(String uphoneNumber) {
	this.uphoneNumber = uphoneNumber;
}
public List<Post> getPost() {
	return post;
}


public void setPost(List<Post> post) {
	this.post = post;
}
}

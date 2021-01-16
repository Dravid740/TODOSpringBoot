package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String description;
	@Column
	private String targetDate;
	@Column
	private boolean isItDone;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isItDone() {
		return isItDone;
	}

	public void setItDone(boolean isItDone) {
		this.isItDone = isItDone;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", isItDone="
				+ isItDone + "]";
	}



}

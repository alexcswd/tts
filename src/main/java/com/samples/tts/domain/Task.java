package com.samples.tts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private int velocity;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private Status status = Status.Open;
	@OneToOne
	private User owner;
	@OneToOne
	private User reporter;
	@OneToMany(mappedBy = "task")
	@JsonBackReference
	private List<Comment> comments;
	
	public Task() { }
	
	public Task(String title, String description, User owner, User reporter) {
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.reporter = reporter;
		this.createdAt = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getReporter() {
		return reporter;
	}
	public void setReporter(User reporter) {
		this.reporter = reporter;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		if (comment != null) {
			if (comments == null) {
				comments = new ArrayList<>();
			}
			comment.setTask(this);
			comments.add(comment);
		}
	}

	enum Status {
		Open, InProcess, InDelivery, Finished;
	}
}

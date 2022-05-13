package com.ApiEnsolvers.app.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="note")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_note")
	private Long  idNote;
	
	@Column(name="title")
	private String title;
	
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="create_date")
	private Date createDate;
	
	@Lob
	@Column(name="note_text", columnDefinition = "blob")
	private String text;
	
	@Column(name="status_note")
	private boolean status;
	
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="update_date")
	private Date updateDate;
	
	public Note() {
		
	}
	
	public Note ( String title, String text, Date createDate, boolean status) {
		this.title=title;
		this.text=text;
		this.createDate=createDate;
		this.status=status;
		
	}

	public Long getIdNote() {
		return idNote;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
	

}

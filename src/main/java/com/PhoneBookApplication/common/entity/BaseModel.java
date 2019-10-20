package com.PhoneBookApplication.common.entity;

import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import lombok.Data;

import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel<U> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@CreatedBy
	protected String createdBy;

	@CreatedDate
	@Temporal(TIMESTAMP)
	protected Date createdDate;

	@LastModifiedBy
	protected String lastModifiedBy;

	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	 

}

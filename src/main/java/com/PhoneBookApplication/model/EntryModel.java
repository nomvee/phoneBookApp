package com.PhoneBookApplication.model;

import com.PhoneBookApplication.common.entity.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "PBA_ENTRY")
@EntityListeners(AuditingEntityListener.class)
public class EntryModel  extends BaseModel<String> {

	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Phone_Number", nullable = false)
	private String phoneNumber;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phoneBook_id")
	private PhoneBookModel phoneBook;

}

package com.PhoneBookApplication.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.PhoneBookApplication.common.entity.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "PBA_PHONE_BOOK")
@EntityListeners(AuditingEntityListener.class)
public class PhoneBookModel extends BaseModel<PhoneBookModel> {

	@Column(name = "Name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "phoneBook", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EntryModel> modelEntries;

	public void addEntry(EntryModel entry) {
		modelEntries.add(entry);
		entry.setPhoneBook(this);

	}

	public void removeComment(EntryModel entry) {
		modelEntries.remove(entry);
		entry.setPhoneBook(this);
	}
}

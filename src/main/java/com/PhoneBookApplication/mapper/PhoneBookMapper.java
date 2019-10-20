package com.PhoneBookApplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.model.PhoneBookModel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { EntryMapper.class }, componentModel = "spring")
public interface PhoneBookMapper extends EntityMapper<PhoneBook, PhoneBookModel> {

	@Mapping(source = "modelEntries", target = "dtoEntries")
	PhoneBook toDto(final PhoneBookModel phoneBookModel);

	PhoneBookModel toEntity(final PhoneBook phoneBook);

	default PhoneBookModel fromId(final Long id) {

		if (id == null) {
			return null;
		}

		final PhoneBookModel phoneModel = new PhoneBookModel();
		phoneModel.setId(id);
		return phoneModel;
	}

}

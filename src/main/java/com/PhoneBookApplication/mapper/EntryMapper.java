package com.PhoneBookApplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.model.EntryModel;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { PhoneBookMapper.class }, componentModel = "spring")
public interface EntryMapper extends EntityMapper<Entry, EntryModel> {

	

	@Mapping(source = "phoneBook.id", target = "phoneBookId")
	Entry toDto(final EntryModel entryModel);

	List<Entry> toDto(final List<EntryModel> entryModel);

	@Mapping(source = "phoneBookId", target = "phoneBook")
	EntryModel toEntity(final Entry entry);

	List<EntryModel> toEntity(final List<Entry> Entries);

	default EntryModel fromId(final Long id) {

		if (id == null) {
			return null;
		}

		final EntryModel model = new EntryModel();
		model.setId(id);

		return model;
	}

}

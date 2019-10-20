package com.PhoneBookApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PhoneBookApplication.dao.EntryRepository;
import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.mapper.EntryMapper;
import com.PhoneBookApplication.model.EntryModel;


@Service
@Transactional
@RequiredArgsConstructor
public class EntryService implements GenericService<Entry> {

	private final EntryRepository entryRepository;
	private final EntryMapper entryMapper;

	@Override
	public List<Entry> findAll() {

		final List<EntryModel> entryModels = entryRepository.findAll();
		List<Entry> entries = new ArrayList<>();

		entryModels.forEach(entryObject -> {

			final Entry entry = entryMapper.toDto(entryObject);

			entries.add(entry);

		});

		return entries;

	}

	@Override
	public Entry save(Entry entry) {
		EntryModel entryModel = entryRepository.save(entryMapper.toEntity(entry));
		return entryMapper.toDto(entryModel);
	}

	@Override
	public Entry findById(Long id) {
		Optional<EntryModel> entryModel = entryRepository.findById(id);

		return entryMapper.toDto(entryModel.get());

	}

	@Override
	public void deleteById(Long id) {
		entryRepository.deleteById(id);

	}

}

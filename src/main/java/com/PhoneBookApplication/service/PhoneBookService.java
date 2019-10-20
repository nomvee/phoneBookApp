package com.PhoneBookApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PhoneBookApplication.dao.EntryRepository;
import com.PhoneBookApplication.dao.PhoneBookRepository;
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.mapper.EntryMapper;
import com.PhoneBookApplication.mapper.PhoneBookMapper;
import com.PhoneBookApplication.model.EntryModel;
import com.PhoneBookApplication.model.PhoneBookModel;

@RequiredArgsConstructor
@Service
@Transactional
public class PhoneBookService implements GenericService<PhoneBook>{

	 
	private  final PhoneBookRepository phoneBookRepository;
	 
	private final EntryRepository entryRepository;
	 
	private final EntryMapper entryMapper;
	 
	private final PhoneBookMapper phoneBookMapper;

	@Override
	public List<PhoneBook> findAll() {

		final List<PhoneBookModel> phoneBookModels = phoneBookRepository.findAll();
		List<PhoneBook> phoneBooks = new ArrayList<>();

		phoneBookModels.forEach(phoneBook -> {

			final PhoneBook book = phoneBookMapper.toDto(phoneBook);

			phoneBooks.add(book);

		});

		return phoneBooks;
	}
	@Override
	public PhoneBook save(PhoneBook phoneBook) {

		final PhoneBookModel phoneBookModel = phoneBookMapper.toEntity(phoneBook);
		final PhoneBookModel createdphoneBookModel = phoneBookRepository.save(phoneBookModel);

		final List<EntryModel> entries = new ArrayList<>();

		phoneBook.getDtoEntries().forEach(entry -> {

			final EntryModel entryModel = entryMapper.toEntity(entry);
			entryModel.setPhoneBook(createdphoneBookModel);
			entries.add(entryModel);

		});
		createdphoneBookModel.setModelEntries(entries);
		entryRepository.saveAll(entries);

		return phoneBookMapper.toDto(createdphoneBookModel);
	}

	@Override
	public PhoneBook findById(Long id) {

		 Optional<PhoneBookModel> phoneBookModel = phoneBookRepository.findById(id);

		return phoneBookMapper.toDto(phoneBookModel.get());
	}
	@Override
	public void deleteById(Long id) {
		phoneBookRepository.deleteById(id);

	}

}

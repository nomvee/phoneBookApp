package com.PhoneBookApplication.mapper;

import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.model.PhoneBookModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class PhoneBookMapperImpl implements PhoneBookMapper {

    @Autowired
    private EntryMapper entryMapper;

    @Override
    public List<PhoneBook> toDto(List<PhoneBookModel> eList) {
        if ( eList == null ) {
            return null;
        }

        List<PhoneBook> list = new ArrayList<PhoneBook>( eList.size() );
        for ( PhoneBookModel phoneBookModel : eList ) {
            list.add( toDto( phoneBookModel ) );
        }

        return list;
    }

    @Override
    public List<PhoneBookModel> toEntity(List<PhoneBook> dList) {
        if ( dList == null ) {
            return null;
        }

        List<PhoneBookModel> list = new ArrayList<PhoneBookModel>( dList.size() );
        for ( PhoneBook phoneBook : dList ) {
            list.add( toEntity( phoneBook ) );
        }

        return list;
    }

    @Override
    public PhoneBook toDto(PhoneBookModel phoneBookModel) {
        if ( phoneBookModel == null ) {
            return null;
        }

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.setDtoEntries( entryMapper.toDto( phoneBookModel.getModelEntries() ) );
        phoneBook.setId( phoneBookModel.getId() );
        phoneBook.setName( phoneBookModel.getName() );

        return phoneBook;
    }

    @Override
    public PhoneBookModel toEntity(PhoneBook phoneBook) {
        if ( phoneBook == null ) {
            return null;
        }

        PhoneBookModel phoneBookModel = new PhoneBookModel();

        phoneBookModel.setId( phoneBook.getId() );
        phoneBookModel.setName( phoneBook.getName() );

        return phoneBookModel;
    }
}

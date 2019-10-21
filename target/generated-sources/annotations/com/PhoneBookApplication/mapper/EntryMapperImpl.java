package com.PhoneBookApplication.mapper;

import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.model.EntryModel;
import com.PhoneBookApplication.model.PhoneBookModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_222 (Oracle Corporation)"
)
@Component
public class EntryMapperImpl implements EntryMapper {

    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public Entry toDto(EntryModel entryModel) {
        if ( entryModel == null ) {
            return null;
        }

        Entry entry = new Entry();

        Long id = entryModelPhoneBookId( entryModel );
        if ( id != null ) {
            entry.setPhoneBookId( id );
        }
        entry.setId( entryModel.getId() );
        entry.setName( entryModel.getName() );
        entry.setPhoneNumber( entryModel.getPhoneNumber() );

        return entry;
    }

    @Override
    public List<Entry> toDto(List<EntryModel> entryModel) {
        if ( entryModel == null ) {
            return null;
        }

        List<Entry> list = new ArrayList<Entry>( entryModel.size() );
        for ( EntryModel entryModel1 : entryModel ) {
            list.add( toDto( entryModel1 ) );
        }

        return list;
    }

    @Override
    public EntryModel toEntity(Entry entry) {
        if ( entry == null ) {
            return null;
        }

        EntryModel entryModel = new EntryModel();

        entryModel.setPhoneBook( phoneBookMapper.fromId( entry.getPhoneBookId() ) );
        entryModel.setId( entry.getId() );
        entryModel.setName( entry.getName() );
        entryModel.setPhoneNumber( entry.getPhoneNumber() );

        return entryModel;
    }

    @Override
    public List<EntryModel> toEntity(List<Entry> Entries) {
        if ( Entries == null ) {
            return null;
        }

        List<EntryModel> list = new ArrayList<EntryModel>( Entries.size() );
        for ( Entry entry : Entries ) {
            list.add( toEntity( entry ) );
        }

        return list;
    }

    private Long entryModelPhoneBookId(EntryModel entryModel) {
        if ( entryModel == null ) {
            return null;
        }
        PhoneBookModel phoneBook = entryModel.getPhoneBook();
        if ( phoneBook == null ) {
            return null;
        }
        Long id = phoneBook.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

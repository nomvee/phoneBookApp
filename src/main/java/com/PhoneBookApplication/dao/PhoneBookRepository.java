package com.PhoneBookApplication.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhoneBookApplication.model.PhoneBookModel;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookModel, Long>{

}

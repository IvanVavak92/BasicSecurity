package com.ivan.basicsecurityproject.repositories;

import com.ivan.basicsecurityproject.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {

}

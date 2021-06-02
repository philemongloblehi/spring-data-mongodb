package com.mongodb.springdata.repository;

import com.mongodb.springdata.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Philémon Globléhi <philemon.globlehi
 */
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
}

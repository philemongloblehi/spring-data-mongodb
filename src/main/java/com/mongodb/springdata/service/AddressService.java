package com.mongodb.springdata.service;

import com.mongodb.springdata.repository.AddressRepository;
import lombok.AllArgsConstructor;

/**
 * @author Philémon Globléhi <philemon.globlehi@gmail.com>
 */
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
}

package com.mongodb.springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Philémon Globléhi <philemon.globlehi@gmail.com>
 */
@Data
@Document
public class Address {
    @Id
    private String id;
    private String country;
    private String city;
    private String postCode;

    public Address(String country, String city, String postCode) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
    }
}

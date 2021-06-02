package com.mongodb.springdata.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Philémon Globléhi <philemon.globlehi@gmail.com>
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/address", name = "app_address_")
public class AddressController {
}

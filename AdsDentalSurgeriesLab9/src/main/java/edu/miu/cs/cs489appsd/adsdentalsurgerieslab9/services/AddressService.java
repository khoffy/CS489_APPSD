package edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab9.entities.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    List<AddressDto> getAllAddresses();
    Address updateAddress(Address address);
    void deleteAddress(Address address);
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    List<Address> getAllAddresses();
    Address updateAddress(Address address);
    void deleteAddress(Address address);
}

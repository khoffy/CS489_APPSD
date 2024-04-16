package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.Address;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.repositories.AddressRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepo;

    public AddressServiceImpl(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address createAddress(Address address) {
        return null;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        return addressRepo.findAll().stream().map(addr -> {
            return new AddressDto(addr.getId(), addr.getStreet(), addr.getCity(), addr.getState(),
                    addr.getZip());
        }).toList();
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public void deleteAddress(Address address) {

    }

    @Autowired
    public void setAddressRepo(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }
}

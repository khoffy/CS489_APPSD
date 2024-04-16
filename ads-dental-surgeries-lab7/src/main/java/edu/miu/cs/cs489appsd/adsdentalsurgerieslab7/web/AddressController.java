package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.web;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.dtos.AddressDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/address")
public class AddressController {

    private AddressService addressService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return new ResponseEntity<>(addressService.getAllAddresses(), HttpStatus.OK);
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}

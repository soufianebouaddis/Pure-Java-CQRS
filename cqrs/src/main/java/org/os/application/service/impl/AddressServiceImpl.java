package org.os.application.service.impl;

import org.os.application.dto.AddressDto;
import org.os.application.service.AddressService;
import org.os.domain.entity.Address;
import org.os.domain.repository.AddressRepository;

import java.util.Optional;
import java.util.UUID;

public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Address> getAddress(UUID id) {
        return addressRepository.getAddress(id);
    }

    @Override
    public Optional<Address> updateAddress(UUID id, AddressDto addressDto) {
        return addressRepository.updateAddress(id,addressDto);
    }

    @Override
    public Optional<Address> deleteAddress(UUID id) {
        return addressRepository.deleteAddress(id);
    }

    @Override
    public Optional<Address> createAddress(AddressDto addressDto) {
        return addressRepository.createAddress(addressDto);
    }
}

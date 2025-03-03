package org.os.application.service;

import org.os.application.dto.AddressDto;
import org.os.domain.entity.Address;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {
    Optional<Address> getAddress(UUID id);
    Optional<Address> updateAddress(UUID id, AddressDto addressDto);
    Optional<Address> deleteAddress(UUID id);
    Optional<Address> createAddress(AddressDto addressDto);
}

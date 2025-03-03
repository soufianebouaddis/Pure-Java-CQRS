package org.os.infrastructure.persistance;

import org.os.application.dto.AddressDto;
import org.os.domain.entity.Address;
import org.os.domain.repository.AddressRepository;
import org.os.infrastructure.exception.AddressNotFound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class AddressRepositoryImpl implements AddressRepository {
    private Map<String,Address> store = new HashMap<>();
    @Override
    public Optional<Address> getAddress(UUID id) {
        Optional<Address> add = Optional.ofNullable(store.get(id.toString()));
        if(add.isPresent()) return add;
        else throw new AddressNotFound("Address not found with id => "+id.toString());
    }

    @Override
    public Optional<Address> updateAddress(UUID id, AddressDto addressDto) {
        Optional<Address> address = Optional.ofNullable(store.get(id.toString()));
        if(address.isPresent()){
            address.get()
                    .setAddressName(addressDto.addressName());
            store.put(id.toString(),address.get());
            return address;
        }
        else throw new AddressNotFound("Address not found with id => "+id.toString());
    }

    @Override
    public Optional<Address> deleteAddress(UUID id) {
        Optional<Address> add = Optional.ofNullable(store.get(id.toString()));
        if(add.isPresent()){
            var temp = add;
            store.remove(id.toString(),add);
            return temp;
        }
        else throw new AddressNotFound("Address not found with id => "+id.toString());
    }

    @Override
    public Optional<Address> createAddress(AddressDto addressDto) {
        Address address = new Address(UUID.randomUUID(), addressDto.addressName());
        store.put(address.getId().toString(),address);
        return Optional.of(address);
    }
}

package org.os.domain.entity;

import java.util.UUID;

public class Address{
    private UUID id;
    private String addressName;
    public Address(){}
    public Address(UUID id, String addressName) {
        this.id = id;
        this.addressName = addressName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}

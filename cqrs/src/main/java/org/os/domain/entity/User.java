package org.os.domain.entity;

import java.util.Set;
import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;
    private Set<Address> addresses;
    public User(){}

    public User(UUID id, String fullName, Set<Address> addresses) {
        this.id = id;
        this.fullName = fullName;
        this.addresses = addresses;
    }

    public User(UUID id,String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}

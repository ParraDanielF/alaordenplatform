package com.co.alaorden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Address", schema = "alaorden_dev", catalog = "")
public class AddressEntity {
    private int id;
    private String userId;
    private String name;
    private String address;
    private Byte isTheMainAddress;
    private Double longitude;
    private Double latitude;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = false, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 70)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "isTheMainAddress", nullable = true)
    public Byte getIsTheMainAddress() {
        return isTheMainAddress;
    }

    public void setIsTheMainAddress(Byte isTheMainAddress) {
        this.isTheMainAddress = isTheMainAddress;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(isTheMainAddress, that.isTheMainAddress) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, address, isTheMainAddress, longitude, latitude);
    }
}

package com.co.alaorden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Company", schema = "alaorden_dev", catalog = "")
public class CompanyEntity {
    private int id;
    private String name;
    private String address;
    private Byte isActive;
    private String owner;
    private String segmentCode;
    private Double longitude;
    private Double latitude;
    private Integer country;
    private Integer city;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "isActive", nullable = true)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "owner", nullable = false, length = 50)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "segmentCode", nullable = false, length = 10)
    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
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

    @Basic
    @Column(name = "country", nullable = true)
    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = true)
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(segmentCode, that.segmentCode) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, isActive, owner, segmentCode, longitude, latitude, country, city);
    }
}

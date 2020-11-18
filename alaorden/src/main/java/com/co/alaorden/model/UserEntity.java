package com.co.alaorden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "alaorden_dev")
public class UserEntity {
    private String id;
    private String name;
    private String document;
    private int documentType;
    private String lastName;
    private Integer country;
    private Integer city;
    private String phone;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "document", nullable = false, length = 30)
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Basic
    @Column(name = "documentType", nullable = false)
    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 60)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return documentType == that.documentType &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(document, that.document) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, document, documentType, lastName, country, city, phone);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", documentType=" + documentType +
                ", lastName='" + lastName + '\'' +
                ", country=" + country +
                ", city=" + city +
                ", phone='" + phone + '\'' +
                '}';
    }
}

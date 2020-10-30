package com.co.alaorden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Service", schema = "alaorden_dev", catalog = "")
public class ServiceEntity {
    private int id;
    private int companyId;
    private int serviceType;
    private String name;
    private String description;
    private double price;
    private Byte isNegotiable;
    private Double score;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "companyId", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "serviceType", nullable = false)
    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 80)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "isNegotiable", nullable = true)
    public Byte getIsNegotiable() {
        return isNegotiable;
    }

    public void setIsNegotiable(Byte isNegotiable) {
        this.isNegotiable = isNegotiable;
    }

    @Basic
    @Column(name = "score", nullable = true, precision = 0)
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return id == that.id &&
                companyId == that.companyId &&
                serviceType == that.serviceType &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(isNegotiable, that.isNegotiable) &&
                Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, serviceType, name, description, price, isNegotiable, score);
    }
}

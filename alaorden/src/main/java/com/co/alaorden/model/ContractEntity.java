package com.co.alaorden.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Contract", schema = "alaorden_dev")
public class ContractEntity {
    private int id;
    private int companyId;
    private String userId;
    private int paymentTypeId;
    private Date contractDate;

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
    @Column(name = "userId", nullable = false, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "paymentTypeId", nullable = false)
    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Basic
    @Column(name = "contractDate", nullable = true)
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractEntity that = (ContractEntity) o;
        return id == that.id &&
                companyId == that.companyId &&
                paymentTypeId == that.paymentTypeId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(contractDate, that.contractDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, userId, paymentTypeId, contractDate);
    }
}

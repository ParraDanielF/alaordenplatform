package com.co.alaorden.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Contract_Services", schema = "alaorden_dev")
public class ContractServicesEntity {
    private int id;
    private int contractId;
    private int serviceId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contractId", nullable = false)
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "serviceId", nullable = false)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractServicesEntity that = (ContractServicesEntity) o;
        return id == that.id &&
                contractId == that.contractId &&
                serviceId == that.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contractId, serviceId);
    }
}

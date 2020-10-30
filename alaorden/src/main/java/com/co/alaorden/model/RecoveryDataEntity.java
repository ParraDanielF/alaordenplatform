package com.co.alaorden.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RecoveryData", schema = "alaorden_dev", catalog = "")
public class RecoveryDataEntity {
    private int id;
    private int accountId;
    private String recoveryToken;
    private Timestamp expiredAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "accountId", nullable = false)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "recoveryToken", nullable = false, length = 100)
    public String getRecoveryToken() {
        return recoveryToken;
    }

    public void setRecoveryToken(String recoveryToken) {
        this.recoveryToken = recoveryToken;
    }

    @Basic
    @Column(name = "expiredAt", nullable = true)
    public Timestamp getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Timestamp expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecoveryDataEntity that = (RecoveryDataEntity) o;
        return id == that.id &&
                accountId == that.accountId &&
                Objects.equals(recoveryToken, that.recoveryToken) &&
                Objects.equals(expiredAt, that.expiredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, recoveryToken, expiredAt);
    }
}

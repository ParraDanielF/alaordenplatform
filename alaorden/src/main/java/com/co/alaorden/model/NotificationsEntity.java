package com.co.alaorden.model;

import javax.persistence.*;

@Entity
@Table(name = "Notifications", schema = "alaorden_dev", catalog = "")
public class NotificationsEntity {
    private int id;
    private String notificationMessage;
    private byte readStatus;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "notificationMessage", nullable = false, length = -1)
    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    @Basic
    @Column(name = "readStatus", nullable = false)
    public byte getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(byte readStatus) {
        this.readStatus = readStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationsEntity that = (NotificationsEntity) o;

        if (id != that.id) return false;
        if (readStatus != that.readStatus) return false;
        if (notificationMessage != null ? !notificationMessage.equals(that.notificationMessage) : that.notificationMessage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (notificationMessage != null ? notificationMessage.hashCode() : 0);
        result = 31 * result + (int) readStatus;
        return result;
    }
}

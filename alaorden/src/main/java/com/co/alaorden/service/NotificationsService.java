package com.co.alaorden.service;

import com.co.alaorden.model.DocumentTypeEntity;
import com.co.alaorden.model.NotificationsEntity;
import com.co.alaorden.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationsService {
    @Autowired
    NotificationsRepository notificationsRepository;

    public NotificationsEntity create (NotificationsEntity notification){
        return notificationsRepository.save(notification);
    }

    public NotificationsEntity read (Integer id){
        return notificationsRepository.findById(id).get();
    }

    public NotificationsEntity update (NotificationsEntity notification , Integer id){
        NotificationsEntity tmpNotification = notificationsRepository.findById(id).get();
        tmpNotification.setNotificationMessage(notification.getNotificationMessage());
        tmpNotification.setReadStatus(notification.getReadStatus());
        return notificationsRepository.save(tmpNotification);
    }

    public String delete (Integer id){
        notificationsRepository.deleteById(id);
        return notificationsRepository.findById(id).get() == null ?
                "Eliminada la notificacion "+ id.toString() :
                "No se elimina la notificacion " + id.toString() ;
    }
}

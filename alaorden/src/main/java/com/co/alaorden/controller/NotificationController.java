package com.co.alaorden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.alaorden.model.NotificationsEntity;
import com.co.alaorden.service.NotificationsService;

@RestController()
@RequestMapping(value="/notifications")
public class NotificationController {
	
	@Autowired
	NotificationsService notificationsService;
	
    @RequestMapping (value = "/{notificationId}/state/{state}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarEstadoDeLaNotificacion(@RequestParam() int notificationId, @RequestParam() int state){
        try {
        	
        	NotificationsEntity notification = new NotificationsEntity();
        	notification.setReadStatus((byte) state);
        	NotificationsEntity updatedNotification = notificationsService.update(notification, notificationId);
            
            if (updatedNotification != null)
                return new ResponseEntity<>("Notificación actualizada correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.BAD_REQUEST);
        }
    }
}

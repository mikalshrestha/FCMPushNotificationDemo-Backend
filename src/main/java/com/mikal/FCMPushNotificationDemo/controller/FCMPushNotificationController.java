package com.mikal.FCMPushNotificationDemo.controller;

import com.mikal.FCMPushNotificationDemo.model.PushNotificationRequest;
import com.mikal.FCMPushNotificationDemo.model.PushNotificationResponse;
import com.mikal.FCMPushNotificationDemo.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class FCMPushNotificationController {

    private NotificationService notificationService;

    public FCMPushNotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send/notification")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        notificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}

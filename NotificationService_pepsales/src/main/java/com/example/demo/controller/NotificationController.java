package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Notification;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public ResponseEntity<String> sendNotification(@RequestBody Notification notification) {
        notificationService.queueNotification(notification);
        return ResponseEntity.ok("Notification queued successfully!");
    }
	
	@GetMapping("/users/{id}")
	public List<Notification> getUserNotifications(@PathVariable("id") String userId) {
        return notificationService.getNotificationsForUser(userId);
    } 
}

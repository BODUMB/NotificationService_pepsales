package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Notification;
import com.example.demo.queue.NotificationQueueProcessor;
import com.example.demo.repository.NotificationRepository;

@Service
public class NotificationService {
	 @Autowired
	    private NotificationQueueProcessor processor;

	    @Autowired
	    private NotificationRepository repository;

	    public void queueNotification(Notification notification) {
	        processor.addToQueue(notification);
	    }

	    public List<Notification> getNotificationsForUser(String userId) {
	        return repository.findByUserId(userId);
	    }
}

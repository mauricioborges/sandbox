package com.services;

public class NotificationService {

    private final String notificationPrefix;

    public NotificationService(String notificationPrefix) {
        this.notificationPrefix = notificationPrefix;
    }

    public void send() {

    }

    @Override
    public String toString() {
        return "NotificationService{" +
                "notificationPrefix='" + notificationPrefix + '\'' +
                '}';
    }
}

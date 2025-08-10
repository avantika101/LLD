package caseStudies.carRental.services;

import caseStudies.carRental.enums.NotificationType;
import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.NotificationStrategy.EmailNotificationStrategy;
import caseStudies.carRental.model.NotificationStrategy.NotificationStrategy;
import caseStudies.carRental.model.NotificationStrategy.SMSNotificationStrategy;
import caseStudies.carRental.model.User;

import java.util.List;

public class NotificationService {
    private NotificationStrategy notificationStrategy;

    NotificationService(){
        this.notificationStrategy = new SMSNotificationStrategy(); // default
    }

    public void setDefaultNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public NotificationStrategy getDefaultNotificationStrategy() {
        return notificationStrategy;
    }

    private NotificationStrategy getNotificationStrategy(String type){
        return switch(type.toLowerCase()){
            case "email" -> new EmailNotificationStrategy();
            default -> new SMSNotificationStrategy();
        };
    }

    public void notify(Bookings booking, User user, NotificationType notificationType){
        System.out.println("notification type:"+notificationType.name());
        if(user.getPrefNotifications().isEmpty()){
            notificationStrategy.sendNotification(booking);
        }else{
            for(String noti : user.getPrefNotifications()){
                NotificationStrategy strategy = getNotificationStrategy(noti);
                strategy.sendNotification(booking);
            }
        }
    }
}

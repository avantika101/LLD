package caseStudies.carRental.model;

import caseStudies.carRental.enums.ProfileStatus;
import caseStudies.carRental.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private final UserType userType;
    private ProfileStatus profileStatus;
    private List<String> prefNotifications;

    public User(int id, UserType type){
        this.userId = id;
        this.userType = type;
        this.profileStatus = ProfileStatus.ACTIVE;
        this.prefNotifications = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setProfileActive(){
        this.profileStatus = ProfileStatus.ACTIVE;
    }

    public void setProfileInactive(){
        this.profileStatus = ProfileStatus.INACTIVE;
    }

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }

    public List<String> getPrefNotifications() {
        return prefNotifications;
    }

    public void addPrefNotifications(String prefNotification) {
        prefNotifications.add(prefNotification);
    }

    public void removePrefNotifications(String prefNotification){
        prefNotifications.remove(prefNotification);
    }
}

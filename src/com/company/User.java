package com.company;

public class User {

    private static User  user_instance = null;

    private String userMail;
    private String userPassword;
    private String userDevideID;

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDevideID() {
        return userDevideID;
    }

    public void setUserDevideID(String userDevideID) {
        this.userDevideID = userDevideID;
    }

    public void ResetUserData()
    {
        userMail = null;
        userPassword = null;
        userDevideID = null;
    }

    private User(String userMail,String userPassword,String devideID)
    {
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userDevideID = devideID;

    }

    public static User getInstance(String userMail,String userPassword ,String deviceID)
    {
        if (user_instance == null)
            user_instance = new User(userMail,userPassword,deviceID);

        return user_instance;
    }

}

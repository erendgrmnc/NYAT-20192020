package com.company;

import java.sql.*;

public class DatabaseOperator {

    int tempNumber = 1;

    private Connection connect()
    {
        Connection  conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Nyat","postgres","Eren1552963");
            if (conn != null)
            {
                System.out.println("Veritabanına bağlandı !");
            }
            else
            {
                System.out.println("Veritabanına bağlanamadı !");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return conn;
    }

    public User UserAuthentication(String username,String password)
    {
        String kullaniciadi = username;
        String sifre = password;
        User user = null;
        String command = "SELECT * FROM \"User\" WHERE \"Mail\"=" + "'" + username.toString() + "'" + " AND  \"Password\" = "+ "'" +password.toString()+"'";
        Connection conn = this.connect();
        try
        {

            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(command);

            conn.close();

            String _username = null;
            String _password = null;
            String _deviceID = null;

            if (rs != null) {


                while (rs.next()) {
                    _username = rs.getString("Mail");
                    _password = rs.getString("Password");
                    _deviceID = rs.getString("DeviceID");
                }

                user =  User.getInstance(_username, _password,_deviceID);
                rs.close();
                stmnt.close();
            }










        }

        catch (Exception e)
        {
            e.printStackTrace();

        }

        return user;


    }

    public void TemperatureRegistration(Handler hndlr)
    {


        String command = "INSERT INTO \"TemperatureSensor\" (\"DeviceID\",\"Temperature\",\"TemperatureNumber\") VALUES  ('" + hndlr.user.getUserDevideID() + "' , '" + hndlr.tmpSens.GetCurrentTemp() + "' , '" + tempNumber + "')" ;

        Connection conn = this.connect();

        try
        {
            Statement stmnt = conn.createStatement();
            stmnt.executeUpdate(command);

            conn.close();


            stmnt.close();

        }

        catch (Exception e)
        {
         e.printStackTrace();
        }
        tempNumber++;


    }
}

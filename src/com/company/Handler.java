package com.company;

import sun.security.jca.GetInstance;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Handler
{

    private static Handler handler_instance;

    Scanner scn = new Scanner(System.in);
    User user;
    DatabaseOperator dbOperator = new DatabaseOperator();

    DeviceInterface deviceInterface;

    TemperatureSensor tmpSens;

    boolean isDeviceOn;


    private Handler(DeviceInterface deviceInterface,TemperatureSensor tmpSens)
    {

        this.deviceInterface = deviceInterface;
        this.tmpSens = tmpSens;

    }


    public void DeviceScreen() {


        int selection = 0;



        System.out.println("*******SOĞUTUCU********");
        System.out.println("1-)Cihazı çalıştır. ");
        System.out.println("2-)Cihazı kapat. ");

        selection = Integer.parseInt(scn.nextLine());

        if (selection == 1) {
            LogInScreen();


            if (isDeviceOn) {
                System.out.println("Cihaz Açık. ");

                MainScreen();
            } else {
                System.out.println("Cihaz Kapalı. ");
            }


        }
    }




    void MainScreen()
    {



        int menuSelection = 0;
        boolean isAdded = false;

        while (menuSelection != 2)
        {
            System.out.println("******ANA EKRAN******");
            System.out.println("1-)Oda Sıcaklığını göster");
            System.out.println("2-)Cihazı Kapat Ve Ana Menuye Dön");

            menuSelection = Integer.parseInt(scn.nextLine());

            switch (menuSelection)
            {
                default:
                    System.out.println("Geçersiz Tercih Yaptınız !");

                case 1:
                {


                    tmpSens.NotifyDevices();
                    dbOperator.TemperatureRegistration(handler_instance);

                    break;

                }

                case 2:
                {
                    System.out.println("Cihaz Kapalı. ");
                    isDeviceOn = false;
                    user.ResetUserData();
                    DeviceScreen();
                    break;
                }
            }

        }
    }

    public void LogInScreen()
    {

        String username = null;
        String password = null;


        System.out.println("Kullanıcı Adını Giriniz : ");
        username = scn.nextLine();
        System.out.println("Şifre Giriniz : ");
        password = scn.nextLine();




        user = dbOperator.UserAuthentication(username,password);

        if (user.getUserMail() == null)
        {
            System.out.println("Kullanıcı Bulunamadı !");
            isDeviceOn = false;

        }

        else
        {
            System.out.println("Hoşgeldiniz " + user.getUserMail());
            isDeviceOn = true;
        }

    }


    public static Handler GetInstance(DeviceInterface deviceInterface,TemperatureSensor tmpSens)
    {
        if (handler_instance == null)
            handler_instance = new Handler(deviceInterface,tmpSens);
        return handler_instance;
    }
}

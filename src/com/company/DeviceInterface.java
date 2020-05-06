package com.company;

import java.util.Scanner;

public class DeviceInterface
{

    private TemperatureSensor tempSens;

    boolean isDeviceOn;
    Scanner scn = new Scanner(System.in);
    DatabaseOperator dbOperator = new DatabaseOperator();
    TemperatureSensor tmpSens = TemperatureSensor.getInstance();


    Handler handler = Handler.GetInstance(deviceInterface_instance,tmpSens);



    User user = null;





    private static DeviceInterface deviceInterface_instance = null;



    public void RunDevice()
    {
        handler.DeviceScreen();
    }


    private DeviceInterface( )
    {



    }

    public void AddDevice()
    {
        tmpSens.AddDevice(deviceInterface_instance);
    }

    public static DeviceInterface getInstance()
    {
        if(deviceInterface_instance == null)
        {
            deviceInterface_instance = new DeviceInterface();


        }
            return deviceInterface_instance;


    }

    public void UpdateTemperature()
    {


        tempSens = TemperatureSensor.getInstance();


        String a = tempSens.GetTemperature();

        System.out.println("Sıcaklık : " + a );

    }




}

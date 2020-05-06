package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TemperatureSensor
{
    Random rand = new Random();
    String currentTemp = null;


    private List<DeviceInterface> devices = new ArrayList<DeviceInterface>();

    private static TemperatureSensor temperatureSensor_instance;


    private TemperatureSensor()
    {




    }

    public static TemperatureSensor getInstance()
    {
        if (temperatureSensor_instance == null)
        {
            temperatureSensor_instance = new TemperatureSensor();
        }

        return temperatureSensor_instance;
    }


    public String GetTemperature()
    {
        String returnValue;

        int temp = GetRandomTemp();

        returnValue = Integer.toString(temp) + "°C";

        currentTemp = returnValue;
        return returnValue;

    }

    public int GetRandomTemp()
    {
        int temp;

        temp = rand.nextInt((40 - 18) + 1) + 18;



        return temp;
    }

    public String GetCurrentTemp()
    {
        return currentTemp;
    }

    public void AddDevice(DeviceInterface di)
    {
        devices.add(di);
    }

    public void NotifyDevices()
    {

        for (DeviceInterface d : devices)
        {

            {
                d.UpdateTemperature();
            }

        }
    }



}

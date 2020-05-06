package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


      DeviceInterface deviceInterface = DeviceInterface.getInstance();
      deviceInterface.AddDevice();



      deviceInterface.RunDevice();





    }
}

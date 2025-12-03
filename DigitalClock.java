/*
* NAME: Michael Slaughter 
    * DATE: 10/21/2025 
    * VERSION: v1 
    * SOURCES USED: https://classroom.google.com/c/NzgwMzc2ODU2ODkw/m/ODE2MjA4NTQ5OTk5/details, https://www.w3schools.com/java/default.asp , https://www.w3schools.com/java/java_date.asp, https://www.codecademy.com/enrolled/courses/learn-java
    * COMMENTS: 
    * 
    * Psuedocode:
    * 1. Get 5 different times from different time zones (Eastern, Central, Mountain and Pacific Time)
    * 2. Ask the user which time zone they want to select 
    * 3. The Time will print of the time zone they selected
    * 4. They can change the time zone they want to display if they want
    * 
    * 
*/


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class DigitalClock {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in); //input scanner
        ZoneId sydney = ZoneId.of("Australia/Sydney"); //zone ids for the locations
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZoneId paris = ZoneId.of("Europe/Paris");
        ZoneId newYork = ZoneId.of( "America/New_York" );
        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZonedDateTime dateTimeSDY = ZonedDateTime.now(sydney); //gets the date and time now of the locations
        ZonedDateTime dateTimeTYO = ZonedDateTime.now(tokyo);
        ZonedDateTime dateTimePAR = ZonedDateTime.now(paris);
        ZonedDateTime dateTimeNY = ZonedDateTime.now(newYork);
        ZonedDateTime dateTimeLA = ZonedDateTime.now(losAngeles);
        DateTimeFormatter formatter24hr = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"); //24 hour format
        DateTimeFormatter formatter12hr = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mma"); //12 hour format
        String ftSDY = dateTimeSDY.format(formatter12hr); //puts the dates and times in a 12 hour format 
        String ftTYO = dateTimeTYO.format(formatter12hr); 
        String ftPAR = dateTimePAR.format(formatter12hr);
        String ftNY = dateTimeNY.format(formatter12hr);
        String ftLA = dateTimeLA.format(formatter12hr);
        System.out.println("1. Sydney, Australia: " + ftSDY); //prints the times and dates
        System.out.println("2. Tokyo, Asia: " + ftTYO);
        System.out.println("3. Paris, France: " + ftPAR);
        System.out.println("4. New York, USA: " + ftNY);
        System.out.println("5. Los Angeles, USA: " + ftLA);
        System.out.println("Which time zone would you like to display?"); 
        String choice = sc.nextLine();
        if (choice.equals("1")){
            Runnable printTimeTaskOne = () -> {
                // LocalTime currentTime = LocalTime.now();
                ZonedDateTime currentTime = ZonedDateTime.now(sydney);
                System.out.println("Current time: " + currentTime.format(formatter12hr));
            };
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(printTimeTaskOne, 0, 10, TimeUnit.SECONDS);
        } else if (choice.equals("2")){
            Runnable printTimeTaskOne = () -> {
                // LocalTime currentTime = LocalTime.now();
                ZonedDateTime currentTime = ZonedDateTime.now(tokyo);
                System.out.println("Current time: " + currentTime.format(formatter12hr));
            };
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(printTimeTaskOne, 0, 10, TimeUnit.SECONDS);
        } else if (choice.equals("3")){
            Runnable printTimeTaskOne = () -> {
                // LocalTime currentTime = LocalTime.now();
                ZonedDateTime currentTime = ZonedDateTime.now(paris);
                System.out.println("Current time: " + currentTime.format(formatter12hr));
            };
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(printTimeTaskOne, 0, 10, TimeUnit.SECONDS);
        } else if (choice.equals("4")){
            Runnable printTimeTaskOne = () -> {
                // LocalTime currentTime = LocalTime.now();
                ZonedDateTime currentTime = ZonedDateTime.now(newYork);
                System.out.println("Current time: " + currentTime.format(formatter12hr));
            };
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(printTimeTaskOne, 0, 10, TimeUnit.SECONDS);
        } else if (choice.equals("5")){
            Runnable printTimeTaskOne = () -> {
                // LocalTime currentTime = LocalTime.now();
                ZonedDateTime currentTime = ZonedDateTime.now(losAngeles);
                System.out.println("Current time: " + currentTime.format(formatter12hr));
            };
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(printTimeTaskOne, 0, 10, TimeUnit.SECONDS);
        }
    }
}
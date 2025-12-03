/*
* NAME: Michael Slaughter 
    * DATE: 12/7/2025 
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

public class DigitalClock { //digital clock class
    public static void main(String[] args) throws InterruptedException { //main
        Scanner sc = new Scanner(System.in); // input scanner
        ZoneId sydney = ZoneId.of("Australia/Sydney"); // zone id for Sydney, Austrailia
        ZoneId tokyo = ZoneId.of("Asia/Tokyo"); // zone id Asia, Tokyo
        ZoneId paris = ZoneId.of("Europe/Paris"); // zone id Paris, France
        ZoneId newYork = ZoneId.of("America/New_York"); // zone id New York, USA
        ZoneId losAngeles = ZoneId.of("America/Los_Angeles"); // zone id Los Angeles, USA
        DateTimeFormatter formatter12hr = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mma"); //12 hour time format (mma includes AM and PM)
        DateTimeFormatter formatter24hr = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mma"); //24 hour time format (mma includes AM and PM)
        boolean running = true; //boolean for whether the clock is running or not
        while (running) { //while loop with the boolean running
            System.out.println("\nSelect a time format: 12hr/24hr"); //asks the user to select a format
            String format = sc.nextLine(); //format nextLine
            if (format.equals("12") || format.equals("1") || format.equals("12hr")  || format.equals("12 hr")){ //if the choice is 12 for 12 hr or 1 for 1st Option
                ZonedDateTime dateTimeSDY = ZonedDateTime.now(sydney); //gets the date and time of Sydneys Zone
                ZonedDateTime dateTimeTYO = ZonedDateTime.now(tokyo); //gets the date and time of Tokyo's Zone
                ZonedDateTime dateTimePAR = ZonedDateTime.now(paris); //gets the date and time of Paris' Zone
                ZonedDateTime dateTimeNY = ZonedDateTime.now(newYork); //gets the date and time of New York's Zone
                ZonedDateTime dateTimeLA = ZonedDateTime.now(losAngeles); //gets the date and time of Los Angeles' Zone
                String ftSDY = dateTimeSDY.format(formatter12hr); // puts the dates and times in a 12 hour format for SDY
                String ftTYO = dateTimeTYO.format(formatter12hr); // puts the dates and times in a 12 hour format for Tokyo
                String ftPAR = dateTimePAR.format(formatter12hr); // puts the dates and times in a 12 hour format for Paris
                String ftNY = dateTimeNY.format(formatter12hr); // puts the dates and times in a 12 hour format for New York
                String ftLA = dateTimeLA.format(formatter12hr); // puts the dates and times in a 12 hour format for Los Angeles
                System.out.println(""); //new line for styling purposes
                System.out.println("1. Sydney, Australia: " + ftSDY); //prints the menu of time options //Sydney
                System.out.println("2. Tokyo, Asia: " + ftTYO);  //2. Tokyo
                System.out.println("3. Paris, France: " + ftPAR); //3. Paris
                System.out.println("4. New York, USA: " + ftNY); //4. New York
                System.out.println("5. Los Angeles, USA: " + ftLA); //5. Los Angeles
                System.out.println("Which time zone would you like to display?"); //Asks the user want time zone to display
                String choice = sc.nextLine(); //choice input line 
                if (choice.equals("1")) { //if choice equals 1
                    startClock(sydney, formatter12hr, sc); //calls startClock method with Sydney as its zone
                } else if (choice.equals("2")) { //if choice equals 2
                    startClock(tokyo, formatter12hr, sc); //calls startClock method with Tokyo as its zone
                } else if (choice.equals("3")) { //if choice equals 3
                    startClock(paris, formatter12hr, sc); //calls startClock method with Paris as its zone
                } else if (choice.equals("4")) { //if choice equals 4
                    startClock(newYork, formatter12hr, sc); //calls startClock method with New York as its zone
                } else if (choice.equals("5")) { //if choice equals 5
                    startClock(losAngeles, formatter12hr, sc); //calls startClock method with Los Angeles as its zone
                } else { //if choice is not one of the options in the menu 
                    System.out.println("Try again. An invalid time zone was selected."); //tells the user their choice was invalid
                    continue; //continue to give the user another chance to select a time zone
                } //end of if else 
            } else if (format.equals("2") || format.equals("24") || format.equals("24hr")  || format.equals("24 hr")){ //if the choice is 24 for 24 hr or 2 for 2nd Option
                ZonedDateTime dateTimeSDY = ZonedDateTime.now(sydney); //gets the date and time of Sydneys Zone
                ZonedDateTime dateTimeTYO = ZonedDateTime.now(tokyo); //gets the date and time of Tokyo's Zone
                ZonedDateTime dateTimePAR = ZonedDateTime.now(paris); //gets the date and time of Paris' Zone
                ZonedDateTime dateTimeNY = ZonedDateTime.now(newYork); //gets the date and time of New York's Zone
                ZonedDateTime dateTimeLA = ZonedDateTime.now(losAngeles); //gets the date and time of Los Angeles' Zone
                String ftSDY = dateTimeSDY.format(formatter24hr); // puts the dates and times in a 24 hour format for SDY
                String ftTYO = dateTimeTYO.format(formatter24hr); // puts the dates and times in a 24 hour format for Tokyo
                String ftPAR = dateTimePAR.format(formatter24hr); // puts the dates and times in a 24 hour format for Paris
                String ftNY = dateTimeNY.format(formatter24hr); // puts the dates and times in a 24 hour format for New York
                String ftLA = dateTimeLA.format(formatter24hr); // puts the dates and times in a 24 hour format for Los Angeles
                System.out.println(""); //new line for styling purposes
                System.out.println("1. Sydney, Australia: " + ftSDY); //prints the menu of time options //Sydney
                System.out.println("2. Tokyo, Asia: " + ftTYO);  //2. Tokyo
                System.out.println("3. Paris, France: " + ftPAR); //3. Paris
                System.out.println("4. New York, USA: " + ftNY); //4. New York
                System.out.println("5. Los Angeles, USA: " + ftLA); //5. Los Angeles
                System.out.println("Which time zone would you like to display?"); //Asks the user want time zone to display
                String choice = sc.nextLine(); //choice input line 
                if (choice.equals("1")) { //if choice equals 1
                    startClock(sydney, formatter24hr, sc); //calls startClock method with Sydney as its zone
                } else if (choice.equals("2")) { //if choice equals 2
                    startClock(tokyo, formatter24hr, sc); //calls startClock method with Tokyo as its zone
                } else if (choice.equals("3")) { //if choice equals 3
                    startClock(paris, formatter24hr, sc); //calls startClock method with Paris as its zone
                } else if (choice.equals("4")) { //if choice equals 4
                    startClock(newYork, formatter24hr, sc); //calls startClock method with New York as its zone
                } else if (choice.equals("5")) { //if choice equals 5
                    startClock(losAngeles, formatter24hr, sc); //calls startClock method with Los Angeles as its zone
                } else { //if choice isn't an option from the menu
                    System.out.println("Try again. An invalid time zone was selected."); //tells the user their choice was invalid 
                    continue; //continue gives the user another change to select a time zone
                } //end of if else
            } else { //if there is an error when selecting a 12 or 24 hour format
                continue; //gives the user another chance to respond
            } //end of format if else
        } //end of while loop
    } //end of main
    public static void startClock(ZoneId zone, DateTimeFormatter formatter, Scanner sc) { //start clock method 
        Runnable printTimeTask = () -> { //prints the time 
            ZonedDateTime currentTime = ZonedDateTime.now(zone); //gets the zone and finds the current time of that zone
            System.out.println("Current time: " + currentTime.format(formatter)); //prints the format with the selected time format 
        }; //end of print time 
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(); //scheduler for the time for print
        scheduler.scheduleAtFixedRate(printTimeTask, 0, 10, TimeUnit.SECONDS); //sets it to print again every ten seconds
        System.out.println("\nPress ENTER to reselect a time zone."); //tells the user to print enter to reselect a time zone
        sc.nextLine(); //new input line 
        scheduler.shutdownNow(); //once something is entered into the input line, the scheduler will shutdown
        System.out.println("Returning to menu...\n"); //the user will return to the menu in the loop above
    } //end of start clock method
} //end of class
package Users;

import java.util.Scanner;
import java.util.ArrayList;

import SystemModels.Reservation;
import SystemModels.Room;

public class PublicUser {
  private String name;
  private String id;
  private static ArrayList<Reservation> reservations = new ArrayList<>();
  private static ArrayList<Room> rooms = new ArrayList<>();


  private static final Scanner input = new Scanner(System.in);

  public PublicUser(String name, String id){
    this.name = name;
    this.id = id;
  }

  public String getName(){
    return this.name;
  }

  public String getId(){
    return this.id;
  }

  public static ArrayList<SystemModels.Reservation> getReservations(){
    return reservations;
  }

  public static ArrayList<SystemModels.Room> getRooms(){
    return rooms;
  }
  
  public void setName(String name){
    this.name = name;
  }

  public void setId(String id){
    this.id = id;
  }

  private void publicMenu(){
    boolean exitPublicUser = false;
    while(!exitPublicUser){
      System.out.println("=".repeat(40));
      System.out.println("PUBLIC DASHBOARD");
      System.out.println("=".repeat(40));
      System.out.println("[1] View Live Occupancy of Rooms");
      System.out.println("[2] Reserve an Available Room");
      System.out.println("[3] View My Reservation Status");
      System.out.println("[4] Return to Main Menu");
      System.out.print("Select an option: ");

      int choice = input.nextInt();

      switch (choice) {
        case 1 -> viewLiveOccupancy();
        case 2 -> reserveRoom();
        case 3 -> viewReservationStatus();
        default -> exitPublicUser = true;
      }
    }
  }

  private void viewLiveOccupancy(){
    Admin.checkLiveRoomAvailability();
  }

  private void reserveRoom(){
    System.out.println("=".repeat(40));
    System.out.println("SUBMIT A ROOM RESERVATION");
    System.out.println("-".repeat(40));
    System.out.print("Enter your Name: ");
    String name = input.nextLine();
    System.out.print("Enter Room Name to reserve: ");
    String room = input.nextLine();
    System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
    String date = input.nextLine();

    String newId = String.valueOf((int) (Math.random() * 9000) + 1000);

    reservations.add(new SystemModels.Reservation(newId, name, room, date));
    System.out.println("Reservation submitted successfully!");
    System.out.println("Your Reservation ID is: " + newId + " Please remember ID for status later)");
  }

  private void viewReservationStatus(){
    System.out.println("=".repeat(40));
    System.out.println("LOOKUP RESERVATION STATUS");
    System.out.println("-".repeat(40));
    System.out.print("Enter your Reservation ID: ");
    String id = input.nextLine().trim();

    boolean found = false;
    System.out.printf("%-6s %-15s %-12s %-12s %-10s%n", "ID", "User", "Room", "Date", "Status");
    for (SystemModels.Reservation r : reservations) {
      if (r.id.equalsIgnoreCase(id)) {
          System.out.printf("%-6s %-15s %-12s %-12s %-10s%n", r.id, r.user, r.room, r.date, r.status);
          found = true;
      }
    }

    if (!found) {
      System.out.println("No reservations found for: " + id);
      return;
    }
  }
}
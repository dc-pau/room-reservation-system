package Users;

import java.util.Scanner;

import java.util.ArrayList;

import SystemModels.Reservation;
import SystemModels.Room;

public class Admin extends PublicUser {
  private static final Scanner input = new Scanner(System.in);

  private String pin;
  private ArrayList<Admin> admin = new ArrayList<>();
  public Admin(String name, String id) {
    super(name, id);
  }

  public ArrayList<Admin> getAdmins(){
    return admin;
  }

  public static void adminMenu(){
    boolean exitAdminUser = false;
    while(!exitAdminUser){
      System.out.println("=".repeat(40));
      System.out.println("ADMIN DASHBOARD");
      System.out.println("=".repeat(40));
      System.out.println("[1] Check Live Room Availability");
      System.out.println("[2] Review Pending Reservations");
      System.out.println("[3] Log Out to Main Menu");
      System.out.println("=".repeat(40));
      System.out.print("Select an option: ");

      int choice = input.nextInt();

      switch (choice) {
        case 1 -> checkLiveRoomAvailability();
        case 2 -> reviewPendingReservations();
        default -> exitAdminUser = true; 
      }
    }
  }

  public static void checkLiveRoomAvailability(){
    ArrayList<Reservation> reservations = PublicUser.getReservations();
    ArrayList<Room> rooms = PublicUser.getRooms();
    ArrayList<Room> available = new ArrayList<>();
    System.out.println("LIVE ROOM AVAILABILITY"); 
    System.out.println("=".repeat(60));
    if (reservations.isEmpty()) {
      System.out.println("No reservations available.");
      return;
    } 

    for(Room r : rooms){
      if(r.getStatus().equalsIgnoreCase("Available")){
        available.add(r);
      }
    }

    if(available.isEmpty()){
      System.out.println("Mo available rooms.");
      return;
    }

    System.out.printf("%-12s %-10s %-20s %-12s%n", "Room", "Capacity", "Equipment", "Status");
    System.out.println("-".repeat(60));
    // Loop prints ALL rooms first
    for (Room r : rooms) {
        System.out.printf("%-12s %-10d %-20s %-12s%n", r.roomName, r.capacity, r.equipment, r.status);
    }
  }

  private static void reviewPendingReservations(){
    ArrayList<Reservation> reservations = PublicUser.getReservations(); 
    System.out.println("PENDING RESERVATION APPROVALS");
    System.out.println("=".repeat(60));
    boolean hasPending = false;

    System.out.printf("%-6s %-15s %-12s %-12s %-10s%n", "ID", "User", "Room", "Date", "Status");
    System.out.println("-".repeat(60));

    for (Reservation r : reservations) {
      if (r.status.equalsIgnoreCase("Pending")) {
        System.out.printf("%-6s %-15s %-12s %-12s %-10s%n", r.getId(), r.getUser(), r.getRoom(), r.getDate(), r.getStatus());
        hasPending = true;
      }
    }

    if (!hasPending) {
      System.out.println("No pending requests at this time.");
      return;
    }

    System.out.print("/nEnter Reservation ID to Approve/Reject (or press Enter to skip): ");
    String targetId = input.nextLine().trim();
    
    for(Reservation r : reservations){
      if(r.getId().equalsIgnoreCase(targetId)){
        System.out.println("Reservation ID found!");
        System.out.println("Choose option:");
        System.out.println("[1] Approve");
        System.out.println("[2] Reject");
        int action = input.nextInt();
        if(action == 1){ 
          r.setStatus("Approved");
          System.out.println("Reservation ID " + targetId + " has been Approved.");
        }else{
          r.setStatus("Rejected");
          System.out.println("Reservation ID " + targetId + " has been Rejected.");
        }
        return;
      }
    }
  }
}  

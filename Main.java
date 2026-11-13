import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  private static final String ADMIN_PIN = "admin";
  private static final Scanner input = new Scanner(System.in);

  private static void adminLogin(){
    System.out.print("Enter Admin PIN: ");
    String pin = input.nextLine().trim();
    if(pin.equals(ADMIN_PIN)){

    }else{
      System.out.println("Incorrect PIN. Access Denied.");
    }                
  }
  public static void main(String[] args){
    boolean isExit = false;

    while(!isExit){
      System.out.println("=".repeat(50));
      System.out.println("SCHOOL TIMETABLE & ROOM SYSTEM");
      System.out.println("=".repeat(50));
      System.out.println("[1] Admin Login");
      System.out.println("[2] Public Portal");
      System.out.println("[3] Quick Room Lookup");
      System.out.println("[0] Exit Application");
      System.out.println("=".repeat(50));
      System.out.print("Select choice: ");

      int choice = Integer.parseInt(input.nextLine().trim());

      switch (choice) {
        case 1 -> adminLogin();
        case 2 -> publicPortal(); 
        case 3 -> quickRoomLookup();
        default -> isExit = true;
      }
    }
  }
}
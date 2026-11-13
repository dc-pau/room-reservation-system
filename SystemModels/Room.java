package SystemModels;

import java.util.ArrayList;

public class Room {
  public String roomName;
  public int capacity;
  public String equipment;
  public String status;

  public Room(String roomName, int capacity, String equipment, String status) {
      this.roomName = roomName;
      this.capacity = capacity;
      this.equipment = equipment;
      this.status = status;
  }

  public String getRoomName(){
    return roomName;
  }

  public int getCapacity(){
    return capacity;
  }

  public String getEquipment(){
    return equipment;
  }

  public String getStatus(){
    return status;
  }

// setter - dont setter for less 
  public void setRoomName(String Name) {
    this.roomName = Name;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}  
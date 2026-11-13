package SystemModels;

public class Reservation {
  public String id;
  public String user;
  public String room;
  public String date;
  public String status;

  public Reservation(String id, String user, String room, String date) {
      this.id = id;
      this.user = user;
      this.room = room;
      this.date = date;
      this.status = "Pending";
  }

  public String getId() {
      return id;
  }

  public String getUser() {
      return user;
  }

  public String getRoom() {
      return room;
  } 

  public String getDate() {
      return date;
  }

  public String getStatus() {
      return status;
  }

  public void setRoom(String room) {
      this.room = room;
  }

  public void setStatus(String status) {
      this.status = status;
  }

}

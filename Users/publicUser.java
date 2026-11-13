package Users;

public class publicUser {
  private String name;
  private String id;

  public publicUser(String name, String id){
    this.name = name;
    this.id = id;
  }

  public String getName(){
    return this.name;
  }

  public String getId(){
    return this.id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setId(String id){
    this.id = id;
  }
}
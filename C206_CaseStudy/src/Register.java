public class Register {
  private String iD;
  private String name;
  private int phonenumber;
  
  public Register(String iD, String name, int phonenumber) {
    // TODO Auto-generated constructor stub
    this.iD = iD;
    this.name = name;
    this.phonenumber = phonenumber;
  }

  public String getiD() {
    return iD;
  }

  public void setiD(String iD) {
    this.iD = iD;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getphonenumber() {
    return phonenumber;
  }

  public void setphonenumber(int phonenumber) {
    this.phonenumber = phonenumber;
  }
  

  }
package springboot.domain;

public class User {
    /**
     * 学号
     */
    private int userID;
    /**
     * 姓名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 班级
     */
    private String password;

    /**
     * 院系
     */
    private String phone;

    public User(int userID, String username, String password, String email, String phone) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(){}
    public int getUserID(){
        return userID;
    }
    public void setUserID(int id){
        this.userID=id;
    }

    public String getUserName(){
        return username;
    }
    public void setUserName(String name){
        this.username=name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String mail){
        this.email=mail;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }


}

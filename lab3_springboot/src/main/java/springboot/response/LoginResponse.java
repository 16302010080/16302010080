package springboot.response;

public class LoginResponse {
    private String username;
    private String password;

    private String log;

    public LoginResponse(){}

    public LoginResponse(String log){
        this.log=log;
    }
    public LoginResponse(String username,String password,String log){
        this.username=username;
        this.password=password;
        this.log=log;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password=password;
    }
    public String getLog(){return log;}

    public void setLog(String log){
        this.log=log;
    }
}

package springboot.response;

public class ErrorResponse {
    private String responseText;
    public ErrorResponse(String responseText) {
        this.responseText=responseText;
    }
    public String getResponseText(){return responseText;}

    public void setResponseText(String text){this.responseText=text;}
}

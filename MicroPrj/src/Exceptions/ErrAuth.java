package Exceptions;

public class ErrAuth extends Exception{
    
    String username,password;
    
    public ErrAuth(String username,String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }
}


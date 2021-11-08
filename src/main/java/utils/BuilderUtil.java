package utils;

import builders.LogIn;
import builders.Register;
import builders.User;

public class BuilderUtil {

    public User buildUser(String name, String job){
        return User.builder()
                .name(name)
                .job(job)
                .build();
    }

    public Register buildRegister(String email, String password){
        return Register.builder()
                .email(email)
                .password(password)
                .build();
    }

    public LogIn buildLogIn(String email, String password){
        return LogIn.builder()
                .email(email)
                .password(password)
                .build();
    }
}

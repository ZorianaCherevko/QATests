package api.utils;

import api.builders.LogIn;
import api.builders.Register;
import api.builders.User;

public class BuilderUtil {

    public User buildUser(String name, String job){
        return User.builder()
                .name(name)
                .job(job)
                .build();
    }

    public User buildMinUser(String name){
        return User.builder()
                .name(name)
                .build();
    }

    public Register buildRegister(String email, String password){
        return Register.builder()
                .email(email)
                .password(password)
                .build();
    }

    public Register buildRegisterWithoutPassword(String email){
        return Register.builder()
                .email(email)
                .build();
    }

    public LogIn buildLogIn(String email, String password){
        return LogIn.builder()
                .email(email)
                .password(password)
                .build();
    }

    public LogIn buildLogInWithoutPassword(String email){
        return LogIn.builder()
                .email(email)
                .build();
    }
}

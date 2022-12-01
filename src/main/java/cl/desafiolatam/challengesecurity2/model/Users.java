package cl.desafiolatam.challengesecurity2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class Users{//La clase Users, contiene datos básicos del usuario, además implementa Serializable, lo que se utilizará en los pasos posteriores por MyBatis


    private String email;
    private String password;
    private Role role;

}
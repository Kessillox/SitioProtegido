package cl.desafiolatam.challengesecurity2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    private String email;
    private String password;
    private Role role;

}
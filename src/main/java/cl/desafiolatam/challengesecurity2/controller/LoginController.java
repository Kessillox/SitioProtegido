package cl.desafiolatam.challengesecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	//Modelo y vista de login, metodo GET.
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}

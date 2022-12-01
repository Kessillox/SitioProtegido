package cl.desafiolatam.challengesecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	//Modelo y vista de cliente, metodo GET.
    @GetMapping("/client")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("client");
        return modelAndView;
    }

}
package cl.desafiolatam.challengesecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdminController {
	@GetMapping("/admin")//Modelo y vista de admin, metodo GET.
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

}
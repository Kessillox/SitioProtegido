package cl.desafiolatam.challengesecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ErrorController {
	//Modelo y vista de error 403: Forbidden. Metodo GET.
    @GetMapping()
    public ModelAndView recurso03() {
        return new ModelAndView("error/403");
    }

}

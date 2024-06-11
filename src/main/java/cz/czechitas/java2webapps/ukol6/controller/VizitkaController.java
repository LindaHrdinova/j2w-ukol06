package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {

    private final VizitkaRepository repository;

    public VizitkaController(VizitkaRepository repository) {
        this.repository = repository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("vizitky", repository.findAll());
    }

}

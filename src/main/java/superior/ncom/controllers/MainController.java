package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}

package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import superior.ncom.ComplejoBinomico;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/sumar")
    public ModelAndView sumar(@RequestParam("parteReal1") String parteReal1, @RequestParam("parteImaginaria1") String parteImaginaria1, @RequestParam("parteReal2") String parteReal2, @RequestParam("parteImaginaria2") String parteImaginaria2) {
        ComplejoBinomico complejoBinomico1 = new ComplejoBinomico(parteReal1, parteImaginaria1);
        ComplejoBinomico complejoBinomico2 = new ComplejoBinomico(parteReal2, parteImaginaria2);
        complejoBinomico1.suma(complejoBinomico2);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejoBinomico1.mostrar());

        return new ModelAndView("index", modelMap);
    }
}

package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import superior.ncom.ComplejoBinomico;
import superior.ncom.ComplejoPolar;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/irAPolares")
    public ModelAndView irAPolares() {
        return new ModelAndView("operacionesPolares");
    }

    @RequestMapping(value = "/irABinomicos")
    public ModelAndView irABinomicos() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/ejecutarBinomicos", method = RequestMethod.POST)
    public ModelAndView ejecutarBinomicos(@RequestParam("primeraParte1") String primeraParte1, @RequestParam("segundaParte1") String segundaParte1, @RequestParam("primeraParte2") String primeraParte2, @RequestParam("segundaParte2") String segundaParte2, @RequestParam("operacion") String operacion) {

        ComplejoBinomico complejoBinomico1 = new ComplejoBinomico(primeraParte1, segundaParte1);
        ComplejoBinomico complejoBinomico2 = new ComplejoBinomico(primeraParte2, segundaParte2);

        complejoBinomico1.operar(complejoBinomico2, operacion);

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejoBinomico1.mostrar());
        modelMap.addAttribute("primeraParte1", primeraParte1);
        modelMap.addAttribute("primeraParte2", primeraParte2);
        modelMap.addAttribute("segundaParte1", segundaParte1);
        modelMap.addAttribute("segundaParte2", segundaParte2);
        modelMap.addAttribute("operacionSeleccionada", operacion);
        return new ModelAndView("index", modelMap);
    }

    @RequestMapping(value = "/ejecutarPolares", method = RequestMethod.GET)
    public ModelAndView sumar(@RequestParam("primeraParte1") String primeraParte1, @RequestParam("segundaParte1") String segundaParte1, @RequestParam("primeraParte2") String primeraParte2, @RequestParam("segundaParte2") String segundaParte2, @RequestParam("operacion") String operacion) {

        ComplejoPolar complejoPolar1 = new ComplejoPolar(primeraParte1, segundaParte1);
        ComplejoPolar complejoPolar2 = new ComplejoPolar(primeraParte1, segundaParte1);

        complejoPolar1.operar(complejoPolar2, operacion);

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejoPolar1.mostrar());
        modelMap.addAttribute("primeraParte1", primeraParte1);
        modelMap.addAttribute("primeraParte2", primeraParte2);
        modelMap.addAttribute("segundaParte1", segundaParte1);
        modelMap.addAttribute("segundaParte2", segundaParte2);
        modelMap.addAttribute("operacionSeleccionada", operacion);
        return new ModelAndView("operacionesPolares", modelMap);
    }
}
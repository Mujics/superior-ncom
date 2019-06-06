package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import superior.ncom.ComplejoBinomico;
import superior.ncom.ComplejoPolar;

import java.util.Map;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("operacionesBinomicas");
    }

    @RequestMapping(value = "/irAPolares")
    public ModelAndView irAPolares() {
        return new ModelAndView("operacionesPolares");
    }

    @RequestMapping(value = "/irABinomicos")
    public ModelAndView irABinomicos() {
        return new ModelAndView("operacionesBinomicas");
    }

    @RequestMapping(value = "/ejecutarBinomicos", method = RequestMethod.POST)
    public ModelAndView ejecutarBinomicos(@RequestParam Map<String,String> allParams) {

        ComplejoBinomico complejoBinomico1 = new ComplejoBinomico(allParams.get("primeraParte1"), allParams.get("segundaParte1"));
        ComplejoBinomico complejoBinomico2 = new ComplejoBinomico(allParams.get("primeraParte2"), allParams.get("segundaParte2"));

        complejoBinomico1.operar(complejoBinomico2, allParams.get("operacion"));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejoBinomico1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operacionesBinomicas", modelMap);
    }

    @RequestMapping(value = "/ejecutarPolares", method = RequestMethod.POST)
    public ModelAndView ejecutarPolares(@RequestParam Map<String,String> allParams) {
        ComplejoPolar complejoPolar1 = new ComplejoPolar(allParams.get("primeraParte1"), allParams.get("segundaParte1"));
        ComplejoPolar complejoPolar2 = new ComplejoPolar(allParams.get("primeraParte2"), allParams.get("segundaParte2"));

        complejoPolar1.operar(complejoPolar2, allParams.get("operacion"));
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejoPolar1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operacionesPolares", modelMap);
    }
}

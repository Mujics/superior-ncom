package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import superior.ncom.Complejo;
import superior.ncom.ComplejoFactory;

import java.util.Map;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("operaciones");
    }

    @RequestMapping(value = "/calcular", method = RequestMethod.POST)
    public ModelAndView calcular(@RequestParam Map<String,String> allParams) {
        Complejo complejo1 = ComplejoFactory.create(allParams.get("primeraParte1"), allParams.get("segundaParte1"), allParams.get("tipo1"));
        Complejo complejo2 = ComplejoFactory.create(allParams.get("primeraParte2"), allParams.get("segundaParte2"), allParams.get("tipo2"));

        complejo1.operar(complejo2, allParams.get("operacion"));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejo1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/calcularEspeciales", method = RequestMethod.POST)
    public ModelAndView calcularEspecial(@RequestParam Map<String,String> allParams) {
        Complejo complejo1 = ComplejoFactory.create(allParams.get("primeraParte1Especial"), allParams.get("segundaParte1Especial"), allParams.get("tipo1Especial"));
        Double numero = Double.parseDouble(allParams.get("numeroEspecial"));

        complejo1.operar(numero, allParams.get("operacionEspecial"));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultadoEspecial", complejo1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/cambiarDeTipoEspecial", method = RequestMethod.POST)
    public ModelAndView cambiarDeTipoEspecial(@RequestParam Map<String,String> allParams) {
        Complejo complejo = ComplejoFactory.createFromString(allParams.get("resultadoEspecial"));
        Complejo complejo1 = complejo.transformar();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultadoEspecial", complejo1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/cambiarDeTipo", method = RequestMethod.POST)
    public ModelAndView cambiarDeTipo(@RequestParam Map<String,String> allParams) {
        Complejo complejo = ComplejoFactory.createFromString(allParams.get("resultado"));
        Complejo complejo1 = complejo.transformar();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejo1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }
}

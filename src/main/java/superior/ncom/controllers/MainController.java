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
import java.util.Objects;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("operaciones");
    }

    @RequestMapping(value = "/calcular", method = RequestMethod.POST)
    public ModelAndView calcular(@RequestParam Map<String,String> allParams) {
        Complejo complejo1 = ComplejoFactory.create(allParams.get("complejo1"));
        Complejo complejo2 = ComplejoFactory.create(allParams.get("complejo2"));

        ModelMap modelMap = new ModelMap();
        try {
            complejo1.operar(complejo2, allParams.get("operacion"));
            modelMap.addAttribute("resultado", complejo1.mostrar());
            modelMap.addAttribute("resultadoCompleto", complejo1.mostrarCompleto());
        } catch (Exception e) {
            modelMap.addAttribute("resultado", "Error");
            modelMap.addAttribute("resultadoCompleto", "Error");
        }

        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/calcularEspeciales", method = RequestMethod.POST)
    public ModelAndView calcularEspecial(@RequestParam Map<String,String> allParams) {
        Complejo complejo1 = ComplejoFactory.create(allParams.get("complejoEspecial"));
        ModelMap modelMap = new ModelMap();
        try {
            Double numero = Double.parseDouble(allParams.get("numeroEspecial"));
            complejo1.operar(numero, allParams.get("operacionEspecial"));
            if (!Objects.equals(allParams.get("operacionEspecial"), "raiz")) {
                modelMap.addAttribute("resultadoEspecial", complejo1.mostrar());
            } else {
                modelMap.addAttribute("resultadoEspecial", complejo1.mostrarCon2KPI(Integer.parseInt(allParams.get("numeroEspecial"))));
            }

            modelMap.addAttribute("resultadoEspecialCompleto", complejo1.mostrarCompleto());
        } catch (Exception e) {
            modelMap.addAttribute("resultadoEspecial", "Error");
        }

        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/cambiarDeTipoEspecial", method = RequestMethod.POST)
    public ModelAndView cambiarDeTipoEspecial(@RequestParam Map<String,String> allParams) {
        Complejo complejo = ComplejoFactory.create(allParams.get("resultadoEspecial"));
        Complejo complejo1 = complejo.transformar();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultadoEspecial", complejo1.mostrar());
        modelMap.addAttribute("resultadoEspecialCompleto", complejo1.mostrarCompleto());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }

    @RequestMapping(value = "/cambiarDeTipo", method = RequestMethod.POST)
    public ModelAndView cambiarDeTipo(@RequestParam Map<String,String> allParams) {
        Complejo complejo = ComplejoFactory.create(allParams.get("resultado"));
        Complejo complejo1 = complejo.transformar();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", complejo1.mostrar());
        modelMap.addAttribute("resultadoCompleto", complejo1.mostrarCompleto());
        modelMap.addAttribute("allParams", allParams);
        return new ModelAndView("operaciones", modelMap);
    }
}

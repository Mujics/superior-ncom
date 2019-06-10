package superior.ncom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import superior.ncom.FuncionTrigonometrica;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/funciones")
public class FuncionesCosenoController {
    @RequestMapping(value = "")
    public ModelAndView index() {
        return new ModelAndView("operacionesConFunciones");
    }

    @RequestMapping(value = "/calcular", method = RequestMethod.POST)
    public ModelAndView calcular(@RequestParam Map<String,String> allParams) {
        String formula = "";
        FuncionTrigonometrica funcionTrigonometrica1 = new FuncionTrigonometrica(allParams.get("amplitud1"), allParams.get("frecuencia1"), allParams.get("fase1"), allParams.get("tipo1"));
        FuncionTrigonometrica funcionTrigonometrica2 = new FuncionTrigonometrica(allParams.get("amplitud2"), allParams.get("frecuencia2"), allParams.get("fase2"), allParams.get("tipo2"));
        formula += funcionTrigonometrica1.mostrar() + allParams.get("operacion") + funcionTrigonometrica2.mostrar() + " = ";
        if (Objects.equals(allParams.get("operacion"), "+")) {
            funcionTrigonometrica1.sumar(funcionTrigonometrica2);
        } else {
            funcionTrigonometrica1.restar(funcionTrigonometrica2);
        }


        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("resultado", funcionTrigonometrica1.mostrar());
        modelMap.addAttribute("allParams", allParams);
        modelMap.addAttribute("formula", formula);
        return new ModelAndView("operacionesConFunciones", modelMap);
    }
}

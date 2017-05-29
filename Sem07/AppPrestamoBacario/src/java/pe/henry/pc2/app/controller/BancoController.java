package pe.henry.pc2.app.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import pe.henry.pc2.app.model.PrestamoModel;
import pe.henry.pc2.app.service.BancoService;


@Controller
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/banco.prestamo", method = RequestMethod.POST)
    public String procesar(
            @RequestParam("meses") int meses,
            @RequestParam("capital") double capital,
            @RequestParam("interes") double interes, 
            Model model) {
        // Proceso
        PrestamoModel prestamoModel = bancoService.procesar(meses, capital, interes);
        //Reporte
        model.addAttribute("prestamo", prestamoModel);
        return "index";
    }
    
}

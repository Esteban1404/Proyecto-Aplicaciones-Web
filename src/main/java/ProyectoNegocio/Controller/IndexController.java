
package ProyectoNegocio.Controller;

import ProyectoNegocio.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    
    @Autowired
    InventarioService inventarioService;

    @GetMapping("/")
    public String inicio(Model model) {
      

        var inventarios = inventarioService.getInventarios(true);
        model.addAttribute("inventarios", inventarios);  //Traer lista de inventarios

        return "index";
    }

}

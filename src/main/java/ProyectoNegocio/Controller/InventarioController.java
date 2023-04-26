    
package ProyectoNegocio.Controller;

import ProyectoNegocio.domain.Inventario;
import ProyectoNegocio.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InventarioController {
    
     @Autowired
    InventarioService inventarioService;
    
    

    @GetMapping("/inventario/listado")
    public String inicio(Model model) {        
                        var inventarios = inventarioService.getInventarios(false);
        model.addAttribute("inventarios", inventarios);  //Traer lista de inventarios

        return "/inventario/listado";
    }

    @GetMapping("/inventario/nuevo")
    public String nuevoInventario(Inventario inventario,Model model) {
       
        model.addAttribute("inventarios",inventario);
        return "/inventario/modificar";          //NUEVO INVENTARIO

    }

    @PostMapping("/inventario/guardar")
    public String guardarInventario(Inventario inventario) {
        inventarioService.save(inventario);           //GUARDAR INVENTARIO  
        return "redirect:/inventario/listado";

    }  

    @GetMapping("/inventario/modificar/{idInventario}")
    public String modificarInventario(Inventario inventario, Model model) {
       
        inventario = inventarioService.getInventario(inventario);
        model.addAttribute("inventario", inventario);        //MODIFICAR INVENTARIO                    
        return "/inventario/modificar";

    }

    @GetMapping("/inventario/eliminar/{idInventario}")
    public String eliminarInventario(Inventario inventario) {
        //ELIMINAR CLIENTE
        inventarioService.delete(inventario);
        return "redirect:/inventario/listado";

    }
    
}

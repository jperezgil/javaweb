package edu.cibertec.plantillarest.controller;
/**
 *
 * @author jpere
 */
import edu.cibertec.plantillarest.bean.Cliente;
import edu.cibertec.plantillarest.bean.Pet;
import edu.cibertec.plantillarest.service.ClienteService;
import edu.cibertec.plantillarest.service.PetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Para costruir una aplicacion MVC con Thymeleaf
@Controller
public class HomeController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PetService petService;
    
    @GetMapping("/home")
    public String home (Model model){
        List<Cliente> listaCliente = clienteService.listarCliente();
        model.addAttribute("listCliente",listaCliente);
        return "home";
    }
    @GetMapping("/home_pet")
    public String home_pet (Model model){
        List<Pet> listPet = petService.findAll();
        model.addAttribute("listaPet",listPet);
        return "home_pet";
    }
    
}

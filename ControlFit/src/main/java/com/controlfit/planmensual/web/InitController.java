package com.controlfit.planmensual.web;

import com.controlfit.planmensual.domain.PlanMensual;
import com.controlfit.planmensual.service.iPlanMensualService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InitController {
    
    @Autowired
    private iPlanMensualService planMensualService;
    
    
    @GetMapping("/")
    public String inicio(Model model){
        //Para User importar -> org.springframework.security.core.userdetails.User;
        //Para @AuthenticationPrincipal importar -> org.springframework.security.core.annotation.AuthenticationPrincipal;
        var planMensual = planMensualService.listarPlanMensual(); //Accedemos a la query personalizada
        model.addAttribute("PlanMensual", planMensual); //mostramos los resultados de la query en la vista
        
        //El template al que se comparte
        return "index.html";
    }
    
    @PostMapping("/guardar")
    //En este metodo Spring usa la informacion de "persona" del formulario
    //Se antepone la notacion @Valid para validar la informacion recibida
    public String guardar(@Valid PlanMensual planMensual, Errors errors){
        //en caso de que tenga errores, se retorna a "modificar"
        if(errors.hasErrors()){
            return "/";
        }
        planMensualService.savePlan(planMensual);
        return "redirect:/"; //redireccionamos a la pagina de inicio luego de guardar.
    }
    
    
    
    
    
    /*
    
    
     //Con este metodo se conecta el submit del HTML
    public String save(@Valid PlanMensual planMensual, Errors errors){
        //en caso de que tenga errores, se retorna a "/"
        if(errors.hasErrors()){
            return "/";
        }
        planMensualService.savePlan(planMensual);
        return "redirect:/"; //redireccionamos a la pagina de inicio luego de guardar.
    }
    
    @GetMapping("/savePlan")
    public String savePlan(PlanMensual planMensual){
        return "/"; //Retornamos directamente porque Spring va a inyectar de forma automatica un objeto Persona
        //No es necesario usar "new" para crear el objeto, gracias a Spring
    }
    
    //aca se coloca el valor de {idpersona} ya que usamos "path-variable"
    @GetMapping("/{idplan}")
    public String editar(PlanMensual planMensual, Model model){
        //No se crea un objeto persona para guardar "la persona encontrada" porque reutilizamos la creada por Spring
        planMensual = planMensualService.encontrarPlan(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    */
}

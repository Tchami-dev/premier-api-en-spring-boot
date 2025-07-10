package com.advance.iforce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.advance.iforce.api.model.Employee;
import com.advance.iforce.api.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/employee")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


      @PostMapping("/employee")                                             // repond aux requêtes HTTP POST envoyées par URL 
   public ModelAndView saveEmployee(@ModelAttribute Employee employee){     //affiche un employée enregistré obligatoirement dans un champs de formulaire
    employeeService.saveEmployee(employee); 
    log.info("utilisateur first name =  {} last name ={} mail = {} password = {}", employee.getFirstName(), employee.getLastName(), employee.getmail(), employee.getPasswords());                                       // enregistrement des donnnées dans la couche service + repository
    return new ModelAndView("redirect:/");                                  //redirige l'utilisateur vers la page d'accueil
   }


      

}
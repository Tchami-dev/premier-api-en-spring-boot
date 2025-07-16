package com.advance.iforce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;
import java.lang.RuntimeException;

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
   public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){     //affiche un employée enregistré obligatoirement dans un champs de formulaire
    log.info("utilisateur first name =  {} last name ={} mail = {} password = {}", employee.getFirstName(), employee.getLastName(), employee.getMail(), employee.getPassword());                                       // enregistrement des donnnées dans la couche service + repository
    return ResponseEntity.ok(employeeService.saveEmployee(employee));                                //redirige l'utilisateur vers la page d'accueil
   }

   /**
 * @param id
 */
@DeleteMapping("/deleteEmployee/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
    log.info("suppression effectuer");
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();  
}

@PutMapping("/updateEmployee/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,  @RequestBody Employee updateEmployee){
    log.info("employé modifier avec succès");
    Optional<Employee>employeeOptional = employeeService.getEmployeeById(id);
    if(employeeOptional.isPresent()){
        Employee employee = employeeOptional.get();
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setMail(updateEmployee.getMail());
        employee.setPassword(updateEmployee.getPassword());
        
        log.info("modification effectuer avec succès");
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
        
    }else{
        return ResponseEntity.notFound().build();
    }

}

@GetMapping("/employee/{id}")
public Employee getEmployeeById(@PathVariable Long id){
    log.info("employé récupéré avec succès");
    return employeeService.getEmployeeById(id)
    .orElseThrow(()-> new RuntimeException("employee abscent avec cet id"));
}


    }

      


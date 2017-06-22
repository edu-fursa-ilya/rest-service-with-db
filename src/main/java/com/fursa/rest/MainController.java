package com.fursa.rest;

import com.fursa.rest.entities.Employee;
import com.fursa.rest.entities.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company", method = RequestMethod.GET)
public class MainController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping(path = "/add")
    public @ResponseBody
    List<Employee> add(@RequestParam String name, @RequestParam String surname, @RequestParam int age, @RequestParam double salary) {
        Employee employee = new Employee(name, surname, age, salary);
        repository.save(employee);
        return repository.findAll();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/del")
    public @ResponseBody String remove(@RequestParam long id) {
       Employee employee = repository.findOne(id);
       repository.delete(employee);
       return employee.toString();
    }
}

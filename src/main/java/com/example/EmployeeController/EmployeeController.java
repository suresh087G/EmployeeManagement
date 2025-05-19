package com.example.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Employe.Employe;
import com.example.EmployeeRepository.EmployeeRepository;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String showForm(Employe employee) {
        return "index";
    }

    @PostMapping("/add")
    public String addEmployee(@Validated Employe employee, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        List<Employe> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @GetMapping("/display/{employeeId}")
    public String displayEmployee(@PathVariable String employeeId, Model model) {
        Employe employee = employeeRepository.findByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "employeeDetail";
    }
}


package co.develhope.loginDemo.salary.controllers;
import co.develhope.loginDemo.salary.entities.CreateSalaryDTO;
import co.develhope.loginDemo.salary.entities.Salary;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import co.develhope.loginDemo.user.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import co.develhope.loginDemo.salary.repositories.SalaryRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    public List<Salary> getAll() {
        return salaryRepository.findAll();
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryRepository.findByUserId(id);
    }

    @PostMapping("/user/{id}")
    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    public Salary createSalary(@PathVariable Long id, @RequestBody CreateSalaryDTO salaryDTO) {
        Salary s = new Salary();
        User user = userRepository.findById(id).orElse(null);
        s.setAmount(salaryDTO.getAmount());
        s.setUser(user);
        return salaryRepository.save(s);
    }
}

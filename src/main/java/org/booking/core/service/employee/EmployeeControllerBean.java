package org.booking.core.service.employee;

import org.booking.core.domain.entity.employee.Employee;
import org.booking.core.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeControllerBean implements EmployeeController {


    private EmployeeRepository employeeRepository;

    public EmployeeControllerBean(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long userId, Employee employee) {
        Employee existingUser = employeeRepository.findById(userId).get();
        existingUser.setName(employee.getName());
        existingUser.setEmail(employee.getEmail());
        return employeeRepository.save(existingUser);
    }

    @Override
    public boolean delete(Long userId) {
        try {
            employeeRepository.findById(userId).get();
            employeeRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Employee getById(Long userId) {
        return employeeRepository.findById(userId).get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

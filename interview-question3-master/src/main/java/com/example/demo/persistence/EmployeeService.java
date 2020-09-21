package com.example.demo.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException 
    {

//        repository.save(entity);
//        return entity;
        return repository.save(entity);

//        if(!employee.isPresent())
//        {
//            throw new RecordNotFoundException();
//        }
//            entity = repository.save(entity);
//
//            return entity;
//
//        } else {

//            EmployeeEntity newEntity = employee.get();
//            //newEntity.setId(entity.getId());
//            newEntity.setEmail(entity.getEmail());
//            newEntity.setFirstName(entity.getFirstName());
//            newEntity.setLastName(entity.getLastName());
//
//            newEntity = repository.save(newEntity);
//
//            return newEntity;
//        }
    } 
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}

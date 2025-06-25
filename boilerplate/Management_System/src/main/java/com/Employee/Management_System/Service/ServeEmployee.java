package com.Employee.Management_System.Service;

import com.Employee.Management_System.Entities.Employee;
import com.Employee.Management_System.Repository.EmployeeRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServeEmployee {

    @Autowired
    private EmployeeRepository emp_repo;

    public Employee saveEmployee(Employee e){
        try{
            e=emp_repo.save(e);
            return e;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Employee changeEmployee(Integer id, Employee e){
        try{
            e.setId(id);
            e=emp_repo.save(e);
            return e;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Employee getEmployee(Integer id){
        try{
            Optional<Employee> o=emp_repo.findById(id);
            Employee e=o.get();
            return e;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Employee> getAllEmployee(){
        try{
            Iterable<Employee> res=emp_repo.findAll();
            List<Employee> l= new ArrayList<Employee>();
            res.forEach(e->l.add(e));
            return l;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteEmployeeById(Integer id){
        try{
            emp_repo.deleteById(id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Employee viewEmployeeByFirstName(String name){
        try{
            Employee e=emp_repo.findEByFirstName(name);
            return e;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}

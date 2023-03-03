package org.learn.spring.repository;


import org.learn.spring.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

import java.util.List;


@RestController
@RequestMapping("employee")
public class EmployeeService {
  
  @Autowired
  private EntityManager entityManager;

  private static Logger log = LoggerFactory.getLogger(EmployeeService.class);


  @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
  @Transactional
  @ResponseBody
  public ResponseEntity register(@RequestBody Employee employee) {
    log.info("register emp :{}", employee);

    try {

      if (employee.getId() > 0) {
        entityManager.merge(employee);
      } else {
        entityManager.persist(employee);

      }


      log.info("merged employee :{}", employee);
      return new ResponseEntity(employee, HttpStatus.OK);
    } catch (Exception e) {
      log.error("employee regisgtered", e);
      return new ResponseEntity("register Error", HttpStatus.INTERNAL_SERVER_ERROR);
      //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"addOrUpdateCustomer Error",e);
      //return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),e.getMessage()).build();
    }
  }

  @GetMapping(value = "/list", produces = "application/json")
  @Transactional
  @ResponseBody
  public ResponseEntity listAllEmployee(){
    try{
        List<Employee> employeeList = entityManager.
          createQuery("from Employee").getResultList();
        return  new ResponseEntity(employeeList, HttpStatus.OK);
    } catch (Exception e){
      log.error("listAllEmployee err",e);
      return new ResponseEntity("listAllEmployee Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/search-by-name", produces = "application/json")
  @Transactional
  @ResponseBody
  public ResponseEntity searchEmployeeByName(@RequestParam String name){

    List<Employee> employeeList = entityManager.
      createQuery("from Employee where upper(name) like :name")
      .setParameter("name","%"+String.valueOf(name).toUpperCase()+"%")
      .getResultList();
    return  new ResponseEntity(employeeList, HttpStatus.OK);
  }

}

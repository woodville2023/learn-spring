package org.learn.spring.repository;

import org.learn.spring.model.Customer;
import org.learn.spring.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;


@RestController
@RequestMapping("insurance")
public class InsuranceService /*implements InsuranceService*/ {

  @Autowired
  private EntityManager entityManager;

  private static Logger log = LoggerFactory.getLogger(InsuranceService.class);


  @PostMapping(value = "/customer/add",consumes = "application/json",produces = "application/json")
  @Transactional
  @ResponseBody
  public ResponseEntity addOrUpdateCustomer(@RequestBody Customer customer) {
    log.info("addOrUpdateCustomer :{}", customer);

    try {

      if(customer.getId() > 0){
        entityManager.merge(customer);
      }else{
        entityManager.persist(customer);

      }

      

      log.info("merged customer :{}",customer);
      return new ResponseEntity(customer,HttpStatus.OK);
    } catch (Exception e) {
     log.error("addOrUpdateVehicle",e);
      return new ResponseEntity("addOrUpdateCustomer Error",HttpStatus.INTERNAL_SERVER_ERROR);
     //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"addOrUpdateCustomer Error",e);
     //return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),e.getMessage()).build();
    }
  }


  @PostMapping(value = "/vehicle/add",consumes = "application/json",produces = "application/json")
  @Transactional
  @ResponseBody
  public ResponseEntity addOrUpdateVehicle(@RequestBody Vehicle vehicle) {
    log.info("addOrUpdateVehicle :{}", vehicle);
    try {
      if(vehicle.getId() > 0){
        entityManager.merge(vehicle);
      } else{
        entityManager.persist(vehicle);
      }

      log.info("merged vehicle :{}",vehicle);
      return  new ResponseEntity(vehicle,HttpStatus.FORBIDDEN.OK);
      //return vehicle;
    } catch (Exception e) {
      log.error("addOrUpdateVehicle",e);
      return  new ResponseEntity("addOrUpdateVehicle Error",HttpStatus.FORBIDDEN.INTERNAL_SERVER_ERROR);
      // throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"addOrUpdateVehicle Error",e);
    }
  }


}

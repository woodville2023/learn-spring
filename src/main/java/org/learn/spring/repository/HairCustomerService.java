package org.learn.spring.repository;

import org.learn.spring.model.HairCustomer;
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
@RequestMapping("hair")
public class HairCustomerService {

  /**
   * @PostMapping(value = "/customer/add",consumes = "application/json",produces = "application/json")
   *   @Transactional
   *   @ResponseBody
   *   public ResponseEntity addOrUpdateCustomer(@RequestBody Customer customer) {
   */

  private static final Logger log = LoggerFactory.getLogger(HairCustomerService.class);
  @Autowired
  private EntityManager entityManager;

  @Transactional
  @ResponseBody
  @PostMapping(value = "/customer/add",consumes = "application/json",produces = "application/json")
  public ResponseEntity addHairCustomer(@RequestBody HairCustomer customer){
    log.info("Inside addHairCustomer");
    entityManager.persist(customer);
    return new ResponseEntity(customer, HttpStatus.OK);
  }



}

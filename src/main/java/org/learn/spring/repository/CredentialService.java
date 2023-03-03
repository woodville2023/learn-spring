package org.learn.spring.repository;

import org.learn.spring.model.Credentials;
import org.learn.spring.model.LoginStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

import java.util.List;

@Service
@RestController
@RequestMapping("credentials")
public class CredentialService/* implements CredentialService*/{

  @Autowired
  private EntityManager entityManager;

  private static final Logger log = LoggerFactory.getLogger(CredentialService.class);


  @PostMapping(value = "/create",consumes = "application/json",produces = "application/json")
  @Transactional
  //@Override
  public ResponseEntity createAccount(@RequestBody Credentials credentials) {
    List<Credentials> existing = null;
    try {
      existing = entityManager
        .createQuery("from Credentials s where s.userName = :userName")
        .setParameter("userName",credentials.getUserName())
      .getResultList();
      log.info("existing credentials found :{}",credentials);


      entityManager.persist(credentials);
      return new ResponseEntity(credentials,HttpStatus.OK) ;

    } catch (Exception e) {

      log.error("Error createAccount",e);
     /* throw new
        ResponseStatusException(HttpStatus.BAD_REQUEST,"createAccount Error",e);*/
      return new ResponseEntity("createAccount Error",HttpStatus.INTERNAL_SERVER_ERROR);


    }

  

  }

 
 @PostMapping(value = "/login",consumes = "application/json",produces = "application/json")
  @Transactional  
 //@Override
  public ResponseEntity login(@RequestBody Credentials credentials) {
    List<Credentials> existing = entityManager
      .createQuery("from Credentials s where s.userName = :userName and s.password = :password")
      .setParameter("userName",credentials.getUserName())
      .setParameter("password",credentials.getPassword())
      .getResultList();
    
    LoginStatus loginStatus = new LoginStatus(){{
      setMessage("Logged In");
      setSuccess(true);
    }};

    if(existing.size() > 0){
     /*  return Response.ok(new LoginStatus(){{
        setSuccess(true);
        setMessage("Logged In");
      }}).build();*/

     return new ResponseEntity(loginStatus,HttpStatus.OK);

    }
    loginStatus.setSuccess(false);
    loginStatus.setMessage("Not Logged In");
     return new ResponseEntity(loginStatus,HttpStatus.BAD_REQUEST);
  }
}

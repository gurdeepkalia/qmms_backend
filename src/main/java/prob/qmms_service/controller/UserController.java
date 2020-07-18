package prob.qmms_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prob.qmms_service.dao.UserDao;
import prob.qmms_service.models.User;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    //@GetMapping("/")
    private ResponseEntity<?> test(){
        try{

            return new ResponseEntity<User>(new User("myId","Yuvraj","abcdefg"), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    private ResponseEntity<?> getUserById(@PathVariable String id){
        try{
            User u = userDao.getUser(id);
            return new ResponseEntity<User>(u, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

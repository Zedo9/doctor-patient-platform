package mygroup.appointments.controllers;

import mygroup.appointments.Services.RegistrationService;
import mygroup.appointments.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins="http://localhost:4200")
    public User registerUser (@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();

         if (tempEmail != null && !"".equals(tempEmail))
         {
             User userobj =service.fetchUserByEmail(tempEmail);
             if (userobj != null)
             {
                   throw new Exception("user with "+tempEmail+" is alreadyexist");
             }
         }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail= user.getEmail();
        String tempPass = user.getPassword();
        User userObj = null ;
        if (tempEmail != null && tempPass !=null)
        {
            userObj = service.fetchUserByEmailAndPassword(tempEmail,tempPass);
        }

        if(userObj == null)
        {
            throw new Exception("Bad credentials");
        }
        return userObj;
    }

}

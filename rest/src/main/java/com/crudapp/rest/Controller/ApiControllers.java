package com.crudapp.rest.Controller;

import com.crudapp.rest.Repo.UserRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiControllers {

    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value= "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(UpdatedUser);
        return "Updated...";
    }

    @DeleteMapping(value= "/delete/{id}")
    public String deleteUser(@RequestBody User user){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted... user with the id: "+ {id};
    }
}

package com.example.Learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private Userrepo userrep;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestBody Userdto userdto) {

        User n = new User();
        n.setUsername(userdto.username);
        n.setName(userdto.name);
        n.setEmail(userdto.email);
        n.setLanguage(userdto.language);
        userrep.save(n);
        return "Saved";
    }

    @PutMapping(path = "/update")
    public @ResponseBody String updateUser (@RequestBody Userdto userdto) {
        User n = new User();
        n.setUsername(userdto.username);
        n.setName(userdto.name);
        n.setEmail(userdto.email);
        n.setLanguage(userdto.language);
        userrep.save(n);
        return "Saved";
    }

//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
////        if (userrep.findByNameOrEmail(name) != null)
////            return userrep.findByNameOrEmail(name);
//        return userrep.findAll();
//
//    }
//    @GetMapping(path="/email")
//    public @ResponseBody List<User> userbyemail(@RequestParam String email) {
//        return userrep.findByEmail(email);
//   }
    @GetMapping(path="/search")
    public @ResponseBody Iterable<User> userbyname(@RequestParam String name, String email) {
        //Collection col = userrep.findByNameOrEmail(name,email);
        int counter = 0;
        for(Object i : userrep.findByNameOrEmail(name,email)){
            counter++;
        }
        if(counter == 0) return userrep.findAll();
        else return userrep.findByNameOrEmail(name,email);

    }


}

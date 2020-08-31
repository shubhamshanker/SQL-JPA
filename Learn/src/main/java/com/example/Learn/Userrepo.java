package com.example.Learn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Userrepo extends CrudRepository<User, String> {

    Iterable<User> findByNameOrEmail(String name, String email);
    //List<User> findByEmail(String email);

}





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

package com.example.Learn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Userrepo extends CrudRepository<User, String> {

    List<User> findByName(String name);
    List<User> findByEmail(String email);

}





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

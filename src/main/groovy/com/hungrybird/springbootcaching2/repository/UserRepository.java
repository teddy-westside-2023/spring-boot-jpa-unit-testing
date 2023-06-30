package com.hungrybird.springbootcaching2.repository;

import com.hungrybird.springbootcaching2.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsername(String username);

    @Query(value = "select id, username, email, password, airport, date_format(created_at,'%d/%m/%Y') as created_at, updated_at from users where username=? and airport=? and updated_at >= date_sub(now(), interval 120 day);",
            nativeQuery = true)
    List<User> findAllByUsernameAndAirport(String username, String airport);
}

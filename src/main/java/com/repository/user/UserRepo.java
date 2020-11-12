package com.repository.user;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("from User u where u.login = ?1")
    User findByLogin(String login);

    @Query("from User u where u.userId=?1")
    User getUserById(int id);
}
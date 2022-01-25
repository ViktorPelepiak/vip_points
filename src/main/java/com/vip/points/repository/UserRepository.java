package com.vip.points.repository;

import com.vip.points.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailOrPhoneNumber(String email, String phoneNumber);

    default User findByLogin(String login) {
        return findByEmailOrPhoneNumber(login, login);
    }
}

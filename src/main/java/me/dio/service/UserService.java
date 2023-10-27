package me.dio.service;

import java.util.List;

import me.dio.domain.model.User;

public interface UserService {
    User findById(Long id);
    List<User> findAllUsers();
    User createUser(User userToCreate);
    User updateUser(User userToUpdate);
    void delete(Long id);
}

package me.dio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User userToCreate) {
        if (userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This User ID already exists!");
        }

        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists!");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public User updateUser(User userToUpdate) {
        if (!userRepository.existsById(userToUpdate.getId())) {
            throw new IllegalArgumentException("This User does not exists!");
        }

        if (!userRepository.existsByAccountNumber(userToUpdate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number does not exists!");
        }

        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("This user does not exist!");
        }
    }
}

package com.lab.user_service.service;

import com.lab.user_service.model.Users;
import com.lab.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<Users> getUserById(Long id){
        return userRepository.findById(id);
    }
    public Users createUser(Users user){
        return userRepository.save(user);
    }
    public Optional<Users> updateUser(Long id, Users updateUser){
        return userRepository.findById(id).map(user -> {
           user.setFullName(updateUser.getFullName());
           user.setUsername(updateUser.getUsername());
           user.setPassword(updateUser.getPassword());
           user.setRole(updateUser.getRole());
           user.setStudentId(updateUser.getStudentId());
           user.setEnrolledClasses(updateUser.getEnrolledClasses());
           user.setTeacher(updateUser.getTeacher());
           user.setAssignedClasses(updateUser.getAssignedClasses());
           return userRepository.save(user);
        });
    }
    public boolean deleteUser(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

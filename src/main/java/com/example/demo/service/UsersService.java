package com.example.demo.service;

import com.example.demo.database.user.Users;
import com.example.demo.database.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    public boolean existsUsers(Users users) {
        return usersRepository.existsById(users.getId());
    }

    public Users loginUsers(Users users) {
        Optional<Users> users1 = usersRepository.findById(users.getId());
        if (users1.isPresent()) {
            if (users.getPassword().equals(users1.get().getPassword())) {
                return users1.get();
            }
        }
        return new Users();
    }

    public Users getUsers(Users users) {
        return usersRepository.findById(users.getId()).orElseGet(Users::new);
    }
}

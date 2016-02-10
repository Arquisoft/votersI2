package org.asw.voters.service.user.impl;

import org.asw.voters.domain.User;
import org.asw.voters.service.user.UserRepository;
import org.asw.voters.service.user.UserService;
import org.asw.voters.service.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public User getUser(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}

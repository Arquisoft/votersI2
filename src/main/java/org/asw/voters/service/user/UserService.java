package org.asw.voters.service.user;

import org.asw.voters.domain.User;

public interface UserService {

    User findByEmailAndPassword(String email, String password);

    User getUser(String email);

    User save(User user);

    void delete(User user);
}

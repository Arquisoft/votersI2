package es.uniovi.asw.service.user;

import es.uniovi.asw.domain.User;

public interface UserService {

    User findByEmailAndPassword(String email, String password);

    User getUser(String email);

    User save(User user);

    void delete(User user);
}

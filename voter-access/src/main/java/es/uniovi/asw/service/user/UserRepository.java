package es.uniovi.asw.service.user;

import es.uniovi.asw.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User save(User user);

    void delete(User user);
}
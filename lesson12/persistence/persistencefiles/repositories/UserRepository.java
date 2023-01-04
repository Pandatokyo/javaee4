package lesson12.persistence.persistencefiles.repositories;

import lesson10.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
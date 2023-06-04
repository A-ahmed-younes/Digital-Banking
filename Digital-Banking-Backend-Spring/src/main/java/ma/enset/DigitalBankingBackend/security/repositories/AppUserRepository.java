package ma.enset.DigitalBankingBackend.security.repositories;

import ma.enset.DigitalBankingBackend.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}

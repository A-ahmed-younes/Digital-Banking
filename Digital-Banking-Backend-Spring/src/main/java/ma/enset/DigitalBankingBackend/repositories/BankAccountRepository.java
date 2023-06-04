package ma.enset.DigitalBankingBackend.repositories;

import ma.enset.DigitalBankingBackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @Query("Select a from BankAccount a where a.customer.id = :customerId")
    List<BankAccount> findAllByCustomerId(@Param("customerId") Long customerId);
}

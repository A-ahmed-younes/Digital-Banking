package ma.enset.DigitalBankingBackend;

import ma.enset.DigitalBankingBackend.dtos.BankAccountDTO;
import ma.enset.DigitalBankingBackend.dtos.CurrentBankAccountDTO;
import ma.enset.DigitalBankingBackend.dtos.CustomerDTO;
import ma.enset.DigitalBankingBackend.dtos.SavingBankAccountDTO;
import ma.enset.DigitalBankingBackend.security.entities.AppUser;
import ma.enset.DigitalBankingBackend.security.service.AccountService;
import ma.enset.DigitalBankingBackend.services.BankAccountService;
import ma.enset.DigitalBankingBackend.exceptions.CustomerNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackendApp {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackendApp.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
           Stream.of("Ahmed","Anas","Achraf").forEach(name->{
               CustomerDTO customer=new CustomerDTO();
               customer.setName(name);
               customer.setEmail(name+"@gmail.com");
               bankAccountService.saveCustomer(customer);
           });
           bankAccountService.listCustomers().forEach(customer->{
               try {
                   bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                   bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

               } catch (CustomerNotFoundException e) {
                   e.printStackTrace();
               }
           });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDTO bankAccount:bankAccounts){
                for (int i = 0; i <10 ; i++) {
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDTO){
                        accountId=((SavingBankAccountDTO) bankAccount).getId();
                    } else{
                        accountId=((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewUser(new AppUser(null, "A-Ahmed-Younes", "12345678", "ADMIN"));
        };
    }


}

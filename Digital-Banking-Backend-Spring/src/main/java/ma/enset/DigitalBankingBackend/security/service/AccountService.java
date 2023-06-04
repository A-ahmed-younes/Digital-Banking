package ma.enset.DigitalBankingBackend.security.service;

import ma.enset.DigitalBankingBackend.security.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);

    AppUser loadUserByUsername(String username);

    List<AppUser> listUsers();
}

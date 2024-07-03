package app.service;

import app.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccount(Long id);
	
	AccountDto deposite(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	Iterable<AccountDto> getAllAccounts();
	
	void deleteAccount(Long id);

}

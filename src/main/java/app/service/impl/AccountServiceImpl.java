package app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.dto.AccountDto;
import app.service.AccountService;
import app.repository.AccountRepository;

import app.entity.mapper.AccountMapper;

import app.entity.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto); 
		
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public AccountDto getAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(
						() -> new RuntimeException("Account does not found!"));
		
		return AccountMapper.mapToAccountDto(account);
	}
	
	@Override
	public AccountDto deposite(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(
						() -> new RuntimeException("Account does not found!"));
		
		
		double total = account.getBalance() + amount;
		
		account.setBalance(total);
		
		Account newAccount = accountRepository.save(account);
		
		AccountDto accountDto = AccountMapper.mapToAccountDto(newAccount);
		
		return accountDto;
	}
	
	@Override
	public AccountDto withdraw(Long id, double amaount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(
						() -> new RuntimeException("Account does not found!"));
		
		double currentBalance = account.getBalance(), total = 0.0;
		if(currentBalance < amaount) {
			throw new RuntimeException("Insufficient amount!");
		}
		
		total = currentBalance - amaount;
		
		account.setBalance(total); 
		
		Account newAccount = accountRepository.save(account);
		
		AccountDto accountDto = AccountMapper.mapToAccountDto(newAccount);
		
		return accountDto;
	}
	
	@Override
	public Iterable<AccountDto> getAllAccounts(){
		
		List<Account> accounts = accountRepository.findAll();
		
		List<AccountDto> accountDtos = new ArrayList<>();
		
		accounts.forEach((account) -> {
			accountDtos.add(
					AccountMapper.mapToAccountDto(account)
				);
		});
		
		return accountDtos;
	}
	
	@Override 
	public void deleteAccount(Long id) {
		
		accountRepository.deleteById(id);
	}
	
}

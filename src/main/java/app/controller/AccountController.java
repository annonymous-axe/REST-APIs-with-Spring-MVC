package app.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.dto.AccountDto;
import app.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//Add Account REST Api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	//Get Account RESP Api
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> findAccount(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccount(id);
		
		return ResponseEntity.ok(accountDto);
	}
	
	//Deposite Account REST Api
	@PutMapping("/{id}/deposite")
	public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String, Double> data){
		
		double amount = data.get("amount");
		
		
		AccountDto accountDto = accountService.deposite(id, amount);
		
		return ResponseEntity.ok(accountDto);
	}
	
	//Withdraw RESP API
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> data){
		
		double amount = data.get("amount");
		
		AccountDto accountDto = accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDto);
		
	}
	
	//Find all accounts REST API
	@GetMapping("/findAll")
	public ResponseEntity<Iterable<AccountDto>> getAllAccounts(){
		
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	//Delete account REST API
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account deleted successfull!");
	}
	
	

}

package app.entity.mapper;

import app.entity.Account;
import app.dto.AccountDto;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		return new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
			);
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		return new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
			);
	}

}

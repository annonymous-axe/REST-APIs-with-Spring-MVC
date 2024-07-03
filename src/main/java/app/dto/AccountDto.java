package app.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class AccountDto {
	
	private Long Id;
	private String accountHolderName;
	private double balance;

}

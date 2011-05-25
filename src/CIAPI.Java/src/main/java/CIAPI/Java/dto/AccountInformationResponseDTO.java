package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * response from an account information query.
 */
public class AccountInformationResponseDTO {

	/**
	 * No argument constructor 
	 */
	public AccountInformationResponseDTO() {
	}
	
	private String LogonUserName;
	
	/**
	 * logon user name.
	 */
	public String getLogonUserName() {
		return LogonUserName;
	}
	
	public void setLogonUserName(String LogonUserName) {
		this.LogonUserName = LogonUserName;
	}
	private int ClientAccountId;
	
	/**
	 * client account id.
	 */
	public int getClientAccountId() {
		return ClientAccountId;
	}
	
	public void setClientAccountId(int ClientAccountId) {
		this.ClientAccountId = ClientAccountId;
	}
	private String ClientAccountCurrency;
	
	/**
	 * Base currency of the client account.
	 */
	public String getClientAccountCurrency() {
		return ClientAccountCurrency;
	}
	
	public void setClientAccountCurrency(String ClientAccountCurrency) {
		this.ClientAccountCurrency = ClientAccountCurrency;
	}
	private CIAPI.Java.dto.ApiTradingAccountDTO[] TradingAccounts;
	
	/**
	 * a list of trading accounts.
	 */
	public CIAPI.Java.dto.ApiTradingAccountDTO[] getTradingAccounts() {
		return TradingAccounts;
	}
	
	public void setTradingAccounts(CIAPI.Java.dto.ApiTradingAccountDTO[] TradingAccounts) {
		this.TradingAccounts = TradingAccounts;
	}
}


package Fx;

//”√ªß¿‡
public class User {
	protected String account;
	protected String password;

	public User() {

	}

	public User(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "’À∫≈£∫" + account + " √‹¬Î£∫" + password;
	}

}

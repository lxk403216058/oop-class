package Fx;

//普通用户类
public class SimpleUser extends User {
	private String name;
	private String sex;
	private String age;

	public SimpleUser(String account, String password) {
		super(account, password);
	}

	public SimpleUser(String account, String password, String name, String sex, String age) {
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getAge() {
		return age;
	}

}

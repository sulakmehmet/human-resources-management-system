package kodlamaio.hrms.entities.concretes;

import lombok.Data;

@Data
public class User {
	private int id;
	private String email;
	private String password;
	
	public User() {}
	
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

}

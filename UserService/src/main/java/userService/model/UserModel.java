package userService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usermodel")
public class UserModel {
	@Id
	private String phoneNo;
	private String userName;
	private String password;
	private String email;

	public UserModel() {

	}

	public UserModel(String userName, String password, String email, String phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return this.phoneNo;
	}
}

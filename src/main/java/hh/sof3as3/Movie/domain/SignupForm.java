package hh.sof3as3.Movie.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignupForm {
    @NotEmpty
    @Size(min=8, max=30, message = "must have between 8 and 30 characters")
    private String username = "";
    
    @NotEmpty
    @Size(min=10, max=30, message = "must have between 10 and 30 characters")
    @Email
    private String email = "";

    @NotEmpty
    @Size(min=10, max=35, message = "must have between 10 and 35 characters")
    private String password = "";

    @NotEmpty
    @Size(min=10, max=35, message = "must have between 10 and 35 characters")
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}

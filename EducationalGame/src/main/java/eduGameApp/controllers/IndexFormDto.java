package eduGameApp.controllers;

public class IndexFormDto {

	private String password = "";
	private String username;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsernameEmpty() {
		this.username = "";
	}
}

package org.sp.vertx.app.domain;

public class User {

	private String username;
	private boolean enable;
	private String password;
	private String id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getPassword() {
		return password;
	}
	public User(String id,String username, boolean enable, String password) {
		super();
		this.username = username;
		this.enable = enable;
		this.password = password;
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

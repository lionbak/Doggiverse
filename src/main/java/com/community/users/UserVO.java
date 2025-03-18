package com.community.users;

public class UserVO {
	private String id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String nickname;
	private String dog_name;
	private String created_at;
	private String address;
	private String address2;
	private boolean loginCheck;
	private String phoneNumber;
	
	public UserVO() {
		
	}
	
	public UserVO(String id, String username, String email, String fullname, String nickname, String dog_name,
			String created_at, String password, boolean loginCheck) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.nickname = nickname;
		this.dog_name = dog_name;
		this.created_at = created_at;
		this.setLoginCheck(loginCheck);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDog_name() {
		return dog_name;
	}
	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fullname=" + fullname + ", nickname=" + nickname + ", dog_name=" + dog_name + ", created_at="
				+ created_at + ", loginCheck=" + loginCheck + "]";
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
}

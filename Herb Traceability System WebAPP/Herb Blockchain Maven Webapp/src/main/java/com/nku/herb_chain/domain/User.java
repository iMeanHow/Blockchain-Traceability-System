package com.nku.herb_chain.domain;

public class User {
    private String Username;
    private String Password;

    // ���캯��
    public User() {
        super();
    }

    public User(Integer userid, String username, String password) {
        super();
        this.Username = username;
        this.Password = password;
    }

    // ��Ա����

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

	@Override
	public String toString() {
		return "{\"username\":\"" + Username + "\",\"password\":\"" + Password + "\"} ";
	}
    
    
    
}

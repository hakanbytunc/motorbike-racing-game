package javaProject;

import java.util.ArrayList;

public class User {
	public static ArrayList<User> UserList = new ArrayList <User>(); 
	public boolean flag=false;
	String userName;
	String password;
	public User(String name, String pw)
	{
		this.userName = name;
		this.password = pw;
	}
}

package beans;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	private List<User>users;
	
	public Users() {
	
		this.users=new ArrayList<User>();
		this.users.add(new User("1","10"));
		this.users.add(new User("2","20"));
		this.users.add(new User("3","30"));
		this.users.add(new User("4","40"));
		this.users.add(new User("5","50"));
	}



	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public User getUser(String username) {
		for(User s :this.users ) {
			if(s.getUsername().equals(username))return s;
		}
		return null;
	}
	

}

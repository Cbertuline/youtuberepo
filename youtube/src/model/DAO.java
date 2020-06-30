package model;

public class DAO {

	public user exist(user u) {

		if (u.getMail().equalsIgnoreCase("admin@test.com")) {
			// ok
			if (u.getPass().equalsIgnoreCase("admin")) {
				// ok
				return new user(u.getMail(), u.getPass(), "admin");
			} else {
				// wrong pass
				user newUser = new user (u.getMail(), u.getPass(), "admin");
				newUser.addError(new Error(100, "wrong pass"));
				return newUser; 
			}
		} else {
			// wrong mail
			user newUser = new user(u.getMail(), u.getPass(), "admin");
			newUser.addError(new Error(200, "Wrong mail"));
			return newUser; 
		}
	}
}

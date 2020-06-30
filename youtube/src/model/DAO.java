package model;
import java.util.*;

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
				newUser.addError(new error(100, "wrong pass"));
				return newUser; 
			}
		} else {
			// wrong mail
			user newUser = new user(u.getMail(), u.getPass(), "admin");
			newUser.addError(new error(200, "Wrong mail"));
			return newUser; 
		}
	}
}

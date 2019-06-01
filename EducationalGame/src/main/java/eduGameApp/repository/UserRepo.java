package eduGameApp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import eduGameApp.domain.User;
import eduGameApp.domain.UserScoreComparator;

public interface UserRepo extends CrudRepository<User, Integer> {
	User findByUsername(String username);
	
	default ArrayList<User> findByHighScoreOrdered() {
		ArrayList<User> users = new ArrayList<User>();
		for (User user : findAll()) {
			if (!user.getUsername().equals("Guest") && user.getHighScore() != null && user.getHighScore() != 0) {
				users.add(user);
			}
		}
		Collections.sort(users, new UserScoreComparator());
		return users;
	}
}

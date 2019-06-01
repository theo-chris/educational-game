package eduGameApp.controllers;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eduGameApp.EducationalGameApplication;
import eduGameApp.domain.User;
import eduGameApp.repository.UserRepo;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {
	
	
@Autowired
UserRepo userRepo;

@RequestMapping("/")
public String index(Model model) {
	ArrayList<String> userScore = new ArrayList<String>();
	ArrayList<User> users = new ArrayList<User>();
	users =  userRepo.findByHighScoreOrdered();
	for (User user : users) {
		
		userScore.add(user.getHighScore().toString());
	}
	
	model.addAttribute("users",users);
	model.addAttribute("scores",userScore);
	
	
	
    return "leaderboard";
}

}

package userService.controller;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userService.model.UserModel;
import userService.repository.UserRepoitory;

@RestController
public class UserController {
	@Autowired
	private UserRepoitory repoitory;

	public boolean isValidPassword(String password) {
		String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public boolean isValidPhoneNumber(String phoneNo) {
		String regex = "[7-9][0-9]{9}";
		return phoneNo.matches(regex);
	}

//	String userName, String password, String email, String phoneNo
	@RequestMapping("/")
	public String baseDisplay() {
		repoitory.save(new UserModel("Khushi", "khushi123", "Khushishetty@gmail.com", "8105199132"));
		return "Hello";
	}

	@RequestMapping("signup/{name}/{password}/{email}/{phoneNo}")
	public String signUp(@PathVariable String name, @PathVariable String email, @PathVariable String password,
			@PathVariable String phoneNo) {

		Optional<UserModel> checkNull = repoitory.findById(phoneNo);
		if (checkNull.isPresent()) {
			UserModel user = repoitory.findById(phoneNo).get();
			return "Account with phone number " + user.getPhoneNo() + " exists";
		} else {
			System.out.println(isValidPassword(phoneNo));
			repoitory.save(new UserModel(name, email, password, phoneNo));
			return "Account created successfully!";
		}
	}

	@RequestMapping("login/{phoneNo}/{password}")
	public String logIn(@PathVariable("phoneNo") String phoneNo, @PathVariable("password") String password) {
		Optional<UserModel> checkNull = repoitory.findById(phoneNo);
		if (checkNull.isPresent()) {
			UserModel user = repoitory.findById(phoneNo).get();
			if (user.getPassword().equals(password))
				return repoitory.findById(phoneNo).get().toString();
			else
				return "Incorrect password";
		} else
			return "User Not Found";
	}

}

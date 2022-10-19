package com.pbburnham3.javaExam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pbburnham3.javaExam.models.LoginUser;
import com.pbburnham3.javaExam.models.User;
import com.pbburnham3.javaExam.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User newUser, BindingResult result) {

		Optional<User> tempUser = userRepository.findByEmail(newUser.getEmail());

		// Reject if email is taken (present in database)
		if (tempUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email is already registered");
		}

		// Reject if password doesn't match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password and Confirm Password fields do not match");
		}

		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}

		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);

	}

	public User login(LoginUser newLogin, BindingResult result) {

		Optional<User> tempUser = userRepository.findByEmail(newLogin.getEmail());

		// Find user in the DB by email
		// Reject if NOT present
		if (!tempUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email not registered");
			return null;
		}

		// User exists, retrieve user from DB
		User user = tempUser.get();

		// Reject if BCrypt password match fails
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect password");
		}

		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}

		// Otherwise, return the user object
		return user;
	}

	public User findById(Long id) {
		Optional<User> tempUser = userRepository.findById(id);
		if (tempUser.isPresent()) {
			return tempUser.get();
		}
		return null;
	}

}

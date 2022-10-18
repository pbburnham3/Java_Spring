package com.pbburnham3.bookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pbburnham3.bookClub.models.Book;
import com.pbburnham3.bookClub.models.LoginUser;
import com.pbburnham3.bookClub.models.User;
import com.pbburnham3.bookClub.services.BookService;
import com.pbburnham3.bookClub.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.register(newUser, result);
		// to do some extra validations and create a new user!

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		}

		// No errors!
		session.setAttribute("userId", user.getId());
		// in other words, log them in.

		return "redirect:/dashboard";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}

		// No errors!
		session.setAttribute("userId", user.getId());
		// in other words, log them in.

		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String welcome(HttpSession session, Model model) {

		// If no userId is found, redirect to logout
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

		// We get the userId from our session (we need to cast the result to a Long as
		// the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);

		return "dashboard.jsp";

	}
	
	@GetMapping("/dashboard/new")
	public String renderNewBook(
			Model model,
			@ModelAttribute("book") Book book) {
		return "new_book.jsp";
	}
	
	@PostMapping("/dashboard/new")
	public String createBook(
			Model model,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "new_book.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBook(id));
		return "view_book.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);

		return "redirect:/";
	}

}

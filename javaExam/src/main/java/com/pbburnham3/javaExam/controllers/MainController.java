package com.pbburnham3.javaExam.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbburnham3.javaExam.models.LoginUser;
import com.pbburnham3.javaExam.models.Show;
import com.pbburnham3.javaExam.models.User;
import com.pbburnham3.javaExam.services.ShowService;
import com.pbburnham3.javaExam.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private ShowService showService;

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

		List<Show> shows = showService.allShows();
		model.addAttribute("shows", shows);

		return "dashboard.jsp";

	}

	@GetMapping("/dashboard/new")
	public String renderNewShow(Model model, @ModelAttribute("show") Show show) {
		return "new_show.jsp";
	}

	@PostMapping("/dashboard/new")
	public String createShow(Model model, @Valid @ModelAttribute("show") Show show, BindingResult result) {
		if (result.hasErrors()) {
			return "new_show.jsp";
		} else {
			showService.createShow(show);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/dashboard/{id}")
	public String viewShow(@PathVariable("id") Long id, Model model) {
		model.addAttribute("show", showService.findShow(id));
		return "view_show.jsp";
	}

	@GetMapping("/dashboard/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Show show = showService.findShow(id);
		model.addAttribute("show", show);
		return "edit_show.jsp";
	}

	@RequestMapping(value = "/dashboard/{id}", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("show") Show show, BindingResult result) {
		if (result.hasErrors()) {
			return "edit_show.jsp";
		} else {
			showService.updateShow(show);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/dashboard/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        showService.deleteShow(id);
        return "redirect:/dashboard";
    }

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);

		return "redirect:/";
	}

}
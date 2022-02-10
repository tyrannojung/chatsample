package kr.ne.abc.web.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView("redirect:/rooms");
		
		return mav;
	}
	
}

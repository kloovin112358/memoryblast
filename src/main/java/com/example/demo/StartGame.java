package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class StartGame {

	@GetMapping("/start")
	public String startGame(Model model) {
		// these variables are simply for ease of creating the template
		// we can loop over the numbers instead of manually creating each
		// input box
        model.addAttribute("first5", new int[]{1, 2, 3, 4, 5});
        model.addAttribute("second5", new int[]{6, 7, 8, 9, 10});
		return "start";
	}

}
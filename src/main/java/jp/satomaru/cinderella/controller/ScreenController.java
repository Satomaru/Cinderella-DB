package jp.satomaru.cinderella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScreenController {

	@GetMapping("/idols")
	public String showIdols(Model model) {
		return "idols";
	}
}

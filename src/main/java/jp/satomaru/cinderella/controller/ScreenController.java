package jp.satomaru.cinderella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScreenController {

	@GetMapping("/master")
	public String showMaster(Model model) {
		return "master";
	}
}

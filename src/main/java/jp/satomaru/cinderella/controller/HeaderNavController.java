package jp.satomaru.cinderella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ヘッダーナビゲータ・コントローラ。
 */
@Controller
public class HeaderNavController {

	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("pageTitle", "Home");
		return "index";
	}

	@GetMapping("/tracks/by-idol")
	public String showTracksByIdol(Model model) {
		model.addAttribute("pageTitle", "Find Tracks by Idol");
		return "tracks/by-idol";
	}

	@GetMapping("/tracks/by-music")
	public String showTracksByMusic(Model model) {
		model.addAttribute("pageTitle", "Find Tracks by Music");
		return "tracks/by-music";
	}
}

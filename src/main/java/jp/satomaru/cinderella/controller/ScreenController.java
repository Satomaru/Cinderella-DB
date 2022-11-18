package jp.satomaru.cinderella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 画面表示コントローラ。
 */
@Controller
public class ScreenController {

	@GetMapping("/tracks")
	public String showTracks(Model model) {
		return "tracks";
	}
}

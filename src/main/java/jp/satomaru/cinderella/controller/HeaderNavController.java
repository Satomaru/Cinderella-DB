package jp.satomaru.cinderella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ヘッダーナビゲータ・コントローラ。
 */
@Controller
public class HeaderNavController {

	/**
	 * ホーム。
	 * 
	 * <p>
	 * モデル・アトリビュートは以下のとおり。
	 * 
	 * <ul>
	 * <li>pageTitle: "Home"</li>
	 * </ul>
	 * 
	 * @param model モデル
	 * @return "index"
	 */
	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("pageTitle", "Home");
		return "index";
	}

	/**
	 * 音源検索(アイドル)。
	 * 
	 * <p>
	 * モデル・アトリビュートは以下のとおり。
	 * 
	 * <ul>
	 * <li>pageTitle:   "Find Tracks by Idol"</li>
	 * <li>targetsName: "Idols"</li>
	 * </ul>
	 * 
	 * @param model モデル
	 * @return "tracks/by-idol"
	 */
	@GetMapping("/tracks/by-idol")
	public String showTracksByIdol(Model model) {
		model.addAttribute("pageTitle", "Find Tracks by Idol");
		model.addAttribute("targetsName", "Idols");
		return "tracks/by-idol";
	}

	/**
	 * 音源検索(楽曲)。
	 * 
	 * <p>
	 * モデル・アトリビュートは以下のとおり。
	 * 
	 * <ul>
	 * <li>pageTitle:   "Find Tracks by Idol"</li>
	 * <li>targetsName: "Musics"</li>
	 * </ul>
	 * 
	 * @param model モデル
	 * @return "tracks/by-music"
	 */
	@GetMapping("/tracks/by-music")
	public String showTracksByMusic(Model model) {
		model.addAttribute("pageTitle", "Find Tracks by Music");
		model.addAttribute("targetsName", "Musics");
		return "tracks/by-music";
	}

	/**
	 * 音源検索(円盤)。
	 * 
	 * <p>
	 * モデル・アトリビュートは以下のとおり。
	 * 
	 * <ul>
	 * <li>pageTitle:   "Find Tracks by Disc"</li>
	 * <li>targetsName: "Discs"</li>
	 * </ul>
	 * 
	 * @param model モデル
	 * @return "tracks/by-disc"
	 */
	@GetMapping("/tracks/by-disc")
	public String showTracksByDisc(Model model) {
		model.addAttribute("pageTitle", "Find Tracks by Disc");
		model.addAttribute("targetsName", "Discs");
		return "tracks/by-disc";
	}
}

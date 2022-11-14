package jp.satomaru.cinderella.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.repository.IdolsRepository;
import jp.satomaru.cinderella.service.IdolsService;

/**
 * アイドル・コントローラ。
 */
@RestController
@RequestMapping(path = "/api/idols")
public class IdolsController {

	@Autowired private IdolsRepository idolsRepository;
	@Autowired private IdolsService idolsService;

	/**
	 * アイドル一覧を取得する。
	 * 
	 * @param type タイプ (Cu/Pa/Co、省略可)
	 * @param kana かな (部分一致、省略可)
	 * @return アイドル一覧
	 */
	@GetMapping(path = "/")
	public @ResponseBody Iterable<Idol> getAllIdols(
			@RequestParam @Nullable String type,
			@RequestParam @Nullable String kana) {

		return idolsService.findByTypeAndKana(type, kana);
	}

	/**
	 * アイドルを取得する。
	 * 
	 * @param id ID
	 * @return アイドル
	 */
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Idol> getIdol(
			@PathVariable Integer id) {

		return idolsRepository.findById(id);
	}
}

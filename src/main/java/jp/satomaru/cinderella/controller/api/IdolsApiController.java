package jp.satomaru.cinderella.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.form.TrackListRow;
import jp.satomaru.cinderella.service.IdolsService;
import jp.satomaru.cinderella.service.TracksService;

/**
 * アイドルAPIコントローラ。
 */
@RestController
@RequestMapping(path = "/api/idols")
public class IdolsApiController {

	@Autowired private IdolsService idolsService;

	@Autowired private TracksService tracksService;

	/**
	 * アイドル一覧を取得する。
	 * 
	 * @param target 検索対象 (name/kana)
	 * @param match 検索文字列 (省略可)
	 * @param type タイプ (Cu/Pa/Co、省略可)
	 * @return アイドル一覧
	 */
	@GetMapping(path = "/")
	public @ResponseBody Iterable<Idol> getIdols(
			@RequestParam String target,
			@RequestParam @Nullable String match,
			@RequestParam @Nullable String type) {

		switch (target) {
			case "name": return idolsService.findByName(match, type);
			case "kana": return idolsService.findByKana(match, type);
			default: throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * アイドルを取得する。
	 * 
	 * @param id アイドルID
	 * @return アイドル
	 */
	@GetMapping(path = "/{id}/")
	public @ResponseBody Optional<Idol> getIdol(
			@PathVariable Integer id) {

		return idolsService.get(id);
	}

	/**
	 * アイドルのトラック一覧を取得する。
	 * 
	 * @param id アイドルID
	 * @return トラック一覧
	 */
	@GetMapping(path = "/{id}/tracks/")
	public @ResponseBody Iterable<TrackListRow> getTracksOfIdol(
			@PathVariable Integer id) {

		return tracksService.findByIdol(id).stream().map(TrackListRow::new).toList();
	}
}

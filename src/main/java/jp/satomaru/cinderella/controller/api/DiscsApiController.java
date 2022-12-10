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

import jp.satomaru.cinderella.entity.Disc;
import jp.satomaru.cinderella.form.TrackListRow;
import jp.satomaru.cinderella.service.DiscsService;
import jp.satomaru.cinderella.service.TracksService;

/**
 * 円盤APIコントローラ。
 */
@RestController
@RequestMapping(path = "/api/discs")
public class DiscsApiController {

	@Autowired private DiscsService discsService;

	@Autowired private TracksService tracksService;

	/**
	 * 円盤一覧を取得する。
	 * 
	 * @param target 検索対象 (name/kana/label/code)
	 * @param match 検索文字列 (省略可)
	 * @return 円盤一覧
	 */
	@GetMapping(path = "/")
	public @ResponseBody Iterable<Disc> getDiscs(
			@RequestParam String target,
			@RequestParam @Nullable String match) {

		switch (target) {
			case "name":  return discsService.findByName(match);
			case "kana":  return discsService.findByKana(match);
			case "label": return discsService.findByLabel(match);
			case "code":  return discsService.findByCode(match);
			default: throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 円盤を取得する。
	 * 
	 * @param id 円盤ID
	 * @return 円盤
	 */
	@GetMapping(path = "/{id}/")
	public @ResponseBody Optional<Disc> getDisc(
			@PathVariable Integer id) {

		return discsService.get(id);
	}

	/**
	 * 円盤のトラック一覧を取得する。
	 * 
	 * @param id 円盤ID
	 * @return トラック一覧
	 */
	@GetMapping(path = "/{id}/tracks/")
	public @ResponseBody Iterable<TrackListRow> getTracksOfDisc(
			@PathVariable Integer id) {

		return tracksService.findByDisc(id).stream().map(TrackListRow::new).toList();
	}
}

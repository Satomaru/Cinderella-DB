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

import jp.satomaru.cinderella.entity.Music;
import jp.satomaru.cinderella.form.TrackListRow;
import jp.satomaru.cinderella.service.MusicsService;
import jp.satomaru.cinderella.service.TracksService;

/**
 * 楽曲APIコントローラ。
 */
@RestController
@RequestMapping(path = "/api/musics")
public class MusicsApiController {

	@Autowired private MusicsService musicsService;

	@Autowired private TracksService tracksService;

	/**
	 * 楽曲一覧を取得する。
	 * 
	 * @param target 検索対象 (name/kana/lyrics/compose)
	 * @param match 検索文字列 (省略可)
	 * @param original カバーを除く場合は "1"
	 * @return 楽曲一覧
	 */
	@GetMapping(path = "/")
	public @ResponseBody Iterable<Music> getMusics(
			@RequestParam String target,
			@RequestParam @Nullable String match,
			@RequestParam @Nullable String original) {

		boolean withoutCover = "1".equals(original);

		switch (target) {
			case "name":    return musicsService.findByName(match, withoutCover);
			case "kana":    return musicsService.findByKana(match, withoutCover);
			case "lyrics":  return musicsService.findByLyrics(match, withoutCover);
			case "compose": return musicsService.findByCompose(match, withoutCover);
			default: throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 楽曲を取得する。
	 * 
	 * @param id 楽曲ID
	 * @return 楽曲
	 */
	@GetMapping(path = "/{id}/")
	public @ResponseBody Optional<Music> getMusic(
			@PathVariable Integer id) {

		return musicsService.get(id);
	}

	/**
	 * 楽曲のトラック一覧を取得する。
	 * 
	 * @param id 楽曲ID
	 * @return トラック一覧
	 */
	@GetMapping(path = "/{id}/tracks/")
	public @ResponseBody Iterable<TrackListRow> getTracksOfMusic(
			@PathVariable Integer id) {

		return tracksService.findByMusic(id).stream().map(TrackListRow::new).toList();
	}
}

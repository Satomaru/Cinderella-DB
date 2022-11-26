package jp.satomaru.cinderella.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.satomaru.cinderella.entity.Music;
import jp.satomaru.cinderella.repository.MusicsRepository;

/**
 * 楽曲サービス。
 */
@Service
public class MusicsService {

	@Autowired private MusicsRepository musicsRepository;

	/**
	 * 楽曲を取得する。
	 * 
	 * @param id ID
	 * @return 楽曲
	 */
	public Optional<Music> get(Integer id) {
		return musicsRepository.findById(id);
	}

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致、ブランク可)
	 * @param withoutCover カバーを含めない場合はtrue
	 * @return 楽曲一覧
	 */
	public Iterable<Music> findByName(String name, boolean withoutCover) {
		if (StringUtils.hasText(name)) {
			if (withoutCover) {
				return musicsRepository.findByNameContainingAndCoverOrderByKana(name, false);
			} else {
				return musicsRepository.findByNameContainingOrderByKana(name);
			}
		}

		return findByCover(withoutCover);
	}

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致、ブランク可)
	 * @param withoutCover カバーを含めない場合はtrue
	 * @return 楽曲一覧
	 */
	public Iterable<Music> findByKana(String kana, boolean withoutCover) {
		if (StringUtils.hasText(kana)) {
			if (withoutCover) {
				return musicsRepository.findByKanaContainingAndCoverOrderByKana(kana, false);
			} else {
				return musicsRepository.findByKanaContainingOrderByKana(kana);
			}
		}

		return findByCover(withoutCover);
	}

	/**
	 * 作詞で検索する。
	 * 
	 * @param lyrics 作詞 (部分一致、ブランク可)
	 * @param withoutCover カバーを含めない場合はtrue
	 * @return 楽曲一覧
	 */
	public Iterable<Music> findByLyrics(String lyrics, boolean withoutCover) {
		if (StringUtils.hasText(lyrics)) {
			if (withoutCover) {
				return musicsRepository.findByLyricsContainingAndCoverOrderByKana(lyrics, false);
			} else {
				return musicsRepository.findByLyricsContainingOrderByKana(lyrics);
			}
		}

		return findByCover(withoutCover);
	}

	/**
	 * 作曲で検索する。
	 * 
	 * @param compose 作曲 (部分一致、ブランク可)
	 * @param withoutCover カバーを含めない場合はtrue
	 * @return 楽曲一覧
	 */
	public Iterable<Music> findByCompose(String compose, boolean withoutCover) {
		if (StringUtils.hasText(compose)) {
			if (withoutCover) {
				return musicsRepository.findByComposeContainingAndCoverOrderByKana(compose, false);
			} else {
				return musicsRepository.findByComposeContainingOrderByKana(compose);
			}
		}

		return findByCover(withoutCover);
	}

	/**
	 * カバーで検索する。
	 * 
	 * @param withoutCover カバーを含めない場合はtrue
	 * @return 楽曲一覧
	 */
	public Iterable<Music> findByCover(boolean withoutCover) {
		if (withoutCover) {
			return musicsRepository.findByCoverOrderByKana(false);
		} else {
			return musicsRepository.findAll(Sort.by("kana"));
		}
	}
}

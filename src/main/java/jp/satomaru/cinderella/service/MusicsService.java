package jp.satomaru.cinderella.service;

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

		if (withoutCover) {
			return musicsRepository.findByCoverOrderByKana(false);
		} else {
			return musicsRepository.findAll(Sort.by("kana"));
		}
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

		if (withoutCover) {
			return musicsRepository.findByCoverOrderByKana(false);
		} else {
			return musicsRepository.findAll(Sort.by("kana"));
		}
	}
}

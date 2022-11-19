package jp.satomaru.cinderella.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.repository.IdolsRepository;

/**
 * アイドル・サービス。
 */
@Service
public class IdolsService {

	@Autowired private IdolsRepository idolsRepository;

	/**
	 * 名前とかなで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @param kana 名前 (部分一致、ブランク可)
	 * @return アイドル一覧
	 */
	public Iterable<Idol> findByTypeAndName(String type, String name) {
		boolean hasType = StringUtils.hasText(type);
		boolean hasName = StringUtils.hasText(name);

		if (hasType && !hasName) {
			return idolsRepository.findByTypeOrderByKana(type);
		}

		if (!hasType && hasName) {
			return idolsRepository.findByNameContainingOrderByKana(name);
		}

		if (hasType && hasName) {
			return idolsRepository.findByTypeAndNameContainingOrderByKana(type, name);
		}

		return idolsRepository.findAll(Sort.by("kana"));
	}

	/**
	 * タイプとかなで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @param kana かな (部分一致、ブランク可)
	 * @return アイドル一覧
	 */
	public Iterable<Idol> findByTypeAndKana(String type, String kana) {
		boolean hasType = StringUtils.hasText(type);
		boolean hasKana = StringUtils.hasText(kana);

		if (hasType && !hasKana) {
			return idolsRepository.findByTypeOrderByKana(type);
		}

		if (!hasType && hasKana) {
			return idolsRepository.findByKanaContainingOrderByKana(kana);
		}

		if (hasType && hasKana) {
			return idolsRepository.findByTypeAndKanaContainingOrderByKana(type, kana);
		}

		return idolsRepository.findAll(Sort.by("kana"));
	}
}

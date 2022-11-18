package jp.satomaru.cinderella.service;

import org.springframework.beans.factory.annotation.Autowired;
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
			return idolsRepository.findByType(type);
		}

		if (!hasType && hasName) {
			return idolsRepository.findByNameContaining(name);
		}

		if (hasType && hasName) {
			return idolsRepository.findByTypeAndNameContaining(type, name);
		}

		return idolsRepository.findAll();
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
			return idolsRepository.findByType(type);
		}

		if (!hasType && hasKana) {
			return idolsRepository.findByKanaContaining(kana);
		}

		if (hasType && hasKana) {
			return idolsRepository.findByTypeAndKanaContaining(type, kana);
		}

		return idolsRepository.findAll();
	}
}

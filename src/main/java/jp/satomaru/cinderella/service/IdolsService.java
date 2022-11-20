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
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致、ブランク可)
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @return アイドル一覧
	 */
	public Iterable<Idol> findByName(String name, String type) {
		boolean hasName = StringUtils.hasText(name);
		boolean hasType = StringUtils.hasText(type);

		if (hasName && !hasType) {
			return idolsRepository.findByNameContainingOrderByKana(name);
		}

		if (!hasName && hasType) {
			return idolsRepository.findByTypeOrderByKana(type);
		}

		if (hasName && hasType) {
			return idolsRepository.findByNameContainingAndTypeOrderByKana(name, type);
		}

		return idolsRepository.findAll(Sort.by("kana"));
	}

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致、ブランク可)
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @return アイドル一覧
	 */
	public Iterable<Idol> findByKana(String kana, String type) {
		boolean hasKana = StringUtils.hasText(kana);
		boolean hasType = StringUtils.hasText(type);

		if (hasKana && !hasType) {
			return idolsRepository.findByKanaContainingOrderByKana(kana);
		}

		if (!hasKana && hasType) {
			return idolsRepository.findByTypeOrderByKana(type);
		}

		if (hasKana && hasType) {
			return idolsRepository.findByKanaContainingAndTypeOrderByKana(kana, type);
		}

		return idolsRepository.findAll(Sort.by("kana"));
	}
}

package jp.satomaru.cinderella.service;

import java.util.Optional;
import java.util.TreeSet;

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
	 * アイドルを取得する。
	 * 
	 * @param id アイドルID
	 * @return アイドル
	 */
	public Optional<Idol> get(Integer id) {
		return idolsRepository.findById(id);
	}

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致、ブランク可)
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @return アイドル一覧
	 */
	public TreeSet<Idol> findByName(String name, String type) {
		boolean hasName = StringUtils.hasText(name);
		boolean hasType = StringUtils.hasText(type);

		if (hasName && !hasType) {
			return idolsRepository.findByNameContaining(name);
		}

		if (!hasName && hasType) {
			return idolsRepository.findByType(type);
		}

		if (hasName && hasType) {
			return idolsRepository.findByNameContainingAndType(name, type);
		}

		return new TreeSet<>(idolsRepository.findAll());
	}

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致、ブランク可)
	 * @param type タイプ (Cu/Pa/Co、ブランク可)
	 * @return アイドル一覧
	 */
	public TreeSet<Idol> findByKana(String kana, String type) {
		boolean hasKana = StringUtils.hasText(kana);
		boolean hasType = StringUtils.hasText(type);

		if (hasKana && !hasType) {
			return idolsRepository.findByKanaContaining(kana);
		}

		if (!hasKana && hasType) {
			return idolsRepository.findByType(type);
		}

		if (hasKana && hasType) {
			return idolsRepository.findByKanaContainingAndType(kana, type);
		}

		return new TreeSet<>(idolsRepository.findAll());
	}
}

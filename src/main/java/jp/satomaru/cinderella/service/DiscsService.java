package jp.satomaru.cinderella.service;

import java.util.Optional;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.satomaru.cinderella.entity.Disc;
import jp.satomaru.cinderella.repository.DiscsRepository;

/**
 * 円盤サービス。
 */
@Service
public class DiscsService {

	@Autowired private DiscsRepository discsRepository;

	/**
	 * 円盤を取得する。
	 * 
	 * @param id 円盤ID
	 * @return 円盤
	 */
	public Optional<Disc> get(Integer id) {
		return discsRepository.findById(id);
	}

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致、ブランク可)
	 * @return 円盤一覧
	 */
	public TreeSet<Disc> findByName(String name) {
		if (StringUtils.hasText(name)) {
			return discsRepository.findByNameContaining(name);
		}

		return new TreeSet<>(discsRepository.findAll());
	}

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致、ブランク可)
	 * @return 円盤一覧
	 */
	public TreeSet<Disc> findByKana(String kana) {
		if (StringUtils.hasText(kana)) {
			return discsRepository.findByKanaContaining(kana);
		}

		return new TreeSet<>(discsRepository.findAll());
	}

	/**
	 * レーベルで検索する。
	 * 
	 * @param label レーベル (部分一致、ブランク可)
	 * @return 円盤一覧
	 */
	public TreeSet<Disc> findByLabel(String label) {
		if (StringUtils.hasText(label)) {
			return discsRepository.findByLabelContaining(label);
		}

		return new TreeSet<>(discsRepository.findAll());
	}

	/**
	 * コードで検索する。
	 * 
	 * @param code コード (部分一致、ブランク可)
	 * @return 円盤一覧
	 */
	public TreeSet<Disc> findByCode(String code) {
		if (StringUtils.hasText(code)) {
			return discsRepository.findByCodeContaining(code);
		}

		return new TreeSet<>(discsRepository.findAll());
	}
}

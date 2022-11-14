package jp.satomaru.cinderella.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.repository.IdolsRepository;

/**
 * アイドル・サービス。
 */
@Service
public class IdolsService {

	@Autowired private IdolsRepository idolsRepository;

	/**
	 * タイプとかなで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co、省略可)
	 * @param kana かな (部分一致、省略可)
	 * @return アイドル一覧
	 */
	public Iterable<Idol> findByTypeAndKana(String type, String kana) {
		if (type != null && kana == null) {
			return idolsRepository.findByType(type);
		}

		if (type == null && kana != null) {
			return idolsRepository.findByKanaContaining(kana);
		}

		if (type != null && kana != null) {
			return idolsRepository.findByTypeAndKanaContaining(type, kana);
		}

		return idolsRepository.findAll();
	}
}

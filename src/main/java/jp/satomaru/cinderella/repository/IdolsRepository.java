package jp.satomaru.cinderella.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.satomaru.cinderella.entity.Idol;

/**
 * アイドル・リポジトリ。
 */
public interface IdolsRepository extends JpaRepository<Idol, Integer> {

	/**
	 * タイプで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByType(String type);

	/**
	 * かな (部分一致) で検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByKanaContaining(String kana);

	/**
	 * タイプとかな (部分一致) で検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByTypeAndKanaContaining(String type, String kana);
}

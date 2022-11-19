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
	Iterable<Idol> findByTypeOrderByKana(String type);

	/**
	 * 名前で検索する。
	 * 
	 * @param kana 名前 (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByNameContainingOrderByKana(String kana);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByKanaContainingOrderByKana(String kana);

	/**
	 * タイプと名前で検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @param kana 名前 (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByTypeAndNameContainingOrderByKana(String type, String kana);

	/**
	 * タイプとかなで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByTypeAndKanaContainingOrderByKana(String type, String kana);
}

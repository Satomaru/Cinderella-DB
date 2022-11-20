package jp.satomaru.cinderella.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.satomaru.cinderella.entity.Idol;

/**
 * アイドル・リポジトリ。
 */
public interface IdolsRepository extends JpaRepository<Idol, Integer> {

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByNameContainingOrderByKana(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByKanaContainingOrderByKana(String kana);

	/**
	 * タイプで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByTypeOrderByKana(String type);

	/**
	 * 名前とタイプで検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByNameContainingAndTypeOrderByKana(String name, String type);

	/**
	 * かなとタイプで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	Iterable<Idol> findByKanaContainingAndTypeOrderByKana(String kana, String type);
}

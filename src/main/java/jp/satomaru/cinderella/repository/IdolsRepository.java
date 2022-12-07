package jp.satomaru.cinderella.repository;

import java.util.List;

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
	List<Idol> findByNameContainingOrderByKana(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	List<Idol> findByKanaContainingOrderByKana(String kana);

	/**
	 * タイプで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	List<Idol> findByTypeOrderByKana(String type);

	/**
	 * 名前とタイプで検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	List<Idol> findByNameContainingAndTypeOrderByKana(String name, String type);

	/**
	 * かなとタイプで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	List<Idol> findByKanaContainingAndTypeOrderByKana(String kana, String type);
}

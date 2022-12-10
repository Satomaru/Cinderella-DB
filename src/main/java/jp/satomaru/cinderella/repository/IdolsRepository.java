package jp.satomaru.cinderella.repository;

import java.util.TreeSet;

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
	TreeSet<Idol> findByNameContaining(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return アイドル一覧
	 */
	TreeSet<Idol> findByKanaContaining(String kana);

	/**
	 * タイプで検索する。
	 * 
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	TreeSet<Idol> findByType(String type);

	/**
	 * 名前とタイプで検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	TreeSet<Idol> findByNameContainingAndType(String name, String type);

	/**
	 * かなとタイプで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @param type タイプ (Cu/Pa/Co)
	 * @return アイドル一覧
	 */
	TreeSet<Idol> findByKanaContainingAndType(String kana, String type);
}

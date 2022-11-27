package jp.satomaru.cinderella.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.satomaru.cinderella.entity.Disc;

/**
 * 円盤リポジトリ。
 */
public interface DiscsRepository extends JpaRepository<Disc, Integer> {

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @return 円盤一覧
	 */
	Iterable<Disc> findByNameContainingOrderByName(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return 円盤一覧
	 */
	Iterable<Disc> findByKanaContainingOrderByName(String kana);

	/**
	 * レーベルで検索する。
	 * 
	 * @param label レーベル (部分一致)
	 * @return 円盤一覧
	 */
	Iterable<Disc> findByLabelContainingOrderByName(String label);

	/**
	 * コードで検索する。
	 * 
	 * @param code コード (部分一致)
	 * @return 円盤一覧
	 */
	Iterable<Disc> findByCodeContainingOrderByName(String code);
}

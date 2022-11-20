package jp.satomaru.cinderella.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.satomaru.cinderella.entity.Music;

/**
 * 楽曲リポジトリ。
 */
public interface MusicsRepository extends JpaRepository<Music, Integer> {

	/**
	 * 名前で検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @return 楽曲一覧
	 */
	Iterable<Music> findByNameContainingOrderByKana(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return 楽曲一覧
	 */
	Iterable<Music> findByKanaContainingOrderByKana(String kana);

	/**
	 * カバーで検索する。
	 * 
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	Iterable<Music> findByCoverOrderByKana(Boolean cover);

	/**
	 * 名前とカバーで検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	Iterable<Music> findByNameContainingAndCoverOrderByKana(String name, Boolean cover);

	/**
	 * かなとカバーで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	Iterable<Music> findByKanaContainingAndCoverOrderByKana(String kana, Boolean cover);
}

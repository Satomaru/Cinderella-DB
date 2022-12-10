package jp.satomaru.cinderella.repository;

import java.util.TreeSet;

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
	TreeSet<Music> findByNameContaining(String name);

	/**
	 * かなで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByKanaContaining(String kana);

	/**
	 * 作詞で検索する。
	 * 
	 * @param lyrics 作詞 (部分一致)
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByLyricsContaining(String lyrics);

	/**
	 * 作曲で検索する。
	 * 
	 * @param compose 作曲 (部分一致)
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByComposeContaining(String compose);

	/**
	 * カバーで検索する。
	 * 
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByCover(Boolean cover);

	/**
	 * 名前とカバーで検索する。
	 * 
	 * @param name 名前 (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByNameContainingAndCover(String name, Boolean cover);

	/**
	 * かなとカバーで検索する。
	 * 
	 * @param kana かな (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByKanaContainingAndCover(String kana, Boolean cover);

	/**
	 * 作詞とカバーで検索する。
	 * 
	 * @param lyrics 作詞 (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByLyricsContainingAndCover(String lyrics, Boolean cover);

	/**
	 * 作曲とカバーで検索する。
	 * 
	 * @param compose 作曲 (部分一致)
	 * @param cover カバー
	 * @return 楽曲一覧
	 */
	TreeSet<Music> findByComposeContainingAndCover(String compose, Boolean cover);
}

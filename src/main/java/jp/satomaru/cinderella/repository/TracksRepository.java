package jp.satomaru.cinderella.repository;

import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.satomaru.cinderella.entity.Disc;
import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.entity.Music;
import jp.satomaru.cinderella.entity.Track;

/**
 * トラック・リポジトリ。
 */
public interface TracksRepository extends JpaRepository<Track, Integer> {

	/**
	 * 円盤で検索する。
	 * 
	 * @param disc 円盤
	 * @return トラック一覧
	 */
	@Query("SELECT t "
			+ "FROM tracks t "
			+ "INNER JOIN FETCH t.disc "
			+ "INNER JOIN FETCH t.music "
			+ "LEFT JOIN FETCH t.trackIdols ti "
			+ "LEFT JOIN FETCH ti.idol "
			+ "WHERE t.disc=:disc ")
	TreeSet<Track> findBy(@Param("disc") Disc disc);

	/**
	 * 楽曲で検索する。
	 * 
	 * @param music 楽曲
	 * @return トラック一覧
	 */
	@Query("SELECT t "
			+ "FROM tracks t "
			+ "INNER JOIN FETCH t.disc "
			+ "INNER JOIN FETCH t.music "
			+ "LEFT JOIN FETCH t.trackIdols ti "
			+ "LEFT JOIN FETCH ti.idol "
			+ "WHERE t.music=:music ")
	TreeSet<Track> findBy(@Param("music") Music music);

	/**
	 * アイドルで検索する。
	 * 
	 * @param idol アイドル
	 * @return トラック一覧
	 */
	@Query("SELECT t "
			+ "FROM tracks t "
			+ "INNER JOIN FETCH t.disc "
			+ "INNER JOIN FETCH t.music "
			+ "LEFT JOIN FETCH t.trackIdols ti "
			+ "LEFT JOIN FETCH ti.idol "
			+ "WHERE EXISTS (SELECT 1 FROM track_idols e WHERE e.ids.track_id=t.id AND e.idol=:idol) ")
	TreeSet<Track> findBy(@Param("idol") Idol idol);
}

package jp.satomaru.cinderella.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.satomaru.cinderella.entity.Disc;
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
	List<Track> findBy(@Param("disc") Disc disc);

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
	List<Track> findBy(@Param("music") Music music);
}
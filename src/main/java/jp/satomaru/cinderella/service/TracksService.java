package jp.satomaru.cinderella.service;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.satomaru.cinderella.entity.Disc;
import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.entity.Music;
import jp.satomaru.cinderella.entity.Track;
import jp.satomaru.cinderella.repository.TracksRepository;

/**
 * トラック・サービス。
 */
@Service
public class TracksService {

	@Autowired private TracksRepository tracksRepository;

	/**
	 * 円盤で検索する。
	 * 
	 * @param discId 円盤ID
	 * @return トラック一覧
	 */
	public Iterable<Track> findByDisc(Integer discId) {
		TreeSet<Track> sorted = new TreeSet<>(Track.SORT_DISC_TRACK);
		sorted.addAll(tracksRepository.findBy(new Disc(discId)));
		return sorted;
	}

	/**
	 * 楽曲で検索する。
	 * 
	 * @param musicId 楽曲ID
	 * @return トラック一覧
	 */
	public Iterable<Track> findByMusic(Integer musicId) {
		TreeSet<Track> sorted = new TreeSet<>(Track.SORT_DISC_TRACK);
		sorted.addAll(tracksRepository.findBy(new Music(musicId)));
		return sorted;
	}

	/**
	 * アイドルで検索する。
	 * 
	 * @param idolId アイドルID
	 * @return トラック一覧
	 */
	public Iterable<Track> findByIdol(Integer idolId) {
		TreeSet<Track> sorted = new TreeSet<>(Track.SORT_DISC_TRACK);
		sorted.addAll(tracksRepository.findBy(new Idol(idolId)));
		return sorted;
	}
}

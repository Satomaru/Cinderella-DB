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
	public TreeSet<Track> findByDisc(Integer discId) {
		return tracksRepository.findBy(new Disc(discId));
	}

	/**
	 * 楽曲で検索する。
	 * 
	 * @param musicId 楽曲ID
	 * @return トラック一覧
	 */
	public TreeSet<Track> findByMusic(Integer musicId) {
		return tracksRepository.findBy(new Music(musicId));
	}

	/**
	 * アイドルで検索する。
	 * 
	 * @param idolId アイドルID
	 * @return トラック一覧
	 */
	public TreeSet<Track> findByIdol(Integer idolId) {
		return tracksRepository.findBy(new Idol(idolId));
	}
}

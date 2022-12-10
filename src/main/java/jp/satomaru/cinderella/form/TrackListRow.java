package jp.satomaru.cinderella.form;

import java.util.List;

import jp.satomaru.cinderella.entity.Idol;
import jp.satomaru.cinderella.entity.Track;
import jp.satomaru.cinderella.entity.TrackIdol;
import lombok.Getter;

/**
 * トラック一覧行。
 */
@Getter
public final class TrackListRow {

	/** ID。 */
	private Integer id;

	/** 名前。 */
	private String name;

	/** 円盤名。 */
	private String disc;

	/** トラックNo。 */
	private Integer track;

	/** アイドル。 */
	private List<String> idols;

	/**
	 * トラック一覧行を作成する。
	 * 
	 * @param track トラック
	 */
	public TrackListRow(Track track) {
		this.id = track.getId();
		this.name = track.getName();
		this.disc = track.getDisc().getName();
		this.track = track.getTrack();

		this.idols = track.getTrackIdols().stream()
				.map(TrackIdol::getIdol)
				.sorted()
				.map(Idol::getName)
				.toList();
	}
}

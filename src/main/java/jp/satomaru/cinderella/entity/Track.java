package jp.satomaru.cinderella.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * トラック。
 */
@Entity(name = "tracks")
@NoArgsConstructor
@Getter
@Setter
public class Track implements Comparable<Track> {

	/**
	 * トラックを作成する。
	 * 
	 * @param id ID
	 */
	public Track(Integer id) {
		this.id = id;
	}

	/** ID。 */
	@Id
	private Integer id;

	/** 名前。 */
	private String name;

	/** 円盤。 */
	@ManyToOne
	private Disc disc;

	/** トラックNo。 */
	private Integer track;

	/** 楽曲。 */
	@ManyToOne
	private Music music;

	/** トラック・アイドル。 */
	@OneToMany(mappedBy = "ids.track_id")
	private Set<TrackIdol> trackIdols;

	@Override
	public int compareTo(Track other) {
		int byDisc = disc.compareTo(other.getDisc());

		if (byDisc != 0) {
			return byDisc;
		}

		return track.compareTo(other.track);
	}
}

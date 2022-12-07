package jp.satomaru.cinderella.entity;

import java.util.Comparator;
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
public class Track {

	/** 円盤とトラックNoで並べ替える。 */
	public static final Comparator<Track> SORT_DISC_TRACK = (Track left, Track right) -> {
		int byDisc = left.getDisc().getId().compareTo(right.getDisc().getId());

		if (byDisc != 0) {
			return byDisc;
		}

		return left.getTrack().compareTo(right.getTrack());
	};

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
}

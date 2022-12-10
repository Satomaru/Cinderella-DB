package jp.satomaru.cinderella.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * トラック・アイドル。
 */
@Entity(name = "track_idols")
@Getter
@Setter
public class TrackIdol implements Comparable<TrackIdol> {

	/** トラックID・アイドルID。 */
	@Embeddable
	@EqualsAndHashCode
	@Getter
	@Setter
	public static class Ids implements Serializable, Comparable<Ids> {

		/** トラックID。 */
		private Integer track_id;

		/** アイドルID。 */
		private Integer idol_id;

		@Override
		public int compareTo(Ids other) {
			int byTrack = track_id.compareTo(other.track_id);

			if (byTrack != 0) {
				return byTrack;
			}

			return idol_id.compareTo(other.idol_id);
		}
	}

	/** トラックID・アイドルID。 */
	@EmbeddedId
	private Ids ids;

	/** アイドル。 */
	@MapsId("idol_id")
	@ManyToOne
	private Idol idol;

	@Override
	public int compareTo(TrackIdol other) {
		int byTrack = ids.track_id.compareTo(other.ids.track_id);

		if (byTrack != 0) {
			return byTrack;
		}

		return idol.compareTo(other.idol);
	}
}

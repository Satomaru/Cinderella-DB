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
public class TrackIdol {

	/** トラックID・アイドルID。 */
	@Embeddable
	@EqualsAndHashCode
	@Getter
	@Setter
	public static class Ids implements Serializable {

		/** トラックID。 */
		private Integer track_id;

		/** アイドルID。 */
		private Integer idol_id;
	}

	/** トラックID・アイドルID。 */
	@EmbeddedId
	private Ids ids;

	/** アイドル。 */
	@MapsId("idol_id")
	@ManyToOne
	private Idol idol;
}

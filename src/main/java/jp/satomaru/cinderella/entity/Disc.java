package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 円盤。
 */
@Entity(name = "discs")
@NoArgsConstructor
@Getter
@Setter
public class Disc implements Comparable<Disc> {

	/**
	 * 円盤を作成する。
	 * 
	 * @param id ID
	 */
	public Disc(Integer id) {
		this.id = id;
	}

	/** ID。 */
	@Id
	private Integer id;

	/** 名前。 */
	private String name;

	/** かな。 */
	private String kana;

	/** レーベル。 */
	private String label;

	/** コード。 */
	private String code;

	/** サイト。 */
	private String site;

	@Override
	public int compareTo(Disc other) {
		return name.compareTo(other.name);
	}
}

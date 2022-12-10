package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * アイドル。
 */
@Entity(name = "idols")
@NoArgsConstructor
@Getter
@Setter
public class Idol implements Comparable<Idol> {

	/**
	 * アイドルを作成する。
	 * 
	 * @param id ID
	 */
	public Idol(Integer id) {
		this.id = id;
	}

	/** ID。 */
	@Id
	private Integer id;

	/** 名前。 */
	private String name;

	/** かな。 */
	private String kana;

	/** タイプ (Cu/Pa/Co)。 */
	private String type;

	/** 誕生日 (MMdd)。 */
	private String birth;

	/** キャラクターボイス。 */
	private String cv;

	@Override
	public int compareTo(Idol other) {
		return kana.compareTo(other.kana);
	}
}

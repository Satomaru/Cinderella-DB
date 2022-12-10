package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 楽曲。
 */
@Entity(name = "musics")
@NoArgsConstructor
@Getter
@Setter
public class Music implements Comparable<Music> {

	/**
	 * 楽曲を作成する。
	 * 
	 * @param id ID
	 */
	public Music(Integer id) {
		this.id = id;
	}

	/** ID。 */
	@Id
	private Integer id;

	/** 名前。 */
	private String name;

	/** かな。 */
	private String kana;

	/** 作詞。 */
	private String lyrics;

	/** 作曲。 */
	private String compose;

	/** カバー。 */
	private Boolean cover;

	/** インスト。 */
	private Boolean inst;

	@Override
	public int compareTo(Music other) {
		return kana.compareTo(other.kana);
	}
}

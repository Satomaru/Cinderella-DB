package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

/**
 * 楽曲。
 */
@Entity(name = "musics")
@Getter
public class Music {

	/** ID。 */
	@Id private Integer id;

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
}

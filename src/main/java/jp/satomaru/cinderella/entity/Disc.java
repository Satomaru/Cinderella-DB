package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

/**
 * 円盤。
 */
@Entity(name = "discs")
@Getter
public class Disc {

	/** ID。 */
	@Id private Integer id;

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
}

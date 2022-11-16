package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

/**
 * アイドル。
 */
@Entity(name = "idols")
@Getter
public class Idol {

	/** ID。 */
	@Id private Integer id;

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
}

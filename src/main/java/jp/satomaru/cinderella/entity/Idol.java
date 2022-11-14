package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * アイドル。
 */
@Entity(name = "idols")
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

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
}

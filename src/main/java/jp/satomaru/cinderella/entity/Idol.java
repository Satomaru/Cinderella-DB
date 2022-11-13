package jp.satomaru.cinderella.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "idols")
public class Idol {

	@Id private Integer id;
	private String name;
	private String kana;

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
}

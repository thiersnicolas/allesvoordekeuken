package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FoodArtikel extends Artikel {
	private static final long serialVersionUID = 1L;
	private int houdbaarheid;
	
	protected FoodArtikel() {}
	
	public FoodArtikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs, int garantie) {
		super(naam, aankoopprijs, verkoopprijs);
		setGarantie(garantie);
	}

	public int getGarantie() {
		return houdbaarheid;
	}

	public void setGarantie(int houdbaarheid) {
		if (isHoudbaarheidValid(houdbaarheid)) {
			this.houdbaarheid = houdbaarheid;
		}
	}
	
	public static boolean isHoudbaarheidValid(int garantie) {
		return garantie>=0;
	}
}

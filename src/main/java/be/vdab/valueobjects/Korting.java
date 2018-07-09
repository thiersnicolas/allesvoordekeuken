package be.vdab.valueobjects;

import javax.persistence.Embeddable;

@Embeddable
public class Korting {
	private int vanafAantal;
	private double kortingspercentage;
	
	protected Korting() {}
	
	public Korting(int vanafAantal, double kortingspercentage) {
		this.vanafAantal = vanafAantal;
		this.kortingspercentage = kortingspercentage;
	}

	public int getVanafAantal() {
		return vanafAantal;
	}

	public void setVanafAantal(int vanafAantal) {
		this.vanafAantal = vanafAantal;
	}

	public double getKortingspercentage() {
		return kortingspercentage;
	}

	public void setKortingspercentage(double kortingspercentage) {
		this.kortingspercentage = kortingspercentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kortingspercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vanafAantal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Korting)) {
			return false;
		}
		Korting other = (Korting) obj;
		if (Double.doubleToLongBits(kortingspercentage) != Double.doubleToLongBits(other.kortingspercentage)) {
			return false;
		}
		if (vanafAantal != other.vanafAantal) {
			return false;
		}
		return true;
	}
}

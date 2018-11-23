package br.com.webapp.model;

public class Modelo {
	public String codigosap;
	public String modelo;
	public String segmento;
	
	public String getCodigosap() {
		return codigosap;
	}
	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigosap == null) ? 0 : codigosap.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((segmento == null) ? 0 : segmento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (codigosap == null) {
			if (other.codigosap != null)
				return false;
		} else if (!codigosap.equals(other.codigosap))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (segmento == null) {
			if (other.segmento != null)
				return false;
		} else if (!segmento.equals(other.segmento))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Modelo [codigosap=" + codigosap + ", modelo=" + modelo + ", segmento=" + segmento + "]";
	}	
}

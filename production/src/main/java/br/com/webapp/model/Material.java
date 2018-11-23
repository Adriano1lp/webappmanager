package br.com.webapp.model;

public class Material {
	public String serie;
	public String casid;
	public String mac;
	public String modelo;
	public String codigosap;
	public String notafiscal;
	public String pedido;
	public String data;
	public String segmento;
	public String login;
	

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getCasid() {
		return casid;
	}

	public void setCasid(String casid) {
		this.casid = casid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigosap() {
		return codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(String notafiscal) {
		this.notafiscal = notafiscal;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casid == null) ? 0 : casid.hashCode());
		result = prime * result + ((codigosap == null) ? 0 : codigosap.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((notafiscal == null) ? 0 : notafiscal.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((segmento == null) ? 0 : segmento.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		Material other = (Material) obj;
		if (casid == null) {
			if (other.casid != null)
				return false;
		} else if (!casid.equals(other.casid))
			return false;
		if (codigosap == null) {
			if (other.codigosap != null)
				return false;
		} else if (!codigosap.equals(other.codigosap))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (notafiscal == null) {
			if (other.notafiscal != null)
				return false;
		} else if (!notafiscal.equals(other.notafiscal))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (segmento == null) {
			if (other.segmento != null)
				return false;
		} else if (!segmento.equals(other.segmento))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Material [serie=" + serie + ", casid=" + casid + ", mac=" + mac + ", modelo=" + modelo + ", codigosap="
				+ codigosap + ", notafiscal=" + notafiscal + ", pedido=" + pedido + ", data=" + data + ", segmento="
				+ segmento + ", login=" + login + "]";
	}

	

}

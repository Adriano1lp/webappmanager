package br.com.webapp.model;

public class Saida {
    public String serie;
    public String casid;
    public String cartao;
    public String modelo;
    public String data;
    public String notafiscalsaida;
    public String pedidosaida;
    public String login;
	public String codigosap;
	
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
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNotafiscalsaida() {
		return notafiscalsaida;
	}
	public void setNotafiscalsaida(String notafiscalsaida) {
		this.notafiscalsaida = notafiscalsaida;
	}
	public String getPedidosaida() {
		return pedidosaida;
	}
	public void setPedidosaida(String pedidosaida) {
		this.pedidosaida = pedidosaida;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getCodigosap(){
		return codigosap;
	}
	public void setCodigosap(String codigo){
		this.codigosap = codigo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartao == null) ? 0 : cartao.hashCode());
		result = prime * result + ((casid == null) ? 0 : casid.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((notafiscalsaida == null) ? 0 : notafiscalsaida.hashCode());
		result = prime * result + ((pedidosaida == null) ? 0 : pedidosaida.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ((codigosap == null) ? 0 : codigosap.hashCode());
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
		Saida other = (Saida) obj;
		if (cartao == null) {
			if (other.cartao != null)
				return false;
		} else if (!cartao.equals(other.cartao))
			return false;
		if (casid == null) {
			if (other.casid != null)
				return false;
		} else if (!casid.equals(other.casid))
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
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (notafiscalsaida == null) {
			if (other.notafiscalsaida != null)
				return false;
		} else if (!notafiscalsaida.equals(other.notafiscalsaida))
			return false;
		if (pedidosaida == null) {
			if (other.pedidosaida != null)
				return false;
		} else if (!pedidosaida.equals(other.pedidosaida))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (codigosap == null){
			if (other.codigosap != null)
				return false;
		} else if (!codigosap.equals(other.codigosap))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Saida [serie=" + serie + ", casid=" + casid + ", cartao=" + cartao + ", modelo=" + modelo + ", data="
				+ data + ", notafiscalsaida=" + notafiscalsaida + ", pedidosaida=" + pedidosaida + ", login=" + login
				+ ", codigosap=" + codigosap + "]";
	}
}
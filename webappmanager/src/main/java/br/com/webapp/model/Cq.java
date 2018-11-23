package br.com.webapp.model;

public class Cq {
	public String serie;
	public String data;
	public String observacaocq;
	public String statuscq;
	public String login;
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getObservacaocq() {
		return observacaocq;
	}
	public void setObservacaocq(String observacaocq) {
		this.observacaocq = observacaocq;
	}
	public String getStatuscq() {
		return statuscq;
	}
	public void setStatuscq(String statuscq) {
		this.statuscq = statuscq;
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
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((observacaocq == null) ? 0 : observacaocq.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ((statuscq == null) ? 0 : statuscq.hashCode());
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
		Cq other = (Cq) obj;
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
		if (observacaocq == null) {
			if (other.observacaocq != null)
				return false;
		} else if (!observacaocq.equals(other.observacaocq))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (statuscq == null) {
			if (other.statuscq != null)
				return false;
		} else if (!statuscq.equals(other.statuscq))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cq [serie=" + serie + ", data=" + data + ", observacaocq=" + observacaocq + ", statuscq=" + statuscq
				+ ", login=" + login + "]";
	}
	
	
	
	
	
}

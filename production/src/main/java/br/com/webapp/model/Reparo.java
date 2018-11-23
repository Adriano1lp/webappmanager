package br.com.webapp.model;

public class Reparo {
	
	public String serie;
	public String defeito;
	public String data;
	public String reparo;
	public String triagem;
	public String scr;
	public String login;
	public String observacao;
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getReparo() {
		return reparo;
	}
	public void setReparo(String reparo) {
		this.reparo = reparo;
	}
	public String getTriagem() {
		return triagem;
	}
	public void setTriagem(String triagem) {
		this.triagem = triagem;
	}
	public String getScr() {
		return scr;
	}
	public void setScr(String scr) {
		this.scr = scr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((defeito == null) ? 0 : defeito.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((reparo == null) ? 0 : reparo.hashCode());
		result = prime * result + ((scr == null) ? 0 : scr.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + ((triagem == null) ? 0 : triagem.hashCode());
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
		Reparo other = (Reparo) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (defeito == null) {
			if (other.defeito != null)
				return false;
		} else if (!defeito.equals(other.defeito))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (reparo == null) {
			if (other.reparo != null)
				return false;
		} else if (!reparo.equals(other.reparo))
			return false;
		if (scr == null) {
			if (other.scr != null)
				return false;
		} else if (!scr.equals(other.scr))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (triagem == null) {
			if (other.triagem != null)
				return false;
		} else if (!triagem.equals(other.triagem))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reparo [serie=" + serie + ", defeito=" + defeito + ", data=" + data + ", reparo=" + reparo
				+ ", triagem=" + triagem + ", scr=" + scr + ", login=" + login + ", observacao=" + observacao + "]";
	}
	
	

}

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

    public String getSerie(){
        return serie;
    }
    public void setSerie(String serie){
        this.serie = serie;
    }
    public String getCasid(){
        return casid;
    }
    public void setCasid(String casid){
        this.casid = casid;
    }
    public String getCartao(){
        return cartao;
    }
    public void setCartao(String cartao){
        this.cartao = cartao;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getDate(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getNotafiscalsaida(){
        return notafiscalsaida;
    }
    public void setNotafiscalsaida(String nf){
        this.notafiscalsaida = nf;
    }
    public String getPedidosaida(){
        return pedidosaida;
    }
    public void setPedidosaida(String pedidosaida){
        this.pedidosaida = pedidosaida;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((serie == null) ? 0 : serie.hashCode());
        result = prime * result + ((casid == null) ? 0 : casid.hashCode());
        result = prime * result + ((cartao == null) ? 0 : cartao.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((notafiscalsaida == null) ? 0 : notafiscalsaida.hashCode());
        result = prime * result + ((pedidosaida == null) ? 0 : pedidosaida.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }
  
}
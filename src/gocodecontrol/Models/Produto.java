package gocodecontrol.Models;

public class Produto {
    private int cd_produto;
    private String nm_produto;
    private double valor;
    private boolean ativo;
    private int qtde;

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getCd_produto() {
        return cd_produto;
    }

    public void setCd_produto(int cd_produto) {
        this.cd_produto = cd_produto;
    }

    public String getNm_produto() {
        return nm_produto;
    }

    public void setNm_produto(String nm_produto) {
        this.nm_produto = nm_produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "Código=" + cd_produto + ", Nome=" + nm_produto + ", Valor=" + valor + ", Ativo=" + ativo + '}';
    }
}
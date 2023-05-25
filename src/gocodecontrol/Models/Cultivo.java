/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.Models;

/**
 *
 * @author Andre Nascimento
 */
public class Cultivo {
    private int cd_cultivo;
    private String dt_inicio;
    private String dt_colheita;
    private String andamento;
    private int cd_usuario;
    private int cd_produto;
    private int cd_talhao;

    public int getCd_cultivo() {
        return cd_cultivo;
    }

    public void setCd_cultivo(int cd_cultivo) {
        this.cd_cultivo = cd_cultivo;
    }

    public String getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public String getDt_colheita() {
        return dt_colheita;
    }

    public void setDt_colheita(String dt_colheita) {
        this.dt_colheita = dt_colheita;
    }

    public String getAndamento() {
        return andamento;
    }

    public void setAndamento(String andamento) {
        this.andamento = andamento;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public int getCd_produto() {
        return cd_produto;
    }

    public void setCd_produto(int cd_produto) {
        this.cd_produto = cd_produto;
    }

    public int getCd_talhao() {
        return cd_talhao;
    }

    public void setCd_talhao(int cd_talhao) {
        this.cd_talhao = cd_talhao;
    }
    
    
}

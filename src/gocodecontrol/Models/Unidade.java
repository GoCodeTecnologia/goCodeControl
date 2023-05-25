/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gocodecontrol.Models;

/**
 *
 * @author Andre Nascimento
 */
public class Unidade {
    private int cd_unidade;
    private int cd_endereco;
    private String ativo;
    private String nm_unidade;
    private int cd_usuario;

    public int getCd_unidade() {
        return cd_unidade;
    }

    public void setCd_unidade(int cd_unidade) {
        this.cd_unidade = cd_unidade;
    }

    public int getCd_endereco() {
        return cd_endereco;
    }

    public void setCd_endereco(int cd_endereco) {
        this.cd_endereco = cd_endereco;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getNm_unidade() {
        return nm_unidade;
    }

    public void setNm_unidade(String nm_unidade) {
        this.nm_unidade = nm_unidade;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
    
}

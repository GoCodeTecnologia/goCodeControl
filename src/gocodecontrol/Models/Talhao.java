package gocodecontrol.Models;

public class Talhao {
    private int cd_talhao;
    private String nm_talhao;
    private boolean status;

    public int getCd_talhao() {
        return cd_talhao;
    }

    public void setCd_talhao(int cd_talhao) {
        this.cd_talhao = cd_talhao;
    }

    public String getNm_talhao() {
        return nm_talhao;
    }

    public void setNm_talhao(String nm_talhao) {
        this.nm_talhao = nm_talhao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
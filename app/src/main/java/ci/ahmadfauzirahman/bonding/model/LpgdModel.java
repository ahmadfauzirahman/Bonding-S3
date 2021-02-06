package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LpgdModel {
    @SerializedName("id_kusioner")
    @Expose
    private Integer idKusioner;
    @SerializedName("quotes")
    @Expose
    private String quotes;
    @SerializedName("jenis")
    @Expose
    private String jenis;

    public Integer getIdKusioner() {
        return idKusioner;
    }

    public void setIdKusioner(Integer idKusioner) {
        this.idKusioner = idKusioner;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}

package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtikelModel {
    @SerializedName("id_artikel")
    @Expose
    private String idArtikel;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("isi")
    @Expose
    private String isi;
    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("crt")
    @Expose
    private String crt;

    public String getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(String idArtikel) {
        this.idArtikel = idArtikel;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }
}

package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiaryIbuModel {
    @SerializedName("id_diary_ibu")
    @Expose
    private Integer idDiaryIbu;
    @SerializedName("id_ibu")
    @Expose
    private String idIbu;
    @SerializedName("noted")
    @Expose
    private String noted;
    @SerializedName("perasaan")
    @Expose
    private String perasaan;
    @SerializedName("tgl_created")
    @Expose
    private String tglCreated;

    public Integer getIdDiaryIbu() {
        return idDiaryIbu;
    }

    public void setIdDiaryIbu(Integer idDiaryIbu) {
        this.idDiaryIbu = idDiaryIbu;
    }

    public String getIdIbu() {
        return idIbu;
    }

    public void setIdIbu(String idIbu) {
        this.idIbu = idIbu;
    }

    public String getNoted() {
        return noted;
    }

    public void setNoted(String noted) {
        this.noted = noted;
    }

    public String getPerasaan() {
        return perasaan;
    }

    public void setPerasaan(String perasaan) {
        this.perasaan = perasaan;
    }

    public String getTglCreated() {
        return tglCreated;
    }

    public void setTglCreated(String tglCreated) {
        this.tglCreated = tglCreated;
    }
}

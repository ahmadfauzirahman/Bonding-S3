package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InformasiConsentModel {
    @SerializedName("id_conf")
    @Expose
    private String idConf;
    @SerializedName("id_ibu")
    @Expose
    private String idIbu;
    @SerializedName("id_ayah")
    @Expose
    private String idAyah;
    @SerializedName("is_ibu")
    @Expose
    private String isIbu;
    @SerializedName("is_ayah")
    @Expose
    private String isAyah;

    public String getIdConf() {
        return idConf;
    }

    public void setIdConf(String idConf) {
        this.idConf = idConf;
    }

    public String getIdIbu() {
        return idIbu;
    }

    public void setIdIbu(String idIbu) {
        this.idIbu = idIbu;
    }

    public String getIdAyah() {
        return idAyah;
    }

    public void setIdAyah(String idAyah) {
        this.idAyah = idAyah;
    }

    public String getIsIbu() {
        return isIbu;
    }

    public void setIsIbu(String isIbu) {
        this.isIbu = isIbu;
    }

    public String getIsAyah() {
        return isAyah;
    }

    public void setIsAyah(String isAyah) {
        this.isAyah = isAyah;
    }
}

package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ci.ahmadfauzirahman.bonding.api.response.CheckJawabanEPDSResponse;

public class CheckJawabanEPDSModel {

    @SerializedName("jumlahJawabanHasilEPDS")
    @Expose
    private Integer jumlahJawabanHasilEPDS;
    @SerializedName("isJawabEPDS")
    @Expose
    private Boolean isJawabEPDS;

    public Integer getJumlahJawabanHasilEPDS() {
        return jumlahJawabanHasilEPDS;
    }

    public void setJumlahJawabanHasilEPDS(Integer jumlahJawabanHasilEPDS) {
        this.jumlahJawabanHasilEPDS = jumlahJawabanHasilEPDS;
    }

    public Boolean getIsJawabEPDS() {
        return isJawabEPDS;
    }

    public void setIsJawabEPDS(Boolean isJawabEPDS) {
        this.isJawabEPDS = isJawabEPDS;
    }
}

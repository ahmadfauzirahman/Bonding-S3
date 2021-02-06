package ci.ahmadfauzirahman.bonding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserJawabKusionerModel {
    @SerializedName("uk_id")
    @Expose
    private Integer ukId;
    @SerializedName("u_id")
    @Expose
    private String uId;
    @SerializedName("k_id")
    @Expose
    private Integer kId;
    @SerializedName("uk_ceklis")
    @Expose
    private String ukCeklis;
    @SerializedName("uk_keterangan")
    @Expose
    private String ukKeterangan;
    @SerializedName("uk_updated_at")
    @Expose
    private String ukUpdatedAt;
    @SerializedName("uk_created_at")
    @Expose
    private String ukCreatedAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jenis")
    @Expose
    private String jenis;

    public Integer getUkId() {
        return ukId;
    }

    public void setUkId(Integer ukId) {
        this.ukId = ukId;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getUkCeklis() {
        return ukCeklis;
    }

    public void setUkCeklis(String ukCeklis) {
        this.ukCeklis = ukCeklis;
    }

    public String getUkKeterangan() {
        return ukKeterangan;
    }

    public void setUkKeterangan(String ukKeterangan) {
        this.ukKeterangan = ukKeterangan;
    }

    public String getUkUpdatedAt() {
        return ukUpdatedAt;
    }

    public void setUkUpdatedAt(String ukUpdatedAt) {
        this.ukUpdatedAt = ukUpdatedAt;
    }

    public String getUkCreatedAt() {
        return ukCreatedAt;
    }

    public void setUkCreatedAt(String ukCreatedAt) {
        this.ukCreatedAt = ukCreatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

}

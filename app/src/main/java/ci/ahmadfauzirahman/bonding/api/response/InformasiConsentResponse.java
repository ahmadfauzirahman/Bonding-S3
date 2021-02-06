package ci.ahmadfauzirahman.bonding.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ci.ahmadfauzirahman.bonding.model.InformasiConsentModel;

public class InformasiConsentResponse {
    @SerializedName("con")
    @Expose
    private Boolean con;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("results")
    @Expose
    private InformasiConsentModel results;

    public Boolean getCon() {
        return con;
    }

    public void setCon(Boolean con) {
        this.con = con;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InformasiConsentModel getResults() {
        return results;
    }

    public void setResults(InformasiConsentModel results) {
        this.results = results;
    }
}

package ci.ahmadfauzirahman.bonding.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ci.ahmadfauzirahman.bonding.model.CheckJawabanEPDSModel;

public class CheckJawabanEPDSResponse {
    @SerializedName("con")
    @Expose
    private Boolean con;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("results")
    @Expose
    private CheckJawabanEPDSModel results;

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

    public CheckJawabanEPDSModel getResults() {
        return results;
    }

    public void setResults(CheckJawabanEPDSModel results) {
        this.results = results;
    }
}

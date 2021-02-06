package ci.ahmadfauzirahman.bonding.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ci.ahmadfauzirahman.bonding.model.LpgdModel;

public class LpgdResponse {
    @SerializedName("con")
    @Expose
    private Boolean con;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("results")
    @Expose
    private List<LpgdModel> results = null;

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

    public List<LpgdModel> getResults() {
        return results;
    }

    public void setResults(List<LpgdModel> results) {
        this.results = results;
    }
}

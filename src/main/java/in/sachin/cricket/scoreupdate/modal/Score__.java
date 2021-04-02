// 
// Decompiled by Procyon v0.5.36
// 

package in.sachin.cricket.scoreupdate.modal;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dismissal-by", "dismissal", "SR", "6s", "4s", "B", "R", "dismissal-info", "batsman", "pid",
		"detail" })
public class Score__ {
	@JsonProperty("dismissal")
	private String dismissal;
	@JsonProperty("SR")
	private String sR;
	@JsonProperty("6s")
	private String _6s;
	@JsonProperty("4s")
	private String _4s;
	@JsonProperty("B")
	private String b;
	@JsonProperty("R")
	private String r;
	@JsonProperty("dismissal-info")
	private String dismissalInfo;
	@JsonProperty("batsman")
	private String batsman;
	@JsonProperty("pid")
	private Integer pid;
	@JsonProperty("detail")
	private String detail;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Score__() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	

	@JsonProperty("dismissal")
	public String getDismissal() {
		return this.dismissal;
	}

	@JsonProperty("dismissal")
	public void setDismissal(final String dismissal) {
		this.dismissal = dismissal;
	}

	@JsonProperty("SR")
	public String getSR() {
		return this.sR;
	}

	@JsonProperty("SR")
	public void setSR(final String sR) {
		this.sR = sR;
	}

	@JsonProperty("6s")
	public String get6s() {
		return this._6s;
	}

	@JsonProperty("6s")
	public void set6s(final String _6s) {
		this._6s = _6s;
	}

	@JsonProperty("4s")
	public String get4s() {
		return this._4s;
	}

	@JsonProperty("4s")
	public void set4s(final String _4s) {
		this._4s = _4s;
	}

	@JsonProperty("B")
	public String getB() {
		return this.b;
	}

	@JsonProperty("B")
	public void setB(final String b) {
		this.b = b;
	}

	@JsonProperty("R")
	public String getR() {
		return this.r;
	}

	@JsonProperty("R")
	public void setR(final String r) {
		this.r = r;
	}

	@JsonProperty("dismissal-info")
	public String getDismissalInfo() {
		return this.dismissalInfo;
	}

	@JsonProperty("dismissal-info")
	public void setDismissalInfo(final String dismissalInfo) {
		this.dismissalInfo = dismissalInfo;
	}

	@JsonProperty("batsman")
	public String getBatsman() {
		return this.batsman;
	}

	@JsonProperty("batsman")
	public void setBatsman(final String batsman) {
		this.batsman = batsman;
	}

	@JsonProperty("pid")
	public Integer getPid() {
		return this.pid;
	}

	@JsonProperty("pid")
	public void setPid(final Integer pid) {
		this.pid = pid;
	}

	@JsonProperty("detail")
	public String getDetail() {
		return this.detail;
	}

	@JsonProperty("detail")
	public void setDetail(final String detail) {
		this.detail = detail;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(final String name, final Object value) {
		this.additionalProperties.put(name, value);
	}
}

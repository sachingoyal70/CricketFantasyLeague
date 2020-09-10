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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "6s", "4s", "0s", "Econ", "W", "R", "M", "O", "bowler", "pid" })
public class Score_ {
	@JsonProperty("6s")
	private Integer _6s;
	@JsonProperty("4s")
	private Integer _4s;
	@JsonProperty("0s")
	private Integer _0s;
	@JsonProperty("Econ")
	private String econ;
	@JsonProperty("W")
	private String w;
	@JsonProperty("R")
	private String r;
	@JsonProperty("M")
	private String m;
	@JsonProperty("O")
	private String o;
	@JsonProperty("bowler")
	private String bowler;
	@JsonProperty("pid")
	private Integer pid;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Score_() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("6s")
	public Integer get6s() {
		return this._6s;
	}

	@JsonProperty("6s")
	public void set6s(final Integer _6s) {
		this._6s = _6s;
	}

	@JsonProperty("4s")
	public Integer get4s() {
		return this._4s;
	}

	@JsonProperty("4s")
	public void set4s(final Integer _4s) {
		this._4s = _4s;
	}

	@JsonProperty("0s")
	public Integer get0s() {
		return this._0s;
	}

	@JsonProperty("0s")
	public void set0s(final Integer _0s) {
		this._0s = _0s;
	}

	@JsonProperty("Econ")
	public String getEcon() {
		return this.econ;
	}

	@JsonProperty("Econ")
	public void setEcon(final String econ) {
		this.econ = econ;
	}

	@JsonProperty("W")
	public String getW() {
		return this.w;
	}

	@JsonProperty("W")
	public void setW(final String w) {
		this.w = w;
	}

	@JsonProperty("R")
	public String getR() {
		return this.r;
	}

	@JsonProperty("R")
	public void setR(final String r) {
		this.r = r;
	}

	@JsonProperty("M")
	public String getM() {
		return this.m;
	}

	@JsonProperty("M")
	public void setM(final String m) {
		this.m = m;
	}

	@JsonProperty("O")
	public String getO() {
		return this.o;
	}

	@JsonProperty("O")
	public void setO(final String o) {
		this.o = o;
	}

	@JsonProperty("bowler")
	public String getBowler() {
		return this.bowler;
	}

	@JsonProperty("bowler")
	public void setBowler(final String bowler) {
		this.bowler = bowler;
	}

	@JsonProperty("pid")
	public Integer getPid() {
		return this.pid;
	}

	@JsonProperty("pid")
	public void setPid(final Integer pid) {
		this.pid = pid;
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

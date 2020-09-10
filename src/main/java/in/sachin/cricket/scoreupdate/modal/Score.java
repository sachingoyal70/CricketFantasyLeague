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
@JsonPropertyOrder({ "name", "runout", "stumped", "bowled", "lbw", "catch", "pid" })
public class Score {
	@JsonProperty("name")
	private String name;
	@JsonProperty("runout")
	private Integer runout;
	@JsonProperty("stumped")
	private Integer stumped;
	@JsonProperty("bowled")
	private Integer bowled;
	@JsonProperty("lbw")
	private Integer lbw;
	@JsonProperty("catch")
	private Integer _catch;
	@JsonProperty("pid")
	private String pid;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Score() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	@JsonProperty("name")
	public void setName(final String name) {
		this.name = name;
	}

	@JsonProperty("runout")
	public Integer getRunout() {
		return this.runout;
	}

	@JsonProperty("runout")
	public void setRunout(final Integer runout) {
		this.runout = runout;
	}

	@JsonProperty("stumped")
	public Integer getStumped() {
		return this.stumped;
	}

	@JsonProperty("stumped")
	public void setStumped(final Integer stumped) {
		this.stumped = stumped;
	}

	@JsonProperty("bowled")
	public Integer getBowled() {
		return this.bowled;
	}

	@JsonProperty("bowled")
	public void setBowled(final Integer bowled) {
		this.bowled = bowled;
	}

	@JsonProperty("lbw")
	public Integer getLbw() {
		return this.lbw;
	}

	@JsonProperty("lbw")
	public void setLbw(final Integer lbw) {
		this.lbw = lbw;
	}

	@JsonProperty("catch")
	public Integer getCatch() {
		return this._catch;
	}

	@JsonProperty("catch")
	public void setCatch(final Integer _catch) {
		this._catch = _catch;
	}

	@JsonProperty("pid")
	public String getPid() {
		return this.pid;
	}

	@JsonProperty("pid")
	public void setPid(final String pid) {
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

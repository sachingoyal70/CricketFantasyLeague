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
@JsonPropertyOrder({ "stat", "score", "description", "matchStarted", "team-1", "team-2", "v", "ttl", "provider",
		"creditsLeft" })
public class WCFLMatches {
	@JsonProperty("stat")
	private String stat;
	@JsonProperty("score")
	private String score;
	@JsonProperty("description")
	private String description;
	@JsonProperty("matchStarted")
	private Boolean matchStarted;
	@JsonProperty("team-1")
	private String team1;
	@JsonProperty("team-2")
	private String team2;
	@JsonProperty("v")
	private String v;
	@JsonProperty("ttl")
	private Integer ttl;
	@JsonProperty("provider")
	private Provider provider;
	@JsonProperty("creditsLeft")
	private Integer creditsLeft;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public WCFLMatches() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("stat")
	public String getStat() {
		return this.stat;
	}

	@JsonProperty("stat")
	public void setStat(final String stat) {
		this.stat = stat;
	}

	@JsonProperty("score")
	public String getScore() {
		return this.score;
	}

	@JsonProperty("score")
	public void setScore(final String score) {
		this.score = score;
	}

	@JsonProperty("description")
	public String getDescription() {
		return this.description;
	}

	@JsonProperty("description")
	public void setDescription(final String description) {
		this.description = description;
	}

	@JsonProperty("matchStarted")
	public Boolean getMatchStarted() {
		return this.matchStarted;
	}

	@JsonProperty("matchStarted")
	public void setMatchStarted(final Boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

	@JsonProperty("team-1")
	public String getTeam1() {
		return this.team1;
	}

	@JsonProperty("team-1")
	public void setTeam1(final String team1) {
		this.team1 = team1;
	}

	@JsonProperty("team-2")
	public String getTeam2() {
		return this.team2;
	}

	@JsonProperty("team-2")
	public void setTeam2(final String team2) {
		this.team2 = team2;
	}

	@JsonProperty("v")
	public String getV() {
		return this.v;
	}

	@JsonProperty("v")
	public void setV(final String v) {
		this.v = v;
	}

	@JsonProperty("ttl")
	public Integer getTtl() {
		return this.ttl;
	}

	@JsonProperty("ttl")
	public void setTtl(final Integer ttl) {
		this.ttl = ttl;
	}

	@JsonProperty("provider")
	public Provider getProvider() {
		return this.provider;
	}

	@JsonProperty("provider")
	public void setProvider(final Provider provider) {
		this.provider = provider;
	}

	@JsonProperty("creditsLeft")
	public Integer getCreditsLeft() {
		return this.creditsLeft;
	}

	@JsonProperty("creditsLeft")
	public void setCreditsLeft(final Integer creditsLeft) {
		this.creditsLeft = creditsLeft;
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

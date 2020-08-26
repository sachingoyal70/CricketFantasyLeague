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
@JsonPropertyOrder({ "fielding", "bowling", "batting", "team", "man-of-the-match", "toss_winner_team", "winner_team",
		"matchStarted" })
public class Data {
	@JsonProperty("fielding")
	private List<Fielding> fielding;
	@JsonProperty("bowling")
	private List<Bowling> bowling;
	@JsonProperty("batting")
	private List<Batting> batting;
	@JsonProperty("team")
	private List<Team> team;
	@JsonProperty("toss_winner_team")
	private String tossWinnerTeam;
	@JsonProperty("winner_team")
	private String winnerTeam;
	@JsonProperty("matchStarted")
	private Boolean matchStarted;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Data() {
		this.fielding = null;
		this.bowling = null;
		this.batting = null;
		this.team = null;
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("fielding")
	public List<Fielding> getFielding() {
		return this.fielding;
	}

	@JsonProperty("fielding")
	public void setFielding(final List<Fielding> fielding) {
		this.fielding = fielding;
	}

	@JsonProperty("bowling")
	public List<Bowling> getBowling() {
		return this.bowling;
	}

	@JsonProperty("bowling")
	public void setBowling(final List<Bowling> bowling) {
		this.bowling = bowling;
	}

	@JsonProperty("batting")
	public List<Batting> getBatting() {
		return this.batting;
	}

	@JsonProperty("batting")
	public void setBatting(final List<Batting> batting) {
		this.batting = batting;
	}

	@JsonProperty("team")
	public List<Team> getTeam() {
		return this.team;
	}

	@JsonProperty("team")
	public void setTeam(final List<Team> team) {
		this.team = team;
	}

	@JsonProperty("toss_winner_team")
	public String getTossWinnerTeam() {
		return this.tossWinnerTeam;
	}

	@JsonProperty("toss_winner_team")
	public void setTossWinnerTeam(final String tossWinnerTeam) {
		this.tossWinnerTeam = tossWinnerTeam;
	}

	@JsonProperty("winner_team")
	public String getWinnerTeam() {
		return this.winnerTeam;
	}

	@JsonProperty("winner_team")
	public void setWinnerTeam(final String winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	@JsonProperty("matchStarted")
	public Boolean getMatchStarted() {
		return this.matchStarted;
	}

	@JsonProperty("matchStarted")
	public void setMatchStarted(final Boolean matchStarted) {
		this.matchStarted = matchStarted;
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

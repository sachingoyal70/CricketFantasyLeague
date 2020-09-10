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
@JsonPropertyOrder({ "players", "name" })
public class Team {
	@JsonProperty("players")
	private List<Player> players;
	@JsonProperty("name")
	private String name;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Team() {
		this.players = null;
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("players")
	public List<Player> getPlayers() {
		return this.players;
	}

	@JsonProperty("players")
	public void setPlayers(final List<Player> players) {
		this.players = players;
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	@JsonProperty("name")
	public void setName(final String name) {
		this.name = name;
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

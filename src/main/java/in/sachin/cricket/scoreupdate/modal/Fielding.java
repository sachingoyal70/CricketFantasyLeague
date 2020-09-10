// 
// Decompiled by Procyon v0.5.36
// 

package in.sachin.cricket.scoreupdate.modal;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "scores" })
public class Fielding {
	@JsonProperty("title")
	private String title;
	@JsonProperty("scores")
	private List<Score> scores;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Fielding() {
		this.scores = null;
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("title")
	public void setTitle(final String title) {
		this.title = title;
	}

	@JsonProperty("scores")
	public List<Score> getScores() {
		return this.scores;
	}

	@JsonProperty("scores")
	public void setScores(final List<Score> scores) {
		this.scores = scores;
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

// 
// Decompiled by Procyon v0.5.36
// 

package in.sachin.cricket.scoreupdate.modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "scores", "title" })
public class Batting {
	@JsonProperty("scores")
	private List<Score__> scores;
	@JsonProperty("title")
	private String title;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Batting() {
		this.scores = null;
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("scores")
	public List<Score__> getScores() {
		return this.scores;
	}

	@JsonProperty("scores")
	public void setScores(final List<Score__> scores) {
		this.scores = scores;
	}

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("title")
	public void setTitle(final String title) {
		this.title = title;
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

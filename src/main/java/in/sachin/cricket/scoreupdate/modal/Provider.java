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
@JsonPropertyOrder({ "source", "url", "pubDate" })
public class Provider {
	@JsonProperty("source")
	private String source;
	@JsonProperty("url")
	private String url;
	@JsonProperty("pubDate")
	private String pubDate;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public Provider() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("source")
	public String getSource() {
		return this.source;
	}

	@JsonProperty("source")
	public void setSource(final String source) {
		this.source = source;
	}

	@JsonProperty("url")
	public String getUrl() {
		return this.url;
	}

	@JsonProperty("url")
	public void setUrl(final String url) {
		this.url = url;
	}

	@JsonProperty("pubDate")
	public String getPubDate() {
		return this.pubDate;
	}

	@JsonProperty("pubDate")
	public void setPubDate(final String pubDate) {
		this.pubDate = pubDate;
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

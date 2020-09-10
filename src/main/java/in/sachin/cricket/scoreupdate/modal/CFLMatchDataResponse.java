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
@JsonPropertyOrder({ "dateTimeGMT", "data", "type", "cache3", "creditsLeft", "v", "ttl", "provider" })
public class CFLMatchDataResponse {
	@JsonProperty("dateTimeGMT")
	private String dateTimeGMT;
	@JsonProperty("data")
	private Data data;
	@JsonProperty("type")
	private String type;
	@JsonProperty("cache3")
	private Boolean cache3;
	@JsonProperty("creditsLeft")
	private Integer creditsLeft;
	@JsonProperty("v")
	private String v;
	@JsonProperty("ttl")
	private Integer ttl;
	@JsonProperty("provider")
	private Provider provider;
	@JsonIgnore
	private Map<String, Object> additionalProperties;

	public CFLMatchDataResponse() {
		this.additionalProperties = new HashMap<String, Object>();
	}

	@JsonProperty("dateTimeGMT")
	public String getDateTimeGMT() {
		return this.dateTimeGMT;
	}

	@JsonProperty("dateTimeGMT")
	public void setDateTimeGMT(final String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}

	@JsonProperty("data")
	public Data getData() {
		return this.data;
	}

	@JsonProperty("data")
	public void setData(final Data data) {
		this.data = data;
	}

	@JsonProperty("type")
	public String getType() {
		return this.type;
	}

	@JsonProperty("type")
	public void setType(final String type) {
		this.type = type;
	}

	@JsonProperty("cache3")
	public Boolean getCache3() {
		return this.cache3;
	}

	@JsonProperty("cache3")
	public void setCache3(final Boolean cache3) {
		this.cache3 = cache3;
	}

	@JsonProperty("creditsLeft")
	public Integer getCreditsLeft() {
		return this.creditsLeft;
	}

	@JsonProperty("creditsLeft")
	public void setCreditsLeft(final Integer creditsLeft) {
		this.creditsLeft = creditsLeft;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(final String name, final Object value) {
		this.additionalProperties.put(name, value);
	}
}

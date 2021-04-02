
package in.sachin.cricket.matchdata.modal;

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
@JsonPropertyOrder({
    "matches",
    "v",
    "ttl",
    "provider",
    "creditsLeft"
})
public class CFLMatches {

    @JsonProperty("matches")
    private List<Match> matches = null;
    @JsonProperty("v")
    private String v;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("provider")
    private Provider provider;
    @JsonProperty("creditsLeft")
    private Integer creditsLeft;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("matches")
    public List<Match> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @JsonProperty("v")
    public String getV() {
        return v;
    }

    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    @JsonProperty("ttl")
    public Integer getTtl() {
        return ttl;
    }

    @JsonProperty("ttl")
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonProperty("creditsLeft")
    public Integer getCreditsLeft() {
        return creditsLeft;
    }

    @JsonProperty("creditsLeft")
    public void setCreditsLeft(Integer creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

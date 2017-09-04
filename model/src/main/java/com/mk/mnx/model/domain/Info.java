
package com.mk.mnx.model.domain;

import com.mk.mnx.infr.model.BaseModel;

public class Info extends BaseModel {

    private String seed;
    private Long results;
    private Long page;
    private String version;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

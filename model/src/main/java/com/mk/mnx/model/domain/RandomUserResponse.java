
package com.mk.mnx.model.domain;

import java.util.List;

import com.mk.mnx.infr.model.BaseModel;

public class RandomUserResponse extends BaseModel{

    private List<Person> results = null;
    private Info info;

    public List<Person> getResults() {
        return results;
    }

    public void setResults(List<Person> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}

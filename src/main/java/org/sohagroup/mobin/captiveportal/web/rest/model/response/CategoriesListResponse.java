package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class CategoriesListResponse {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<CategoriesResponse> results;

    public CategoriesListResponse() {}

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<CategoriesResponse> getResults() {
        return results;
    }

    public void setResults(List<CategoriesResponse> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesListResponse that = (CategoriesListResponse) o;
        return (
            Objects.equals(count, that.count) &&
            Objects.equals(next, that.next) &&
            Objects.equals(previous, that.previous) &&
            Objects.equals(results, that.results)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, next, previous, results);
    }

    @Override
    public String toString() {
        return (
            "CategoriesListResponse{" +
            "count=" +
            count +
            ", next='" +
            next +
            '\'' +
            ", previous='" +
            previous +
            '\'' +
            ", results=" +
            results +
            '}'
        );
    }
}

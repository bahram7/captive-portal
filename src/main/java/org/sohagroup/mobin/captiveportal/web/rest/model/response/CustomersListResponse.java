package org.sohagroup.mobin.captiveportal.web.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.openapitools.jackson.nullable.JsonNullable;

public class CustomersListResponse {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    @Valid
    private List<CustomersResponse> results = null;

    @Schema(name = "count", example = "123", required = false)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Valid
    @Schema(name = "next", example = "http://api.example.org/accounts/?offset=400&limit=100", required = false)
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Valid
    @Schema(name = "previous", example = "http://api.example.org/accounts/?offset=200&limit=100", required = false)
    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * Get results
     * @return results
     */
    @Valid
    @Schema(name = "results", required = false)
    public List<CustomersResponse> getResults() {
        return results;
    }

    public void setResults(List<CustomersResponse> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomersListResponse paginatedCustomerList = (CustomersListResponse) o;
        return (
            Objects.equals(this.count, paginatedCustomerList.count) &&
            Objects.equals(this.next, paginatedCustomerList.next) &&
            Objects.equals(this.previous, paginatedCustomerList.previous) &&
            Objects.equals(this.results, paginatedCustomerList.results)
        );
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, next, previous, results);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] { a.get() }) : 31;
    }

    @Override
    public String toString() {
        return (
            "CustomersListResponse{" +
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

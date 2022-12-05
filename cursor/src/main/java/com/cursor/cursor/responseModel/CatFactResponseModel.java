package com.cursor.cursor.responseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CatFactResponseModel {

    public final String fact;
    public final int length;

    public CatFactResponseModel(@JsonProperty("fact") String fact, @JsonProperty("length") int length) {
        this.fact = fact;
        this.length = length;
    }

    @Override
    public String toString() {
        return "CatFactResponseModel{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}

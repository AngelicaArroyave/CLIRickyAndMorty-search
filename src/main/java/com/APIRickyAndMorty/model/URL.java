package com.APIRickyAndMorty.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class URL {

    private String name;
    private String url;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

package com.APIRickyAndMorty.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public final class RickyAndMorty {

    private Info info;
    private List<Result> results;

    @Override
    public String toString() {
        return "RickAndMorty {" + info + results + "\n}";
    }
}

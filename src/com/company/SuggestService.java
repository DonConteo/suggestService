package com.company;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuggestService {

    private final List<String> companyNames;

    public SuggestService(List<String> companyNames) {
        this.companyNames = List.copyOf(companyNames);
    }

    public List<String> suggest(String input, Integer numberOfSuggest) {
        if (input == null || input.isBlank() || numberOfSuggest < 1)
            return Collections.emptyList();
        return companyNames.stream()
                .filter(companyName -> companyName.startsWith(input))
                .limit(numberOfSuggest)
                .collect(Collectors.toList());
    }
}
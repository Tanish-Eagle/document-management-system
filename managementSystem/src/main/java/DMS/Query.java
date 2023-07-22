/*
 * This class is for handling the queries, though you have to handle the sending and sending the input to this class differently.
 */
package main.java.DMS;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toMap;

class Query implements Predicate<Document> {
    private final Map<String, String> clauses;

    static Query parse(final String query) {
        return new Query(Arrays.stream(query.split()).map(str -> str.split(":")).collect(toMap(x -> x[0], x -> x[1])));
    }

    private Query(final Map<String, String> clauses) {
        this.clauses = clauses;
    }

    @Override
    public boolean test(final Document document) {
        return clauses.entrySet().stream().allMatch(entry -> {
            final String documentValue = document.getAttribute(entry.getKey());
            final String queryValue = entry.getValue();
            return documentValue != null && documentValue.contains(queryValue);
        });
    }
}

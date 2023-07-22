/*
 * This class represents a document as a key-value pair.
 * It allows the users to create a document object with a collection of attributes and retrieve specific attribute values using their names.
 */

package main.java.DMS;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}

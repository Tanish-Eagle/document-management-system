/*
 * This file handles letters.
 */
package main.java.DMS;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static main.java.DMS.Attributes.*;

class LetterImporter implements Importer {
    private static final String name_prefix = "Dear ";

    @Override
    public Document(final File file) throws IOException {

        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(name_prefix, PATIENT);
        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);
        final Map<String, String> attributes = textFiles.getAttributes();
        attributes.put(type, "LETTER");
        return new Document(attributes);
    }
}

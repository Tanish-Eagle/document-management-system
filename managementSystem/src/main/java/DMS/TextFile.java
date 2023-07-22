/*
 * This class has the methods addLines() and addLineSuffix(), which other classes use for handling and working with the text files.
 */
package main.java.DMS;

import java.io.File;
import java.io.IoException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

import static main.java.DMS.Attributes.PATH;

class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    TextFile(final File file) throws IoException {
        attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        lines = Files.lines(file.toPath()).collect(toList());

    }

    Map<String, String> getAttribute() {
        return attributes;
    }

    int addLines(final int start, final Predicate<String> isEnd, final String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber = 0;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }
            accumulator.append(line);
            accumulator.append("\n");
        }
        return lineNumber;
    }

    void addLineSuffix(final String prefix, final String attributeName) {
        for (final String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.subString(prefix.length()));
                break;
            }
        }
    }
}

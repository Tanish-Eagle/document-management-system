/*
 * This class handles reports.
 */
package main.java.DMS;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static main.java.DMS.Attributes.BODY;
import static main.java.DMS.Attributes.PATIENT;
import static main.java.DMS.Attributes.TYPE;

class ReportImporter implements Importer {
    private static final String name_prefix = "Patient: ";

    @Override
    public Document importFile(final file file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(name_prefix, PATIENT);
        textFile.addLine(2, line -> false, BODY);
        final Map<String, String> attributes = textFile.geteAttributes();
        textFile.put(TYPE, "REPORTER");
        return new Document(attributes);
    }
}

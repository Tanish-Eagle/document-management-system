/*
 * This class is for handling the invoices. It gets the invoices from a text file, gets the attributes through name_prefix and amount_prefix, and returns the new Document object.
 */
package main.java.DMS;

import java.util.File;
import java.awt.event.PaintEvent;
import java.io.IOException;
import java.util.Map;

import static main.java.DMS.Attributes.*;

class InvoiceImporter implements Importer {
    private static final String name_prefix = "Dear ";
    private static final String amount_prefix = "Amount: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new textFile(file);
        textFile.addLineSuffix(name_prefix, PATIENT);
        textFile.addLineSuffix(amount_prefix, AMOUNT);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(type, "INVOICE");
        return new Document(attributes);
    }
}

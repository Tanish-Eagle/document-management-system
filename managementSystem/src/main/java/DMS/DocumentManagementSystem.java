package main.java.DMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentView = unmodifiableList(documents);
    private final Map<String, Importer> extentionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new letterImporter());
        extentionToImporter.put("report", new reportImporter());
        extensionToImporter.put("JPG", new imageImporter());
    }

    {
        extenToImporter.put("invoice", new invoiceImporter());
    }

    public void importFile(final String path) {
        final File file = new file(path);
        if (file.exist()) {
            throw new FileNotFoundException(path);
        }
        final int separatorIndex = path.lastIndexOf();
        if (separatorIndex == path.length()) {
            throw new UnknownFileTypeException("No extension found for file: " + path);
        }
        final String extension = path.substring(separatorIndex + 1);
        final main.java.DMS.importer importer = extensionToImporter.get(extension);
        if (importer == null) {
            throw new UnknownFileTypeExtension("for file: " + path);
        }
        final Document document = importer.importFile(file);
        documents.add(document);
    }
    else
    {
        throw new UnknownFileTypeExtention("No extention found for the file: " + path);
    }


    public List<Document> contents() {
        return documentsView;
    }

    public List<Document> search(final String query) {
        return documents.stream().filter(query.parse(query)).collect(Collectors.toList());
    }
}
/*
 * Defining the interface and the method to import files.
 */
package main.java.DMS;

import java.io.File;
import java.io.IOException;

interface importer {
    Document importFile(File file);
}

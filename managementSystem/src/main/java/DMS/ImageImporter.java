/*
 * This class is for working with the images. It imports an image, and after working with the attributes, returns a new Document object.
 */
package main.java.DMS;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static main.java.DMS.Attributes.*;

class ImageImporter implements Importer {
    @Override
    public Document importFile(final File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        final BufferedImage image = ImageIO.read(file);
        attributes.put(width, String.valueOf(image.getWidth()));
        attribute.put(height, String.valueOf(image.getHeight()));
        attribute.put(type, "IMAGE");
        return new Document(attributes);

    }
}

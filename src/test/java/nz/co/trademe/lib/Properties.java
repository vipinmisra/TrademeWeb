package nz.co.trademe.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Properties {

    public static String getProperty(String propertyName) {

        // this method reads the property values and returns it as a string
        java.util.Properties property  = new java.util.Properties();
        try {
            File configProperties = new File("src/test/resources/config.properties");
            property.load(new FileInputStream(configProperties));
        }
        catch(FileNotFoundException e) {}
        catch (IOException e) {}

        return property.getProperty(propertyName);

    }

}

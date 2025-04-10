package org.example.project.api.data.json.interfaces;

import org.example.project.api.data.json.JsonConfig;

/**
 * Interface designed to define the necessary methods for classes that store data using Json files.
 */
public interface Restorable {
    /**
     * Method that saves the current class data into a Json file using the {@link JsonConfig}.
     */
    void save(JsonConfig jsonConfig);

    /**
     * Method that restores the current class data from a Json file using the {@link JsonConfig}.
     */
    void restore(JsonConfig jsonConfig);
}

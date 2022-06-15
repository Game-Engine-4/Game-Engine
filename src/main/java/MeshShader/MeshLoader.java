package MeshShader;

import java.io.IOException;

/**
 * Class used to load Mesh from file which contains data
 */
public interface MeshLoader {
    /**
     * Method to load mesh from file
     * @param filename Name of the file which should be opened and read data from it
     * @return Mesh object derived from data of file
     * @throws IOException Exception thrown if file couldn't be opened
     */
    Mesh loadMesh(String filename) throws IOException;
}

package MeshShader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Math.Vector3f;

/**
 * Implementation of MeshLoader interface which implements method of loading mesh from file
 */
public class OBJMeshLoader implements MeshLoader {
    /**
     * Method loading mesh from file which is type of "obj"
     * @param fileName Name of the file which should be opened and read data from it
     * @return Mesh derived from data of file
     * @throws IOException Exception thrown if file couldn't be opened
     */
    @Override
    public Mesh loadMesh(String fileName) throws IOException {
        String[] splitName = fileName.split("\\.");
        String endingWord = splitName[splitName.length - 1];

        if (!endingWord.equals("obj")) {
            throw new IOException("Wrong type of file");
        }

        ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        BufferedReader readMesh;
        String line;
        try {
            readMesh = new BufferedReader(new FileReader(fileName));
            while ((line = readMesh.readLine()) != null) {

                String[] splitted = line.split(" ");

                if (splitted[0].equals("v")) {
                    float v1 = Float.parseFloat(splitted[1]);
                    float v2 = Float.parseFloat(splitted[2]);
                    float v3 = Float.parseFloat(splitted[3]);
                    Vector3f vector = new Vector3f(v1, v2, v3);
                    Vertex myVertex = new Vertex(vector);
                    vertices.add(myVertex);
                } else if (splitted[0].equals("f")) {
                    for (int i = 1; i <= 3; i++) {
                        indices.add((Integer.parseInt(splitted[i]) - 1));
                    }
                }
            }
            readMesh.close();
            Vertex[] objVertices = new Vertex[vertices.size()];
            vertices.toArray(objVertices);

            int[] indicesData = new int[indices.size()];
            for (int i = 0; i < indices.size(); i++) {
                indicesData[i] = indices.get(i);
            }

            Mesh objMesh = new Mesh();
            objMesh.addVertices(objVertices,indicesData);
            return objMesh;

        } catch (IOException e) {
            System.out.println("Couldn't read from obj file");
            throw e;
        }
    }
}

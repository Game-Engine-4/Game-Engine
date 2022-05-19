package MeshShader;

import java.io.IOException;

public interface MeshLoader {
    Mesh loadMesh(String filename) throws IOException;
}

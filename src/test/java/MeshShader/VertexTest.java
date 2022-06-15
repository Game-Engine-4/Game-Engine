package MeshShader;

import Math.Vector3f;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class VertexTest {
    Vertex v1;
    Vector3f v2;


    @BeforeEach
    void init() {
        v1 = new Vertex(1, 2, 3);
        v2 = new Vector3f(1, 1, 1);


    }

    @Test
    void testEmptyConstructor() {
        Vector3f v3 = new Vector3f(0f, 0f, 0f);
        Vertex v1 = new Vertex();
        assertEquals(v1.getPos(), v3);

    }

    @Test
    void failedTestEmptyConstructor() {
        Vertex v1 = new Vertex();
        assertNotEquals(v1.getPos(), v2);

    }

    @Test
    void testConstructor() {
        Vertex v1 = new Vertex(v2);
        assertTrue(v1.getPos() == v2);

    }

    @Test
    void failedTestConstructor() {
        Vector3f v3 = new Vector3f(1, 1, 2);
        Vertex v1 = new Vertex(v2);
        assertFalse(v1.getPos() == v3);

    }

    @Test
    void testSetPos() {
        v1.setPos(v2);
        assertTrue(v1.getPos() == v2);

    }

    @Test
    void failedTestSetPos() {
        Vector3f v3 = new Vector3f(1, 1, 2);
        v1.setPos(v2);
        assertFalse(v1.getPos() == v3);

    }
}

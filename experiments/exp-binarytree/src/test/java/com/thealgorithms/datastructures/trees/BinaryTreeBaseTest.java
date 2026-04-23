import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import com.thealgorithms.datastructures.trees.BinaryTree;

public class BinaryTreeBaseTest {

    @Test
    void testPut_InserirPrimeiroElemento() {
        BinaryTree tree = new BinaryTree();
        assertDoesNotThrow(() -> tree.put(10));
    }

    @Test
    void testPut_InserirElementoMenorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(5));
    }

    @Test
    void testPut_InserirElementoMaiorQueRaiz() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        assertDoesNotThrow(() -> tree.put(15));
    }

    @Test
    void testPut_InserirMultiplosElementos() {
        BinaryTree tree = new BinaryTree();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        assertDoesNotThrow(() -> tree.put(7));
    }
}


package visao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JBAlterarAmigoTest {

    @Test
    void testSetVisibleTrueThrowsException() {
        JBAlterarAmigo jb = new JBAlterarAmigo();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            jb.setVisible(true);
        });
        assertEquals("Not supported yet.", exception.getMessage());
    }

    @Test
    void testSetVisibleFalseThrowsException() {
        JBAlterarAmigo jb = new JBAlterarAmigo();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            jb.setVisible(false);
        });
        assertEquals("Not supported yet.", exception.getMessage());
    }

    @Test
    void testClassCanBeInstantiated() {
        JBAlterarAmigo jb = new JBAlterarAmigo();
        assertNotNull(jb);
    }
}
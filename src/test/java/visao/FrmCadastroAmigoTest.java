package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrmCadastroAmigoTest {

    private FrmCadastroAmigo frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmCadastroAmigo();
    }

    @Test
    public void testNomeInvalidoMenosDe3Caracteres() {
        String resultado = frm.validarCampos("Jo", "11988887777");
        assertEquals("O nome deve ter ao menos 3 caracteres", resultado);
    }

    @Test
    public void testTelefoneInvalidoMenosDe11Caracteres() {
        String resultado = frm.validarCampos("João", "1198888");
        assertEquals("O número de telefone precisa de ao menos 11 números", resultado);
    }

    @Test
    public void testNomeETelefoneValidos() {
        String resultado = frm.validarCampos("João da Silva", "11988887777");
        assertEquals("OK", resultado);
    }

    @Test
    public void testNomeVazio() {
        String resultado = frm.validarCampos("", "11988887777");
        assertEquals("O nome deve ter ao menos 3 caracteres", resultado);
    }

    @Test
    public void testTelefoneVazio() {
        String resultado = frm.validarCampos("João", "");
        assertEquals("O número de telefone precisa de ao menos 11 números", resultado);
    }
}
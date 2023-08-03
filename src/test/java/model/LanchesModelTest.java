package model;

import junit.framework.TestCase;
import org.junit.Test;

public class LanchesModelTest extends TestCase {
    private LanchesModel lanchesModel = new LanchesModel();

    @Test
    public void testBuscarNomeLanche() {
        int idLancheExiste = 2;
        int idLancheNaoExiste = 10;

        String nomeLancheExiste = "X-Salada";
        String nomeLancheNaoExiste = null;

        String resultadoQueExiste = lanchesModel.buscarNomeLanche(idLancheExiste);
        String resultadoQueNaoExiste = lanchesModel.buscarNomeLanche(idLancheNaoExiste);

        assertEquals(nomeLancheExiste,resultadoQueExiste);
        assertEquals(nomeLancheNaoExiste,resultadoQueNaoExiste);

    }

    @Test
    public void testBuscarValorLanche() {
        int idLancheExiste = 1;
        int idLancheNaoExiste = 10;

        double valorLancheExiste = 10.00;
        double valorLancheNaoExiste = 0.00;

        double resultadoQueExiste = lanchesModel.buscarValorLanche(idLancheExiste);
        double resultadoQueNaoExiste = lanchesModel.buscarValorLanche(idLancheNaoExiste);

        assertEquals(valorLancheExiste,resultadoQueExiste);
        assertEquals(valorLancheNaoExiste, resultadoQueNaoExiste);
    }
}
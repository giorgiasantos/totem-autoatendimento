package model;

import junit.framework.TestCase;
import org.junit.Test;

public class BebidasModelTest extends TestCase {
    private BebidasModel bebidasModel = new BebidasModel();

    @Test
    public void testBuscarNomeBebida() {
        int idBebidaExiste = 2;
        int idBebidaNaoExiste = 10;

        String nomeBebidaExiste = "Suco";
        String nomeBebidaNaoExiste = null;

        String resultadoQueExiste = bebidasModel.buscarNomeBebida(idBebidaExiste);
        String resultadoQueNaoExiste = bebidasModel.buscarNomeBebida(idBebidaNaoExiste);

        assertEquals(nomeBebidaExiste,resultadoQueExiste);
        assertEquals(nomeBebidaNaoExiste,resultadoQueNaoExiste);

    }

    @Test
    public void testBuscarValorBebida() {

        int idBebidaExiste = 1;
        int idBebidaNaoExiste = 10;

        double valorBebidaExiste = 8.00;
        double valorBebidaNaoExiste = 0.00;

        double resultadoQueExiste = bebidasModel.buscarValorBebida(idBebidaExiste);
        double resultadoQueNaoExiste = bebidasModel.buscarValorBebida(idBebidaNaoExiste);

        assertEquals(valorBebidaExiste,resultadoQueExiste);
        assertEquals(valorBebidaNaoExiste, resultadoQueNaoExiste);


    }
}
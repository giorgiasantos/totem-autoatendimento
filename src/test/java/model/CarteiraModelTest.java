package model;

import junit.framework.TestCase;
import org.junit.Test;

public class CarteiraModelTest extends TestCase {
    private CarteiraModel carteiraModel = new CarteiraModel();

    @Test
    public void testBuscarTipoPagamento() {
        int idPagamentoExiste = 1;
        int idPagamentoNaoExiste = 7;

        String nomePagamentoExiste = "Crédito";
        String nomePagamentoNaoExiste = null;

        String resultadoExiste = carteiraModel.buscarTipoPagamento(idPagamentoExiste);
        String resultadoNaoExiste = carteiraModel.buscarTipoPagamento(idPagamentoNaoExiste);

        assertEquals(nomePagamentoExiste,resultadoExiste);
        assertEquals(nomePagamentoNaoExiste, resultadoNaoExiste);

    }
}
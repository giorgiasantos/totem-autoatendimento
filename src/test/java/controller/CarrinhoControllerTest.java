package controller;

import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.*;

public class CarrinhoControllerTest extends TestCase {

    private CarrinhoController carrinhoController = new CarrinhoController();
    private Statement statement;
    Connection connection;

    @Before
    public void setUp() throws Exception {
        carrinhoController = new CarrinhoController();
        connection = mock(Connection.class);
        statement = mock(Statement.class);

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(anyString())).thenReturn(1);

    }

    @Test
    public void testCriarNovoPedido() throws SQLException {
        carrinhoController.criarNovoPedido(1,1,1);
        verify(statement).executeUpdate("insert into tb_pedidos (tipo_item, referencia_item, quantidade) values ('" + 1 + "', '" + 1 + "', '" + 1 + "')");
    }

    public void testCalcularValorTotal() {
    }

    public void testExibirPedido() {
    }

    public void testEditarQuantidade() {
    }

    public void testExcluirItem() {
    }

    public void testSelecionarFormaPagamento() {
    }


    public void testCalcularTroco() {
    }
}
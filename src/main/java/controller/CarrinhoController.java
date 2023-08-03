package controller;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static conexao.Conexao.getConnection;
public class CarrinhoController {

    //ATRIBUTOS
    private Statement statement;

    // CONSTRUCTOR
    public CarrinhoController() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MÉTODOS

    // criar um novo pedido
    public void criarNovoPedido(int tipoItem, int refItem, int quantidade) {
        String sql = "insert into tb_pedidos (tipo_item, referencia_item, quantidade) values ('" + tipoItem + "', '" + refItem + "', '" + quantidade + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("SEU PEDIDO FOI ADICIONADO AO CARRINHO!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // calcular valor da compra
    public double calcularValorTotal(int idPedido) {

        String sql = "select tipo_item, referencia_item, quantidade from tb_pedidos where  id_pedido ='" + idPedido + "'";
        double valorTotal = 0.0;
        LanchesModel lanchesModel = new LanchesModel();
        BebidasModel bebidasModel = new BebidasModel();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                if (resultSet.getInt("tipo_item") == 1) {
                    double valorItem = lanchesModel.buscarValorLanche(resultSet.getInt("referencia_item"));
                    int quantidade = resultSet.getInt("quantidade");
                    valorTotal = valorItem * quantidade;
                    System.out.println("O VALOR TOTAL É R$ " + valorTotal);

                } else if (resultSet.getInt("tipo_item") == 2) {
                    double valorItem = bebidasModel.buscarValorBebida(resultSet.getInt("referencia_item"));
                    int quantidade = resultSet.getInt("quantidade");
                    valorTotal = valorItem * quantidade;
                    System.out.println("O VALOR TOTAL É R$ " + valorTotal);
                }

                // atualizando o tempo de permanência na tabela
                String sqlValorTotal = "update tb_pedidos set valor_total = '" + valorTotal + "' where id_pedido = '" + idPedido + "'";
                statement.executeUpdate(sqlValorTotal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valorTotal;
    }

    public void exibirPedido(int idPedido) {
        calcularValorTotal(idPedido);
        String sql = "select * from tb_pedidos where id_pedido = '" + idPedido + "'";
        String tipoPedido = "";
        String refItem = "";

        LanchesModel lanchesModel = new LanchesModel();
        BebidasModel bebidasModel = new BebidasModel();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int tipoItem = resultSet.getInt("tipo_item");
                int refItemID = resultSet.getInt("referencia_item");
                int quantidade = resultSet.getInt("quantidade");
                double valorTotal = resultSet.getDouble("valor_total");

                if (tipoItem == 1) {
                    tipoPedido = "Lanche";
                    refItem = lanchesModel.buscarNomeLanche(refItemID);
                } else if (tipoItem == 2) {
                    tipoPedido = "Bebida";
                    refItem = bebidasModel.buscarNomeBebida(refItemID);
                }

                System.out.println("ID DO PEDIDO: " + idPedido + " | TIPO DO ITEM: " + tipoPedido + " | REFERÊNCIA DO ITEM: " + refItem + " | QUANTIDADE: " + quantidade + " | VALOR TOTAL R$" + valorTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo para editar o pedido
    public void editarQuantidade(int idPedido, int quantidadeNova){
        String sql = "update tb_pedidos set quantidade = '" + quantidadeNova + "' where id_pedido = '" + idPedido + "'";

        try{
            statement.executeUpdate(sql);
            System.out.println("QUANTIDADE DE ITENS ATUALIZADA COM SUCESSO.");
            exibirPedido(idPedido);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // método para excluir um item do pedido
    public void excluirItem(int idPedido){
        String sql = "delete from tb_pedidos where id_pedido = '"+idPedido+"'";

        try{
            statement.executeUpdate(sql);
            System.out.println("ITEM EXCLUÍDO COM SUCESSO.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // selecionar forma de pagamento
    public void selecionarFormaPagamento(int idPedido, int formaPagamento) {
        String sql = "select forma_pagamento from tb_pedidos where  id_pedido ='" + idPedido + "'";
        CarteiraModel carteiraModel = new CarteiraModel();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                if (formaPagamento > 0 && formaPagamento <= 3) {
                    System.out.println("VOCÊ SELECIONOU " + carteiraModel.buscarTipoPagamento(formaPagamento));
                    System.out.println("PROCESSANDO PAGAMENTO....");
                    System.out.println("PAGAMENTO APROVADO!");

                } else if (formaPagamento == 4) {
                    System.out.println("VOCÊ SELECIONOU " + carteiraModel.buscarTipoPagamento(formaPagamento));
                    System.out.println("AGUARDE SEU TROCO.");
                    System.out.println("OBRIGADO!");

                }

                String sqlPagamento = "update tb_pedidos set forma_pagamento = '" + carteiraModel.buscarTipoPagamento(formaPagamento) + "' where id_pedido = '" + idPedido + "'";

                statement.executeUpdate(sqlPagamento);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}





package model;

import java.util.HashMap;
import java.util.Map;

public class CarteiraModel {
    //ATRIBUTOS
    private Map<Integer, PagamentoModel> listaPagamentos;

    //CONSTRUCTOR
    public CarteiraModel() {
        this.listaPagamentos = new HashMap<>();
        listaPagamentos.put(1, new PagamentoModel("Crédito"));
        listaPagamentos.put(2, new PagamentoModel("Débito"));
        listaPagamentos.put(3, new PagamentoModel("Vale-refeição"));
        listaPagamentos.put(4, new PagamentoModel("Dinheiro"));
    }

    // seleciona o tipo de pagamento
    public String buscarTipoPagamento(int idPagamento){
        PagamentoModel pagamentoModel = listaPagamentos.get(idPagamento);
        if(pagamentoModel !=null) {
            return pagamentoModel.getFormaDePagamento();
        }
        return null;
    }

}

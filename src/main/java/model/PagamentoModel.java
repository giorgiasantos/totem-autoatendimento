package model;

import java.util.HashMap;
import java.util.Map;

public class PagamentoModel {
    //ATRIBUTOS
    private String formaDePagamento;


    //CONSTRUCTOR
    public PagamentoModel(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    // GETTER
    public String getFormaDePagamento() {
        return formaDePagamento;
    }



}

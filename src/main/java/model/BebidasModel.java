package model;

import java.util.HashMap;
import java.util.Map;

public class BebidasModel extends ProdutoModel{

    //ATRIBUTOS
    private Map<Integer, ProdutoModel> listaBebidas;


    //CONSTRUCTOR
    public BebidasModel() {
        this.listaBebidas = new HashMap<>();
        listaBebidas.put(1, new ProdutoModel("Refrigerante", 8.00));
        listaBebidas.put(2, new ProdutoModel("Suco", 6.00));
    }

    //METODOS

    // metodo para buscar o nome da bebida
    public String buscarNomeBebida(int idBebida){
        ProdutoModel produtoModel = listaBebidas.get(idBebida);
        if(produtoModel !=null) {
            return produtoModel.getNomeProduto();
        }
        return null;
    }

    //método para buscar valor da bebida
    public Double buscarValorBebida(int idBebida){
        ProdutoModel produtoModel = listaBebidas.get(idBebida);
        if(produtoModel !=null) {
            return produtoModel.getValorProduto();
        }
        return 0.0;
    }

}

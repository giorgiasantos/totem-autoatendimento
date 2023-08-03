package model;

import java.util.HashMap;
import java.util.Map;

public class LanchesModel extends ProdutoModel{

    //ATRIBUTOS
    private Map<Integer, ProdutoModel> listaLanches;

    //CONSTRUCTOR
    public LanchesModel() {
        this.listaLanches = new HashMap<>();
        listaLanches.put(1, new ProdutoModel("X-Burger", 10.00));
        listaLanches.put(2, new ProdutoModel("X-Salada", 12.00));
    }


    //METODOS

    // metodo para buscar o nome do lanche
    public String buscarNomeLanche(int idLanche){
        ProdutoModel produtoModel = listaLanches.get(idLanche);
        if(produtoModel !=null) {
            return produtoModel.getNomeProduto();
        }
        return null;
    }

    //método para buscar valor do lanche
    public Double buscarValorLanche(int idLanche){
        ProdutoModel produtoModel = listaLanches.get(idLanche);
        if(produtoModel !=null) {
            return produtoModel.getValorProduto();
        }
        return 0.0;
    }

}

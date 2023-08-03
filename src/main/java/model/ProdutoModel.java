package model;

public class ProdutoModel {
    //ATRIBUTOS

    private String nomeProduto;
    private Double valorProduto;

    //CONSTRUCTOR
    public ProdutoModel(String nomeProduto, Double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }
    public ProdutoModel() {
    }

    // GETTERS E SETTERS

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }


}

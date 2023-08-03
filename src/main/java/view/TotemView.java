package view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TotemView {

    //CONSTRUCTOR
    public TotemView() {

    }

    public void menuLanches(){
        System.out.println("-----MENU DE LANCHES-----");
        System.out.println("DIGITE A OPÇÃO DESEJADA:");
        System.out.println("1 ) X-BURGER = R$ 10.00");
        System.out.println("2) X-SALADA = R$ 12.00");
        System.out.println("3) VOLTAR");

    }

    public void menuBebidas(){
        System.out.println("-----MENU DE BEBIDAS-----");
        System.out.println("DIGITE A OPÇÃO DESEJADA:");
        System.out.println("1 ) REFRIGERANTE = R$ 8.00");
        System.out.println("2) SUCO = R$ 6.00");
        System.out.println("3) VOLTAR");

    }

    public void formasPagamento(){
        System.out.println("-----FORMAS DE PAGAMENTO-----");
        System.out.println("DIGITE A OPÇÃO DESEJADA:");
        System.out.println("1) CRÉDITO");
        System.out.println("2) DÉBITO");
        System.out.println("3) VALE-ALIMENTAÇÃO");
        System.out.println("4) DINHEIRO");
        System.out.println("5) VOLTAR");
    }

}

import controller.CarrinhoController;
import view.TotemView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarrinhoController carrinhoController = new CarrinhoController();
        TotemView totemView = new TotemView();

        Scanner entrada = new Scanner(System.in);


        System.out.println("BEM-VINDE À LANCHONETE! FAÇA O SEU PEDIDO AQUI.");
        boolean deNovo = true;
        int primeiraOpcao = 0;
        int segundaOpcao = 0;
        int opcaoLanche = 0;
        int opcaoBebida = 0;
        int quantidadeItem = 0;

        try{
            while (deNovo) {
                System.out.println("OPÇÕES:");
                System.out.println("1) FAZER NOVO PEDIDO");
                System.out.println("2) EDITAR QUANTIDADE DE UM PEDIDO");
                System.out.println("3) EXCLUIR UM PEDIDO");
                System.out.println("4) SELECIONAR FORMA DE PAGAMENTO");
                System.out.println("5) SAIR");

                primeiraOpcao = entrada.nextInt();
                switch (primeiraOpcao) {

                    case 1:
                        do {
                            System.out.println("DIGITE: 1 PARA LANCHE | 2 PARA BEBIDA | 3 PARA VOLTAR: ");
                            segundaOpcao = entrada.nextInt();

                            switch (segundaOpcao) {
                                case 1:
                                    do {
                                        totemView.menuLanches();
                                        opcaoLanche = entrada.nextInt();
                                        switch (opcaoLanche) {
                                            case 1:
                                                System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                                                quantidadeItem = entrada.nextInt();
                                                carrinhoController.criarNovoPedido(segundaOpcao, opcaoLanche, quantidadeItem);
                                                break;
                                            case 2:
                                                System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                                                quantidadeItem = entrada.nextInt();
                                                carrinhoController.criarNovoPedido(segundaOpcao, opcaoLanche, quantidadeItem);
                                                break;
                                            case 3:
                                                System.out.println("VOLTANDO...");
                                                break;
                                            default:
                                                System.out.println("OPÇÃO INVÁLIDA");
                                        }
                                    } while (opcaoLanche != 3);
                                    break;
                                case 2:
                                    do {
                                        totemView.menuBebidas();
                                        opcaoBebida = entrada.nextInt();
                                        switch (opcaoBebida) {
                                            case 1:
                                                System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                                                quantidadeItem = entrada.nextInt();
                                                carrinhoController.criarNovoPedido(segundaOpcao, opcaoBebida, quantidadeItem);
                                                break;
                                            case 2:
                                                System.out.println("INFORME A QUANTIDADE DESEJADA: ");
                                                quantidadeItem = entrada.nextInt();
                                                carrinhoController.criarNovoPedido(segundaOpcao, opcaoBebida, quantidadeItem);
                                                break;
                                            case 3:
                                                System.out.println("VOLTANDO...");
                                                break;
                                            default:
                                                System.out.println("OPÇÃO INVÁLIDA");
                                        }
                                    } while (opcaoBebida != 3);
                                    break;
                                case 3:
                                    System.out.println("VOLTANDO....");
                                    break;
                                default:
                                    System.out.println("OPÇÃO INVÁLIDA!");
                            }
                        } while (segundaOpcao != 3);
                        break;
                    case 2:
                        System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA EDITAR: ");
                        int idPedidoQtde = entrada.nextInt();
                        carrinhoController.exibirPedido(idPedidoQtde);
                        System.out.println("DIGITE A NOVA QUANTIDADE: ");
                        int novaQtde = entrada.nextInt();
                        carrinhoController.editarQuantidade(idPedidoQtde, novaQtde);
                        break;
                    case 3:
                        System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA EXCLUIR: ");
                        int idPedidoExcluir = entrada.nextInt();
                        carrinhoController.exibirPedido(idPedidoExcluir);
                        carrinhoController.excluirItem(idPedidoExcluir);
                        break;
                    case 4:
                        System.out.println("DIGITE O ID DO PEDIDO QUE DESEJA PAGAR: ");
                        int idPedidoPagamento = entrada.nextInt();
                        carrinhoController.exibirPedido(idPedidoPagamento);
                        totemView.formasPagamento();
                        int opcaoPagamento = entrada.nextInt();
                        carrinhoController.selecionarFormaPagamento(idPedidoPagamento, opcaoPagamento);
                        break;
                    case 5:
                        System.out.println("TUDO BEM. ATÉ MAIS!");
                        return;
                    default:
                        System.out.println("OPÇÃO INVÁLIDA!");
                        break;
                }

            }

        }catch(InputMismatchException exception){
            System.out.println("OPÇÃO INVÁLIDA! O SISTEMA SÓ ACEITA NÚMEROS!");

        }
    }
}

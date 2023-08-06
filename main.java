package AvaliacaoDiagnostia;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

            // Menu principal
        System.out.println("* Bem-vindo ao nosso restaurante dos VINTE! *");
        System.out.println("1. Fazer um pedido\n"+
                "2. Sair\n"+
                "O que deseja fazer?");

        int opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Qual é o seu nome?");
                String nomeCliente = teclado.next();
                System.out.println("* Cardápio *\n"+
                "1. X-Egg (R$20,00)\n"+
                        "2. X-Salada (R$20,00)\n"+
                        "3. X-Bacon (R$20,00)\n"+
                        "4. X-Tudo (R$20,00)\n"+
                        "5. X-Frango (R$20,00)");
                ArrayList<ItemPedido> itensPedido = new ArrayList<>();
                while (true) {
                    System.out.println("Digite o número do item que deseja adicionar ao seu pedido: ");
                    int numeroItem = teclado.nextInt();
                    if (numeroItem == 0) {
                        break;
                    }
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setNumero(numeroItem);
                    itemPedido.setPreco(20.00);
                    itensPedido.add(itemPedido);
                    }


                    System.out.println("* Nota Fiscal *");
                    System.out.println("Cliente: " + nomeCliente);
                    System.out.println("Itens:");

                    for (ItemPedido itemPedido : itensPedido) {
                        System.out.println(itemPedido.getNumero()  + ". X de " + itemPedido.getNumero() + " (R$" + itemPedido.getPreco() + ")");
                    }

                    double taxaServico = 0.10 * itensPedido.size() * 20.00;
                    System.out.println("Taxa de serviço: R$" + taxaServico);


                    double valorTotal = itensPedido.size() * 20.00 + taxaServico;
                    System.out.println("Valor total: R$" + valorTotal);

                    System.out.println("Quanto foi recebido em dinheiro? ");
                    double valorRecebido = teclado.nextDouble();

                    double troco = valorRecebido - valorTotal;
                    System.out.println("Troco: R$" + troco);

                    break;
                case 2:
                    // Sair
                    System.out.println("Obrigado pela preferência! Até a próxima.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    class ItemPedido {

        private int numero;
        private double preco;

        public ItemPedido() {
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }
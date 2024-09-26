package exLista;

import java.util.Scanner;

public class ex001 {
    private static class LISTA {    
        public int codigo;
        public double price;
        public int qtd;
        public LISTA prox;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LISTA inicio = null;
        LISTA fim = null;
        LISTA aux;
        int contador = 0;

        double desconto;

        do {
            System.out.println("\nLISTA DE COMPRAS\n");
        
            System.out.println("\nparte 1 - cadastrar 5 produtos na lista\n");
    
            for (int i = 0; i < 5; i++) {
                LISTA novo = new LISTA();
                    
                System.out.print("Digite o código do produto: ");
                novo.codigo = sc.nextInt();
    
                System.out.println("Digie o preço do produto: ");
                novo.price = sc.nextDouble();
    
                System.out.println("Digite a quantidade: ");
                novo.qtd = sc.nextInt();
    
                contador = contador + novo.qtd;
    
                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    fim.prox = null;
                } else {
                    novo.prox = inicio;
                    inicio = novo;
                }
    
                System.out.println("Produto cadastrado com sucesso!");
            }

            System.out.println("\nQuantidade de produtos: " + contador);

            if (contador < 500) {
                System.out.println("\nInforme a quantidade de modo que a quantidade total seja maior que 500\n");
            }

        } while (contador < 500);

        System.out.println("\nParte 2 - Receber do usuário a taxa de desconto\n");
        
        System.out.print("Digite a taxa de desconto do produto: ");
        desconto = sc.nextDouble();

        aux = inicio;

        if (inicio == null) {
            System.out.println("Lista vazia!");
        } else {
            aux = inicio; 

            while (aux != null) {
                aux.price = aux.price - (aux.price * (desconto / 100));
                System.out.println("Código: " + aux.codigo + " \nPreço: " + aux.price + " \nQuantidade: " + aux.qtd + "\n ");
                aux = aux.prox; 
            }
        }

        sc.close();
    }
}

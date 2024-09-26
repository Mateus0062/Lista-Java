package listaSimples;

import java.util.Scanner;

public class Ls_Ordenada {

    private static class LISTA {    
        public int num;
        public LISTA prox;
    }


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        LISTA inicio = null; // A lista está vazia, logo, o objeto inicio tem o valor nulo.
        LISTA fim = null; // O objeto fim conterá o endereço do último elemento da lista.

        LISTA aux; // auxiliar1.
        LISTA anterior; // auxiliar2.

        int op, numero, achou;

        do {
            System.out.println("\nMENU DE OPÇÕES\n");
            
            System.out.println("1 - Inserir na lista");
            
            System.out.println("2 - Consultar toda a lista");
            
            System.out.println("3 - Remover da lista");
            
            System.out.println("4 - Esvaziar a lista");
            
            System.out.println("5 - Sair");
            
            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();

            if (op == 1) {
               System.out.print("Digite o número que deseja inserir na lista: "); // 10  
               LISTA novo = new LISTA();  
               novo.num = entrada.nextInt(); // novo = 10

                if (inicio == null) { // se a lista está vazia....
                    inicio = novo; // inicio = novo = 10.
                    novo.prox = null; // o próximo número da lista, recebe null. 
                    fim = novo; // fim = novo = 10. Fim recebe novo, pois ainda é o último elemento da lista. 
                } else { // se a lista não estiver vazia...
                    anterior = null; // anterior = null. Anterior não tem valor inicialmente.
                    aux = inicio; // aux = inicio. Aux recebe o endereço do primeiro elemento da lista. aux = 10
                    while (aux != null && novo.num > aux.num) { // enquanto aux não chegar ao fim da lista e o novo elemento for maior que o elemento da lista... 
                        anterior = aux; // anterior = aux. Anterior recebe o endereço do elemento da lista. 
                        aux = aux.prox; // aux = aux.prox. Aux recebe o endereço do proximo elemento da lista.
                    } //encerra o laço while. 
                    if (anterior == null) { // se anterior = null. Anterior não tem valor inicialmente.
                        novo.prox = inicio; // novo.prox = inicio. Novo recebe o endereço do primeiro elemento da lista.
                        inicio = novo; // inicio = novo. Inicio recebe o endereço do novo elemento da lista.
                    } else if (aux == null) { // se aux = null. Aux não tem valor inicialmente.
                        fim.prox = novo; // fim.prox = novo. Fim recebe o endereço do novo elemento da lista.
                        fim = novo; // fim = novo. Fim recebe o endereço do novo elemento da lista.
                        fim.prox = null; // fim.prox = null. Fim recebe null.
                    } else { // se anterior != null. Anterior tem valor inicialmente.
                        anterior.prox = novo; // anterior.prox = novo. Anterior recebe o endereço do novo elemento da lista.
                        novo.prox = aux; // novo.prox = aux. Novo recebe o endereço do proximo elemento da lista.
                    }
                    System.out.println("Elemento inserido com sucesso!");
                }
            }

            if (op == 2) {
                if (inicio == null) {
                    System.out.println("Lista vazia!");
                } else {
                    aux = inicio;
                    while (aux != null) {
                        System.out.println("Elemento: " + aux.num);
                        aux = aux.prox;
                    }
                }
            }

            if (op == 3) {
                if (inicio == null) {
                    System.out.println("Lista vazia!");
                } else {
                    System.out.print("Digite o número que deseja remover: ");
                    numero = entrada.nextInt();

                    aux = inicio;
                    anterior = null;
                    achou = 0;

                    while (aux != null) {
                        if (aux.num == numero) {
                            achou = achou + 1;
                            
                            if (aux == inicio) {
                                inicio = aux.prox;
                                aux = inicio;
                            } else if (aux == fim) {
                                anterior.prox = null;
                                fim = anterior;
                                aux = null;
                            } else {
                                anterior.prox = aux.prox;
                                aux = aux.prox;
                            }
                        } else {
                            anterior = aux;
                            aux = aux.prox;
                        }
                    }
                    if (achou == 0) {
                        System.out.println("Número não encontrado");
                    } else if (achou == 1) {
                        System.out.println("Elemento removido com sucesso!");
                    } else {
                        System.out.println("Elementos removido" + achou + " vezes!");
                    }
                }
            }

            if (op == 4) {
                if (inicio == null) {
                    System.out.println("Lista vazia!");
                } else {
                    inicio = null;
                    System.out.println("Lista esvaziada com sucesso!");
                }
            }
        } while (op != 5);

        entrada.close();
    }
}
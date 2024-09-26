package listaSimples;

/* Lista simplesmesnte encadeada e não ordenada.
 * 
 *  cada elemento armazena um ou vários dados. (estrutura homogênea ou heterogênea).
 *  e um ponteiro para o proximo elemento, que permite o encadeamento e mantém a estrutura linear. 
 *  
 *  Nesse tipo de lista, serão abordadas as seguintes operações:
 *      
 *      inserir no início da lista
 *        
 *      consultar toda a lista
 *   
 *      remover um elemento qualquer  
 * 
 *      esvaziar a lista.
*/

import java.util.*;

public class LS_Nao_Ordenada {
    
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

            System.out.println("1 - Inserir no início da lista");

            System.out.println("2 - Inserir no fim da lista");

            System.out.println("3 - Consultar toda a lista");

            System.out.println("4 - Remover um elemento qualquer");

            System.out.println("5 - Esvaziar a lista");

            System.out.println("6 - Sair");

            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();

            if (op < 1 || op > 6) {
                System.out.println("Opção inválida");
            }

            if (op == 1) {
                System.out.println("Digite um número: ");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } else {
                    novo.prox = inicio;
                    inicio = novo;
                }
                System.out.println("Número inserido na lista!");
            }
                
            if (op == 2) {
                System.out.print("Digite um número para ser inserido ao fim da lista: ");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();

                if (inicio == null ) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } else {
                    fim.prox = novo;
                    fim = novo;
                    fim.prox = null;
                }

                System.out.println("Número inserido no fim da lista!");
            }

            if (op == 3) {
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    System.out.println("Lista: ");
                    aux = inicio;

                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                    }
                }
            }

            if (op == 4) {
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    System.out.println("Digite o número que deseja remover: ");
                    numero = entrada.nextInt();

                    aux = inicio;
                    anterior = null;
                    achou = 0; 

                    while (aux != null) {
                        if (aux.num == numero) {
                            achou += 1;
                            if (aux == inicio) 
                            {
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
                        System.out.println("Número não encontrado na lista");
                    } else if (achou == 1) {
                        System.out.println("Numero removido da lista 1 vez");
                    } else {
                        System.out.println("Numero removido da lista " + achou + " vezes");
                    }
                }
            }

            if (op == 5) {
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    inicio = null;
                    fim = null;
                    System.out.println("Lista esvaziada");
                }
            }

            if (op == 6) {
                System.out.println("SAINDO..");
                System.exit(0);
            }

        } while (op >=1 && op <=6);
        entrada.close();
    }
}

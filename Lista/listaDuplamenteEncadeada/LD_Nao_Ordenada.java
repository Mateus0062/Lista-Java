package listaDuplamenteEncadeada;

import java.util.Scanner;

public class LD_Nao_Ordenada {
    private static class LISTA {
        public int num;
        public LISTA prox;
        public LISTA ant;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        LISTA inicio = null; // A lista está vazia, logo, o objeto inicio tem o valor nulo.
        LISTA fim = null; // O objeto fim conterá o endereço do último elemento da lista.

        LISTA aux;

        int op, numero, achou; 

        do {
            System.out.println("\nMENU DE OPÇÕES\n");

            System.out.println("1 - Inserir no início da lista.");

            System.out.println("2 - Inserir no fim da lista.");

            System.out.println("3 - Consultar toda a lista.");

            System.out.println("4 - Consultar a lista do fim ao inicio.");

            System.out.println("5 - Remover um elemento qualquer.");

            System.out.println("6 - Esvaziar a lista.");

            System.out.println("7 - Sair.");

            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();

            if (op < 1 || op > 7) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            if (op == 1) {
                System.out.print("Digite o número a ser inserido no início da lista: ");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                    novo.ant = null;
                } else { 
                    novo.prox = inicio;
                    inicio.ant = novo; 
                    novo.ant = null;
                    inicio = novo;
                }
                System.out.println("Número inserido no início da lista.");
            }

            if (op == 2) {
                System.out.print("Digite o número a ser inserido no fim da lista: ");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                    novo.ant = null;
                } else {
                    fim.prox = novo;
                    novo.ant = fim;
                    novo.prox = null;
                    fim = novo;
                }

                System.out.println("Número inserido no fim da lista.");
            }

            if (op == 3) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    System.out.print("\nConsultando a lista\n");
                    aux = inicio;

                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                    }
                }
            }

            if (op == 4) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    System.out.print("\nConsultando a lista do fim ao início\n");
                    aux = fim;

                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.ant;
                    }
                }
            }

            if (op == 5) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    System.out.print("Digite o número que deseja remover da lista: ");
                    numero = entrada.nextInt();
                    aux = inicio;
                    achou = 0; 

                    while (aux != null) {
                        if (aux.num == numero) {
                            achou += 1;

                            if (aux == inicio) {
                                inicio = aux.prox;
                                if (inicio != null) {
                                    inicio.ant = null;
                                }
                                aux = inicio;
                            } else if (aux == fim) {
                                fim = fim.ant;
                                fim.prox = null;
                                aux = null;
                            } else {
                                aux.ant.prox = aux.prox;
                                aux.prox.ant = aux.ant;
                                aux = aux.prox;
                            }
                        } else {
                            aux = aux.prox;
                        }
                    }
                    if (achou == 0) {
                        System.out.println("Número inexistente na lista.");
                    } else if (achou == 1) {
                        System.out.println("Número removido 1 vez da lista.");
                    } else {
                        System.out.println("Número removido " + achou + " vezes da lista.");
                    }
                }
            }

            if (op == 6) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    inicio = null;
                    System.out.println("Lista esvaziada.");
                }
            }

            if (op == 7) {
                System.out.println("Programa encerrado.");
                System.exit(0);
            }
        } while (op != 7);       
        entrada.close();
    }
}
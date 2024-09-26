package listaDuplamenteEncadeada;

import java.util.Scanner;

public class LD_Ordenada {

    private static class LISTA {
        public int num;
        public LISTA prox;
        public LISTA ant;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LISTA inicio = null;
        LISTA fim = null;
        LISTA aux;

        int op, achou, numero;

        do {
            System.out.println("\nMENU DE OPÇÕES\n");

            System.out.println("1 - Inserir na lista.");

            System.out.println("2 - Consultar toda a lista.");

            System.out.println("3 - Consultar a lista do fim ao inicio.");

            System.out.println("4 - Remover da lista.");

            System.out.println("5 - Esvaziar a lista.");

            System.out.println("6 - Sair.");

            System.out.print("Digite sua opção: ");
            op = sc.nextInt();

            if (op == 1) {
                System.out.print("Digite um número: ");
                LISTA novo = new LISTA();

                novo.num = sc.nextInt();

                if (inicio == null) {
                    inicio = novo; 
                    fim = novo;
                    novo.prox = null;
                    novo.ant = null;
                } else {
                    aux = inicio;

                    while (aux != null && novo.num > aux.num) {
                        aux = aux.prox;
                    }

                    if (aux == inicio) {
                        novo.prox = inicio;
                        novo.ant = null;
                        inicio.ant = novo;
                        inicio = novo;
                    } else if (aux == null) {
                        fim.prox = novo;
                        novo.ant = fim;
                        fim = novo;
                        fim.prox = null;
                    } else {
                        novo.prox = aux;
                        aux.ant.prox = novo;
                        novo.ant = aux.ant;
                        aux.ant = novo;
                    }
                    System.out.println("número inserido na lista!");
                }
            } 

            if (op == 2) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    aux = inicio;

                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                    }
                }
            }

            if (op == 3) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    System.out.println("Consultando a lista do fim ao início...");

                    aux = fim;

                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.ant;
                    }
                }
            }

            if (op == 4) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    System.out.print("Digite o número que deseja remover da lista: ");
                    numero = sc.nextInt();

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
                                fim = aux.ant;
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
                        System.out.println("número removido 1 vez da lista.");
                    } else {
                        System.out.println("números removidos " + achou + " vezes da lista.");
                    }
                }
            }

            if (op == 5) {
                if (inicio == null) {
                    System.out.println("A lista está vazia.");
                } else {
                    inicio = null;
                    System.out.println("A lista foi esvaziada.");
                }
            }

            if (op == 6) {
                System.out.println("PROGRAMA FINALIZADO.");
                System.exit(0);
            }

        } while (op != 6);




        sc.close();
    }


}
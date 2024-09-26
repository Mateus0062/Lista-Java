package exLista;

import java.util.Scanner;

public class ex005 {
    
    public static class LISTA_PAR {
        public int num;
        public LISTA_PAR prox;
    }

    public static class LISTA_IMPAR {
        public int num;
        public LISTA_IMPAR prox;
    }

    public static class LISTA {
        public int num;
        public LISTA prox;
        public LISTA ant;
    }
    
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = 0;      
        
        LISTA_PAR inicio_par = null;
        LISTA_PAR fim_par = null;
        LISTA_PAR aux_par;

        LISTA_IMPAR inicio_impar = null;
        LISTA_IMPAR fim_impar = null;
        LISTA_IMPAR aux_impar;
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um número: ");
            numero = sc.nextInt();

            if (numero % 2 == 0) {
                LISTA_PAR novo_par = new LISTA_PAR();
                novo_par.num = numero;
                
                if (inicio_par == null) {
                    inicio_par = novo_par;
                    fim_par = novo_par;
                    novo_par.prox = null;
                } else {
                    novo_par.prox = inicio_par;
                    inicio_par = novo_par;
                }
            } else {
                LISTA_IMPAR novo_impar = new LISTA_IMPAR();
                novo_impar.num = numero;

                if (inicio_impar == null) {
                    inicio_impar = novo_impar;
                    fim_impar = novo_impar;
                    novo_impar.prox = null;
                } else {
                    novo_impar.prox = inicio_impar;
                    inicio_impar = novo_impar;
                }
            }
        }

        
        //código para mostrar números pares e ímpares que foram inseridos nas duas listas.
        
        if (inicio_par == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("\nNúmeros pares: ");
            aux_par = inicio_par;

            while (aux_par != null) {
                System.out.println(aux_par.num + " ");
                aux_par = aux_par.prox;
            }
        }

        if (inicio_impar == null) {
            System.out.println("A lista está vazia");
        } else {
            System.out.println("\nNúmeros ímpares: ");
            
            aux_impar = inicio_impar;

            while (aux_impar != null) {
                System.out.println(aux_impar.num + " ");
                aux_impar = aux_impar.prox;
            }
        }

        //juntar as duas listas em uma lista só.

        LISTA inicio = null;
        LISTA fim = null;
        LISTA aux;
        LISTA anterior = null;

        aux_par = inicio_par;

        while (aux_par != null) {
            LISTA novo = new LISTA();

            novo.num = aux_par.num;

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
                aux_par = aux_par.prox;
            }
        }

        sc.close();
    }
}
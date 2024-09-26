package exLista;

import java.util.Scanner;

public class ex003 {
    private static class ALUNO {
        public String nome;
        public double nota;
        public ALUNO prox;
        @SuppressWarnings("unused")
        public ALUNO ant;   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ALUNO inicio = null;
        ALUNO fim = null;
        ALUNO aux;

        System.out.println("\nSISTEMA ESCOLAR DE NOTAS\n");

        for (int i = 0; i < 5; i++) {
            
            ALUNO novo = new ALUNO();
            
            System.out.print("Digite o nome do aluno: ");
            novo.nome = sc.next();
            
            System.out.print("Digite a nota do aluno: ");
            novo.nota = sc.nextDouble();

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
        }

        if (inicio == null) {
            System.out.println("Lista vazia");
        } else {
            aux = inicio;
            while (aux != null) {
                if (aux.nota >= 7) {
                    System.out.println("Aluno aprovado: " + aux.nome + " Nota: " + aux.nota);
                }
                aux = aux.prox;
            }
        }

        sc.close();
    }
}

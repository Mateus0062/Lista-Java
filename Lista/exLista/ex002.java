package exLista;

import java.util.Scanner;

public class ex002 {
    private static class FUNCIONARIO {
        public String nome;
        public double salario;
        public FUNCIONARIO prox;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FUNCIONARIO inicio = null; // A lista está vazia, logo, o objeto inicio tem o valor nulo.
        FUNCIONARIO fim = null; // O objeto fim conterá o endereço do último elemento da lista.
        FUNCIONARIO aux; // auxiliar1.
        FUNCIONARIO anterior;

        double maior_salario = 0;
        double media = 0;
        double tot = 0;

        System.out.println("\nLISTA DE FUNCIONÁRIOS\n");

        System.out.println("\nparte 1 - cadastrar 8 funcionários na lista\n");

        for (int i = 0; i < 8; i++) {
            FUNCIONARIO func = new FUNCIONARIO();
            
            System.out.print("Digite o nome do funcionário: ");
            func.nome = sc.next();

            System.out.print("Digite o salário do funcionário: ");
            func.salario = sc.nextDouble();

            tot += func.salario;

            if (inicio == null) {
                inicio = func;
                func.prox = null;
                fim = func;
            } else {
                anterior = null;
                aux = inicio;

                while (aux != null && aux.salario < func.salario) {
                    anterior = aux;
                    aux = aux.prox;
                }

                if (anterior == null) {
                    func.prox = inicio;
                    inicio = func;
                } else if (aux == null) {
                    fim.prox = func;
                    fim = func;
                    fim.prox = null;
                } else {
                    anterior.prox = func;
                    func.prox = aux;
                }
            }
        }

        aux = inicio;
        
        while (aux != null) {
            if (aux.salario > maior_salario) {
                maior_salario = aux.salario;
            }
            aux = aux.prox; // Avança para o próximo funcionário na lista
        }

        System.out.println("\nFuncionário(s) com o maior salário (" + maior_salario + "):");
        aux = inicio;
        while (aux != null) {
            if (aux.salario == maior_salario) {
                System.out.println(aux.nome);
            }
            aux = aux.prox;
        }

        //media salarial
        media = tot / 8;
        System.out.println("\nMedia salarial: " + media);

        //quantidade de funcionários com salário superior a um valor estabelecido
        System.out.print("Digite um valor para consultar: ");
        double valor = sc.nextDouble();

        aux = inicio;
        int cont = 0;
        while (aux != null) {
            if (aux.salario > valor) {
                cont++;
            }
            aux = aux.prox;
        }
        System.out.println("\nQuantidade de funcionários com salário superior a " + valor + ": " + cont);

        sc.close();
    }
}
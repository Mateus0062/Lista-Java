package exLista;

import java.util.Scanner;

public class ex004 {
    private static class FUNCIONARIO {
        public String nome;
        public double salario;
        public FUNCIONARIO prox;
        public FUNCIONARIO ant;
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCadastro de funcionários\n");

        FUNCIONARIO inicio = null;
        FUNCIONARIO fim = null;
        FUNCIONARIO aux;
        
        for (int i = 0; i < 6; i++) {
           FUNCIONARIO novo = new FUNCIONARIO();

           System.out.print("Digite o nome do funcionário: ");
           novo.nome = sc.next().toUpperCase();

           System.out.print("Digite o salário do funcionário: ");
           novo.salario = sc.nextDouble();

           if (inicio == null) {
               inicio = novo;
               fim = novo;
               novo.prox = null;
               novo.ant = null;
           } else {
               aux = inicio;

                while (aux != null && novo.salario > aux.salario) {
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
           }
        }

        //O PROGRAMA MOSTRA O NOME, VALOR DO IMPOSTO E O VALOR A RECEBER.
        
        aux = inicio;
        while (aux != null) {   
            if (aux.salario <= 850) {
                
                System.out.println("\n" + aux.nome + " - Salário a receber: R$" + aux.salario);
            
            } else if (aux.salario > 850 && aux.salario <= 1200) {
                
                System.out.println("\n" + aux.nome + " - Salário bruto: R$" + aux.salario);
                
                System.out.println("valor do desconto: " + (aux.salario * 0.1));
                
                aux.salario = aux.salario - (aux.salario * 0.1);
                
                System.out.println("Salário a receber R$: " + aux.salario + "\n");
            } else {
                System.out.println("\n" + aux.nome + " - Salário bruto: R$" + aux.salario);
                
                System.out.println("valor do desconto: " + (aux.salario * 0.2));
                
                aux.salario = aux.salario - (aux.salario * 0.2);
                
                System.out.println("Salário a receber R$: " + aux.salario + "\n");
            }
            aux = aux.prox;
        }
        

        /*O PROGRAMA MOSTRA OS NOMES E OS SALÁRIOS DOS FUNCIONÁRIOS CUJOS NOMES
        INICIAM COM UMA LETRA DIGITADA PELO USUÁRIO.*/

        int opcao = 0;
        
        do {
            System.out.println("1 - Sim");
            System.out.println("2 - Sair");
            
            System.out.print("Deseja saber o nome e o salário de qual funcionário? ");
            opcao = sc.nextInt();
            
            
            if (opcao == 1) {
                System.out.print("Digite uma letra para saber o nome e o salário dos funcionários: ");
                char letra = sc.next().toUpperCase().charAt(0);
    
                aux = inicio;
                while (aux != null) {
                    if (aux.nome.charAt(0) == letra) {
                        System.out.println("\n" + aux.nome + ": R$" + aux.salario);
                    }
                    aux = aux.prox;
                }
            }

            if (opcao == 2) {
                break;
            }

        } while (opcao >= 1 || opcao <= 2);

        /*O PROGRAMA DEVE APRESENTAR DUAS LISTAGENS. 
            1 - DOS NOMES E SALÁRIOS DOS FUNCIONÁRIOS POR ORDEM CRESCENTE DE SALÁRIO
            2 - DOS NOMES E SALÁRIOS DOS FUNCIONÁRIOS POR ORDEM DECRESCENTE DE SALÁRIO.
        */

        System.out.println("\nListagem dos funcionários por ordem crescente de salário: ");
        
        aux = inicio;
        while (aux != null) {
            System.out.println("\n" + aux.nome + ": R$" + aux.salario);
            aux = aux.prox;
        } 

        System.out.println("\nListagem dos funcionários por ordem decrescente de salário: ");

        aux = fim;
        while (aux != null) {
            System.out.println("\n" + aux.nome + ": R$" + aux.salario);
            aux = aux.ant;
        }

        sc.close();
    }
}
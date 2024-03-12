
/*
 * Aluno: Lucas Martins de Oliveira
 * Instituição: Centro Univercitário Alfredo Nasser
 * Trabalho de Estrutura de Dados - Árvore Binária
 * Professor Ricardo Vilaverde
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        Scanner sc = new Scanner(System.in);
        Integer menuAux;
        Boolean rodando = true;

        while (rodando) {
            System.out.println("\nSelecione uma opção:"
                    + "\n1) Adicionar Nó"
                    + "\n2) Buscar Nó"
                    + "\n3) Excluir Nó"
                    + "\n4) Pesquisa na Arvóre"
                    + "\n0) Sair do programa");
            menuAux = sc.nextInt();

            switch (menuAux) {
                case 1:
                    System.out.println("\nDigite o valor do nó inserido: ");
                    menuAux = sc.nextInt();
                    arvoreBinaria.inserir(menuAux);
                    break;
                case 2:
                    System.out.println("\nDigite o valor do nó buscado: ");
                    menuAux = sc.nextInt();
                    boolean contemValor = arvoreBinaria.contemValor(menuAux);

                    Runnable trueAction = () -> System.out.println("A árvore contém o valor digitado");
                    Runnable falseAction = () -> System.out.println("A árvore NÃO contém o valor digitado");

                    Runnable action = contemValor ? trueAction : falseAction;
                    action.run();
                    break;
                case 3:
                    System.out.println("\nDigite o valor do nó excluido: ");
                    menuAux = sc.nextInt();
                    arvoreBinaria.excluir(menuAux);
                    break;
                case 4:
                    arvoreBinaria.emOrdem();
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    break;
            }
        }
    }
}

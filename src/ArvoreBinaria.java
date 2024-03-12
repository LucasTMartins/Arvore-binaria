public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirRecursivo(atual.direito, valor);
        } else {
            // Valor já existe
            return atual;
        }

        return atual;
    }

    public boolean contemValor(int valor) {
        //Buscando nó específico
        return contemValorRecursivo(raiz, valor);
    }

    private boolean contemValorRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        return valor < atual.valor
                ? contemValorRecursivo(atual.esquerdo, valor)
                : contemValorRecursivo(atual.direito, valor);
    }

    public void excluir(int valor) {
        //buscando e excluindo nó com valor específico
        raiz = excluirRecursivo(raiz, valor);
    }

    private No excluirRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.valor) {
            // Nó a ser excluído encontrado
            if (atual.esquerdo == null && atual.direito == null) {
                // Nó é uma folha
                return null;
            } else if (atual.esquerdo == null) {
                // Nó tem um filho à direita
                return atual.direito;
            } else if (atual.direito == null) {
                // Nó tem um filho à esquerda
                return atual.esquerdo;
            } else {
                // Nó tem dois filhos
                int menorValor = encontrarMenorValor(atual.direito);
                atual.valor = menorValor;
                atual.direito = excluirRecursivo(atual.direito, menorValor);
                return atual;
            }
        }
        if (valor < atual.valor) {
            atual.esquerdo = excluirRecursivo(atual.esquerdo, valor);
            return atual;
        }
        atual.direito = excluirRecursivo(atual.direito, valor);
        return atual;
    }

    private int encontrarMenorValor(No raiz) {
        return raiz.esquerdo == null ? raiz.valor : encontrarMenorValor(raiz.esquerdo);
    }

    public void emOrdem() {
        //Exibindo todos os nós da arvóre
        System.out.println("\nTravessia Em Ordem:");
        emOrdemRecursivo(raiz);
        System.out.println("\n------------------------");
    }

    private void emOrdemRecursivo(No atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerdo);
            System.out.print(atual.valor + " ");
            emOrdemRecursivo(atual.direito);
        }
    }
}

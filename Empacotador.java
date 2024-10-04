import java.util.List;

/**
 * Classe que traz a lógica do algoritmo de "ensacolamento" dos produtos.
 * <br><br>
 * O empacotador pega produtos do monte de um caixa e coloca em sacolas, respeitando as regras.
 *
 * @author Jean Cheiran
 * @version 1.0
 */
public class Empacotador {

    public int proximoCaixa = 1; // usada para saber para onde o empacotador deve ir
    private final int PESO_MINIMO = 1000; // 1kg para o despacho de sacolas

    /**
     * Executa a lógica de empacotamento e troca de caixa.
     * Esse método é o único método de controle invocado durante a simulação
     * do supermercado.
     * @param caixa o caixa onde está o empacotador
     * @param fiscal fiscal que pode ser consultado sobre as sacolas despachadas
     */
    public void agir(Caixa caixa, Fiscal fiscal) {
        // Pega o monte de produtos no caixa
        Produto[] produtosNoMonte = caixa.getArrayDoMonte();

        // Itera pelos produtos no monte e tenta empacotá-los
        for (Produto produto : produtosNoMonte) {
            boolean produtoEmpacotado = false;

            // Tenta colocar o produto em uma sacola existente
            for (int i = 0; i < Caixa.QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
                Sacola sacola = caixa.getSacola(i + 1);
                if (sacola != null && verificarCompatibilidade(sacola, produto)) {
                    // Verifica se o produto já está na sacola usando hashCode
                    if (!produtoJaNaSacola(sacola, produto)) {
                        sacola.colocarProdutoNaSacola(produto); // Adiciona o produto à sacola
                        caixa.pegarProdutoDoMonte(produto); // Remove o produto do monte
                        produtoEmpacotado = true;
                    }
                    break; // Produto empacotado, pode sair do loop de sacolas
                }
            }

            // Se o produto não couber em nenhuma sacola existente, cria uma nova
            if (!produtoEmpacotado) {
                Sacola novaSacola = caixa.getSacola(getIndiceSacolaVazia(caixa)); // Pega uma nova sacola vazia
                if (novaSacola != null) {
                    novaSacola.colocarProdutoNaSacola(produto); // Adiciona o produto à nova sacola
                    caixa.pegarProdutoDoMonte(produto); // Remove o produto do monte
                }
            }
        }

        // Despacha sacolas que têm pelo menos 1kg
        despacharSacolas(caixa, fiscal);

        // Atualiza o próximo caixa
        proximoCaixa = (proximoCaixa % Supermercado.QUANTIDADE_DE_CAIXAS_NO_SUPERMERCADO) + 1;
    }

    /**
     * Despacha as sacolas que atingiram o peso mínimo de 1kg.
     */
    private void despacharSacolas(Caixa caixa, Fiscal fiscal) {
        for (int i = 0; i < Caixa.QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
            Sacola sacola = caixa.getSacola(i + 1);
            if (sacola != null) {
                int pesoTotal = calcularPesoTotal(sacola);
                if (pesoTotal >= PESO_MINIMO) {
                    fiscal.despachar(sacola); // Despacha sacola
                    caixa.despacharSacola(i + 1); // Remove a sacola do caixa
                    caixa.reporSacolas(); // Garante que as sacolas despachadas sejam repostas
                }
            }
        }
    }

    /**
     * Verifica se o produto é compatível com os outros produtos da sacola.
     * Usa o método getArrayDaSacola() da classe Sacola.
     */
    private boolean verificarCompatibilidade(Sacola sacola, Produto produto) {
        Produto[] produtosNaSacola = sacola.getArrayDaSacola();

        for (Produto p : produtosNaSacola) {
            // Verifica se os produtos são compatíveis entre si
            if (!saoProdutosCompatíveis(p, produto)) {
                return false; // Produtos de categorias diferentes são incompatíveis
            }
        }
        return true; // Produto compatível
    }

    /**
     * Verifica se dois produtos são compatíveis.
     * Essa verificação pode ser feita usando instanceof para verificar a categoria do produto.
     */
    private boolean saoProdutosCompatíveis(Produto p1, Produto p2) {
        // Alimentos, Perecíveis e Não Perecíveis podem ser misturados entre si
        if ((p1 instanceof Alimenticio || p1 instanceof Perecivel || p1 instanceof NaoPerecivel) &&
                (p2 instanceof Alimenticio || p2 instanceof Perecivel || p2 instanceof NaoPerecivel)) {
            return true; // Produtos alimentícios podem ser misturados
        }

        // Produtos de Limpeza não podem ser misturados com Alimentícios
        if (p1 instanceof Limpeza && p2 instanceof Alimenticio) {
            return false;
        }
        if (p2 instanceof Limpeza && p1 instanceof Alimenticio) {
            return false;
        }

        // Refrigerados só podem ser misturados com outros Refrigerados
        if (p1 instanceof Refrigerado && !(p2 instanceof Refrigerado)) {
            return false;
        }
        if (p2 instanceof Refrigerado && !(p1 instanceof Refrigerado)) {
            return false;
        }

        // Produtos Eletroeletrônicos devem ser embalados sozinhos
        if (p1 instanceof Eletroeletronico || p2 instanceof Eletroeletronico) {
            return false; // Produtos eletroeletrônicos não podem ser misturados
        }

        // Se chegou aqui, os produtos são considerados compatíveis
        return true;
    }

    /**
     * Calcula o peso total dos produtos na sacola.
     * Usa o método getArrayDaSacola() da classe Sacola.
     */
    private int calcularPesoTotal(Sacola sacola) {
        Produto[] produtosNaSacola = sacola.getArrayDaSacola();
        int pesoTotal = 0;

        for (Produto produto : produtosNaSacola) {
            pesoTotal += produto.getPeso();
        }

        return pesoTotal;
    }

    /**
     * Verifica se um produto já está na sacola usando hashCode.
     * @param sacola a sacola onde o produto está sendo verificado
     * @param produto o produto a ser verificado
     * @return true se o produto já está na sacola, false caso contrário
     */
    private boolean produtoJaNaSacola(Sacola sacola, Produto produto) {
        Produto[] produtosNaSacola = sacola.getArrayDaSacola();
        for (Produto p : produtosNaSacola) {
            if (p.hashCode() == produto.hashCode()) {
                return true; // Produto já está na sacola
            }
        }
        return false;
    }

    /**
     * Encontra o índice de uma sacola vazia no caixa.
     * @param caixa o caixa onde as sacolas são procuradas
     * @return o índice de uma sacola vazia ou -1 se não houver
     */
    private int getIndiceSacolaVazia(Caixa caixa) {
        for (int i = 0; i < Caixa.QUANTIDADE_DE_SACOLAS_NO_CAIXA; i++) {
            if (caixa.getSacola(i + 1) != null && caixa.getSacola(i + 1).contarProdutosNaSacola() == 0) {
                return i + 1;
            }
        }
        return -1; // Não encontrou sacolas vazias
    }
}

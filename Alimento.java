/**
 * Classe que representa um Alimento, que é um tipo de Perecível.
 */
public class Alimenticio extends Produto {
    private long validade;

    /**
     * Construtor para a classe Alimento.
     *
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param fabricante Fabricante do produto.
     * @param peso Peso do produto em gramas.
     * @param validade Validade do alimento em dias.
     */
    public Alimenticio(int codigo, String nome, String fabricante, int peso, long validade) {
        super(codigo, nome, fabricante, peso);
        this.validade = validade;
    }

    public long getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return "Alimento{" + super.toString() + ", validade=" + validade + " dias}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Long.hashCode(validade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Alimenticio alimento = (Alimenticio) o;
        return validade == alimento.validade;
    }
}

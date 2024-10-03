/**
 * Classe que representa um produto Perecível.
 */
public class Perecivel extends Alimenticio {

    /**
     * Construtor para a classe Perecivel.
     *
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param fabricante Fabricante do produto.
     * @param peso Peso do produto em gramas.
     */



    public Perecivel(int codigo, String nome, String fabricante, int peso, long validade) {
        super(codigo, nome, fabricante, peso, validade);
    }

    @Override
    public String toString() {
        return "Perecivel{" + super.toString() + "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

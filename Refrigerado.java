/**
 * Classe que representa um Alimento Refrigerado, que é um tipo de Alimento.
 */
public class Refrigerado extends Alimento {
    private int temperaturaIdeal;

    /**
     * Construtor para a classe Refrigerado.
     *
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param fabricante Fabricante do produto.
     * @param peso Peso do produto em gramas.
     * @param validade Validade do alimento em dias.
     * @param temperaturaIdeal Temperatura ideal de armazenamento em graus Celsius.
     */
    public Refrigerado(int codigo, String nome, String fabricante, int peso, long validade, int temperaturaIdeal) {
        super(codigo, nome, fabricante, peso, validade);
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public int getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    @Override
    public String toString() {
        return "Refrigerado{" + super.toString() + ", temperaturaIdeal=" + temperaturaIdeal + "°C}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Integer.hashCode(temperaturaIdeal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Refrigerado that = (Refrigerado) o;
        return temperaturaIdeal == that.temperaturaIdeal;
    }
}

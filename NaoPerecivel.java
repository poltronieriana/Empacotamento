/**
 * Classe que representa um produto Não Perecível.
 */
public class NaoPerecivel extends Alimenticio {
    private String tipoDeArmazenamento;

    /**
     * Construtor para a classe NaoPerecivel.
     *
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param fabricante Fabricante do produto.
     * @param peso Peso do produto em gramas.
     * @param tipoDeArmazenamento Tipo de armazenamento do produto.
     */
    public NaoPerecivel(int codigo, String nome, String fabricante, int peso, long validade, String tipoDeArmazenamento) {
        super(codigo, nome, fabricante, peso, validade);
        this.tipoDeArmazenamento = tipoDeArmazenamento;
    }

    public String getTipoDeArmazenamento() {
        return tipoDeArmazenamento;
    }

    @Override
    public String toString() {
        return "NaoPerecivel{" + super.toString() + ", tipoDeArmazenamento=" + tipoDeArmazenamento + "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + tipoDeArmazenamento.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        NaoPerecivel that = (NaoPerecivel) o;
        return tipoDeArmazenamento.equals(that.tipoDeArmazenamento);
    }
}

/**
 * Classe que representa um produto Eletroeletrônico, que é um tipo de Não Perecível.
 */
public class Eletroeletronico extends NaoPerecivel {
    private short tensao;

    /**
     * Construtor para a classe Eletroeletronico.
     *
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param fabricante Fabricante do produto.
     * @param peso Peso do produto em gramas.
     * @param tipoDeArmazenamento Tipo de armazenamento do produto.
     * @param tensao Tensão elétrica (110V, 220V).
     */
    public Eletroeletronico(int codigo, String nome, String fabricante, int peso, String tipoDeArmazenamento, short tensao) {
        super(codigo, nome, fabricante, peso, tipoDeArmazenamento);
        this.tensao = tensao;
    }

    public short getTensao() {
        return tensao;
    }

    @Override
    public String toString() {
        return "Eletroeletronico{" + super.toString() + ", tensao=" + tensao + "V}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Short.hashCode(tensao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Eletroeletronico that = (Eletroeletronico) o;
        return tensao == that.tensao;
    }
}

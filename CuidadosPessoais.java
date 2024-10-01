public class CuidadosPessoais extends Produto{

    private long validade;
    private String fragrancia;

    public CuidadosPessoais(int codigo, String nome, String fabricante, int peso, long validade, String fragrancia) {
        super(codigo, nome, fabricante, peso);
        this.validade = validade;
        this.fragrancia = fragrancia;
    }
    public long getValidade() {
        return validade;
    }
    public String getFragrancia() {
        return fragrancia;
    }
    public String toString() {
        return "CuidadosPessoais [validade=" + validade +
                ", fragrancia=" + fragrancia + "]";
    }
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(validade);
        result = prime * result + ((fragrancia == null) ? 0 : fragrancia.hashCode());
        return result;
    }
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if(o instanceof CuidadosPessoais other){
            if(this.validade == other.validade){
                return this.fragrancia.equals(other.fragrancia);
            }
        }
        return false;
    }
}

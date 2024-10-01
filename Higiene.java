public class Higiene extends CuidadosPessoais {

    public Higiene(int codigo, String nome, String fabricante, int peso, long validade, String fragrancia) {
        super(codigo, nome, fabricante, peso, validade, fragrancia);
    }
    public String toString() {
        return "Higiene " + super.toString();
    }
    public int hashCode(){
        return super.hashCode();
    }
    public boolean equals(Object otherHigiene) {
        if (!(otherHigiene instanceof Higiene)) {
            return false;
        }
        return false;
    }
}

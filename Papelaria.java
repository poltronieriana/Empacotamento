public class Papelaria extends Produto{
    private short tensao;
    public Papelaria(int codigo, String nome, String fabricante, int peso) {
        super(codigo, nome, fabricante, peso);
    }

    public String toString() {
        return "Papelaria [tensao=" + tensao + "]";
    }

    public int hashCode(){
        return super.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        return false;
    }
}

public class Limpeza extends Produto {
    public Limpeza(int codigo, String nome, String fabricante,int peso) {
        super(codigo, nome, fabricante, peso);
    }
    public String toString() {
        return super.toString();
    }
    public int hashCode(){
        return super.hashCode();
    }
    public boolean equals(Object obj){
        return super.equals(obj);
    }

}

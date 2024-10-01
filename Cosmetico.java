public class Cosmetico extends CuidadosPessoais{
    private char tipoDePele;

    public Cosmetico(int codigo, String nome, String fabricante, int peso,long validade, String fragrancia, char tipoDePele){
       super( codigo,  nome,  fabricante,  peso, validade, fragrancia);
       this.tipoDePele = tipoDePele;
    }
    public String toString(){
        return super.toString() + "\nTipo de Pele: " + tipoDePele;
    }
    public int hashCode(){
        return super.hashCode();
    }
    public boolean equals(Object o){
        if(o instanceof Cosmetico){
            Cosmetico c = (Cosmetico)o;
            return super.equals(c);
        }
        return false;
    }
}

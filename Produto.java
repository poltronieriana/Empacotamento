package estudantes.entidades;

/**
 * Classe que define um produto no supermercado.
 * <br><br>
 * Essa classe pode ser estendida. Adicionalmente, ela deve:
 * <br><br>
 * 1) ter um construtor completo,<br>
 * 2) implementar métodos de acesso (getters), sendo que métodos de modificação
 * (setters) NÃO devem ser implementados,<br>
 * 3) sobre-escrever os métodos toString, equals e hashCode,<br>
 * 4) ter um JavaDoc útil e completo.
 * <br><br>
 * <strong>Não devem ser criados métodos adicionais nessa classe.</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Produto {
    private int codigo;
    private String nome;
    private String fabricante;
    private int peso;
    public Produto(int codigo, String nome, String fabricante, int peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.peso = peso;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public int getPeso() {
        return peso;
    }
    @Override
    public String toString() {
        return return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome=" + nome + '\'' +
                ", fabricante=" + fabricante + '\'' +
                ", peso=" + peso +
                '}';
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
        result = prime * result + peso;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
            //qualquer coisa é diferente de NULL
            if(outro == null){
                return false;
            }
            //propriedade REFLEXIVA
            if(this == outro){
                return true;
            }
            //objetos de classes diferentes nunca são iguais
            if(this.getClass() != outro.getClass()){
                return false;
            }
            //conversão explícita para acessar os atributos do outro carro
            Carro outroCarro = (Carro) outro;
            //verifica se todos os atributos são iguais
            if(this.nome.equals(outroProduto.nome) && this.fabricante.equals(outroProduto.fabricante)
                    && this.codigo == codigo && this.peso == peso){
                return true;
            }else{
                return false;
            }
        }
    }

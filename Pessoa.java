abstract class Pessoa{
    protected String nome;
    protected int id;
    
    public Pessoa(String name, int id){
        this.nome = name;
        this.id = id;
    }
    
    //Aplicando polimorfismo
    public abstract void exibirInfo();
}
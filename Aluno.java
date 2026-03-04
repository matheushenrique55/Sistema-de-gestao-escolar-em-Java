import java.util.ArrayList;
import java.util.List;

class Aluno extends Pessoa{
    private String curso;
    private ArrayList<Boletim> matriculas;
    
    //Método construtor
    public Aluno(){
        super("", 0);
        this.curso = "";
        this.matriculas = new ArrayList<>();
    }
    
    //Setters
    public void adicionarMatricula(Disciplina disciplina){
        this.matriculas.add(new Boletim(disciplina));
    }
    
    public void setNomeAluno(String name){
        this.nome = name;
    }
    
    public void setRaAluno(int id){
        this.id = id;
    }
    
    public void setCursoAluno(String course){
        this.curso = course;
    }
    
    //Getters
    public String getNomeAluno(){
        return nome;
    }
    
    public int getRa(){
        return id;
    }
    
    public String getCursoAluno(){
        return curso;
    }
    
    public ArrayList<Boletim> getMatriculas(){
        return new ArrayList<>(matriculas);
    }
    
    @Override
    public void exibirInfo(){
        System.out.println("Aluno: " + nome + " | RA: " + id + " | Curso: " + curso);
    }
}
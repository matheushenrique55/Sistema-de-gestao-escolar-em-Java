import java.util.ArrayList;
import java.util.List;

class Disciplina{
    private String disciplina;
    private int codigo;
    private String professor;
    
    //Método construtor
    public Disciplina(){
        this.disciplina = "";
        this.codigo = 0;
        this.professor = "";
    }
    
    //Setters
    public void setDisciplina(String nomeDisciplina){
        this.disciplina = nomeDisciplina;
    }
    
    public void setCodigo(int code){
        this.codigo = code;
    }
    
    public void setProfessor(String nomeProfessor){
        this.professor = nomeProfessor;
    }
    
    //Getters
    public String getDisciplina(){
        return disciplina;
    }
    
    public int getCode(){
        return  codigo;
    }
    
    public String getProfessor(){
        return professor;
    }
}
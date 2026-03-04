import java.util.ArrayList;
import java.util.List;

class Nota{
    private Double nota;
    private String disciplinaCorrespondente;
    
    //Método construtor
    public Nota(){
        this.nota = 0.0; 
        this.disciplinaCorrespondente = "";
    }
    
    //Setters
    public void setarNota(Double grade){
        this.nota = grade;
    }
    
    public void setarDisciplinaCorrespondente(String subject){
        this.disciplinaCorrespondente = subject;
    }
    
    //Getters
    public Double getNota(){
        return nota;
    }
    
    public String getDisciplinaCorrespondente(){
        return disciplinaCorrespondente;
    }
}
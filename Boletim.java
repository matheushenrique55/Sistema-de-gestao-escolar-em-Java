import java.util.ArrayList;
import java.util.List;

class Boletim{
    private Disciplina materia;
    private ArrayList<Double> notas;
    
    //Método construtor
    public Boletim(Disciplina disciplina){
        this.materia = disciplina;
        this.notas = new ArrayList<>();
    }
    
    public void adicionarNotas(double nota){
        notas.add(nota);
    }
    
    public Disciplina pegarDisciplina(){
        return materia;
    }
    
    public ArrayList<Double> getNotasBoletim(){
        return new ArrayList<>(notas);
    }
    
    public double calcularMediaFinal(){
        if(notas.isEmpty()){
            //não há o que calcular
            return 0.0;
        }
        
        double soma = 0.0;
        
        for(double n : notas){
            soma += n;
        }
        
        return soma / notas.size();
    }
}
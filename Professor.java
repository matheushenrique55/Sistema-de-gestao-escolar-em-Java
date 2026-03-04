import java.util.ArrayList;
import java.util.List;

class Professor extends Pessoa {
	private ArrayList<Disciplina> materiasResponsaveis;
	//private String materia;

	//Método construtor
	public Professor() {
		super("", 0);
		this.materiasResponsaveis = new ArrayList<>();
	}

	//Setters
	public void setarNomeProfessor(String nameTeacher) {
		this.nome = nameTeacher;
	}

	public void setarIdentificador(int id) {
		this.id = id;
	}

	//Getters
	public String getNomeProfessor() {
		return nome;
	}

	public int getIdentificador() {
		return id;
	}

	public ArrayList<Disciplina> getMateriasProfessor() {
		return new ArrayList<>(materiasResponsaveis);
	}

	public void cadastrarMateriasProfessor(Disciplina disciplina) {
		this.materiasResponsaveis.add(disciplina);
	}

	@Override
	public void exibirInfo() {
		System.out.println("Professor: " + nome + " | ID: " + id);
	}
}
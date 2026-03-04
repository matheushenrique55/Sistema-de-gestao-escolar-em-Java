import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	Scanner pegarDados = new Scanner(System.in);
	    ArrayList<Aluno> listaAlunos = new ArrayList<>();
	    ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
	    ArrayList<Professor> listaProfessores = new ArrayList<>();
	    ArrayList<Pessoa> pessoas = new ArrayList<>();
	    
	    Controle controle = new Controle();
	    int pararContinuar = 0;
	    
	    while(true){
	        int escolhaMenu = 0;
            int quantidadeCadastro = 0;
	        
	        System.out.println("\n========== Seja bem-vindo(a) ao sistema de gestão escolar ==========\n");
	        System.out.println("[1] Cadastrar aluno(a)");
	        System.out.println("[2] Cadastrar professor(a)");
	        System.out.println("[3] Cadastrar disciplina");
	        System.out.println("[4] Cadastrar disciplina(s) de cada aluno");
	        System.out.println("[5] Cadastrar notas");
	        System.out.println("[6] Listar alunos");
	        System.out.println("[7] Listar professores");
	        System.out.println("[8] Listar disciplinas");
	        System.out.println("[9] Consultar notas de um aluno");
	        System.out.println("[10] Listar resultados finais (aprovados e reprovados)");
	        System.out.println("[11] Sair do sistema\n");
	        System.out.println("========================================================================");
	        System.out.print("Escolha: ");
	        escolhaMenu = pegarDados.nextInt();
	        pegarDados.nextLine();
	        
	        if(escolhaMenu == 1){
	            System.out.println("\n ---- Cadastrar novo aluno(a) ----\n");
	            while(true){
	                Aluno aluno = new Aluno();
	  
    	            System.out.print("Nome: ");
                    aluno.setNomeAluno(pegarDados.nextLine());
    	            System.out.print("RA: ");
    	            aluno.setRaAluno(pegarDados.nextInt());
    	            pegarDados.nextLine();
    	            System.out.print("Curso: ");
    	            aluno.setCursoAluno(pegarDados.nextLine());
    	            
    	            listaAlunos.add(aluno);
    	            pessoas.add(aluno);
    	            
    	            System.out.println("\n -> Aluno(a) " + aluno.getNomeAluno() + " foi cadastrado(a) com sucesso!\n");
    	            
    	            pararContinuar = controle.continuarCancelar();
    	            
    	            if(pararContinuar == 0){
    	                break;
    	            }
	            }
	        }else if(escolhaMenu == 2){
	            System.out.println("\n ---- Cadastrar novo professor(a) ----\n");
	            while(true){
	                Professor professor = new Professor();
	            
    	            System.out.print("Nome: ");
    	            professor.setarNomeProfessor(pegarDados.nextLine());
    	            System.out.print("ID: ");
    	            professor.setarIdentificador(pegarDados.nextInt());
    	            pegarDados.nextLine();
    	            
    	            System.out.print("Quantas matérias deseja cadastrar para este professor? ");
    	            quantidadeCadastro = pegarDados.nextInt();
    	            pegarDados.nextLine();
    	            
    	            for(int i = 1; i <= quantidadeCadastro; i++){
    	                Disciplina disciplina = new Disciplina();
    	                
    	                System.out.print("Matéria [" + i + "]: ");
    	                String nomeMateria = pegarDados.nextLine();
    	                
    	                //Posteriormente, fazer uma verificacao para ver se o código ja foi inserido para outra materia, nesse caso precisa retornar um erro e pedir novamente.
    	                System.out.print("    -> Código da disciplina *" + nomeMateria + "*: ");
    	                int codesubject = pegarDados.nextInt();
    	                pegarDados.nextLine();
    	                
    	                disciplina.setCodigo(codesubject);
    	                disciplina.setDisciplina(nomeMateria);
    	                professor.cadastrarMateriasProfessor(disciplina);
    	                
    	                listaDisciplinas.add(disciplina);
    	            }
    	            
    	            listaProfessores.add(professor);
    	            pessoas.add(professor);
    	            System.out.println("\n -> Professor " + professor.getNomeProfessor() + " cadastrado com sucesso!\n");
    	            
    	            pararContinuar = controle.continuarCancelar();
    	            
    	            if(pararContinuar == 0){
    	                break;
    	            }
	            }
	        }else if(escolhaMenu == 3){
	            System.out.println("\n ---- Cadastrar nova disciplina ----\n");
	            while(true){
	              Disciplina disciplina = new Disciplina();
	                
                    System.out.print("Matéria: ");
                    String nomeMateria = pegarDados.nextLine();
                    
                    //Posteriormente, fazer uma verificacao para ver se o código ja foi inserido para outra materia, nesse caso precisa retornar um erro e pedir novamente.
                    System.out.print("    -> Código da disciplina *" + nomeMateria + "*: ");
                    int codesubject = pegarDados.nextInt();
                    pegarDados.nextLine();
                    
                    disciplina.setCodigo(codesubject);
                    disciplina.setDisciplina(nomeMateria);
                    
                    listaDisciplinas.add(disciplina);
                    
                    System.out.println("\n -> A disciplina " + disciplina.getDisciplina() + ", código " + disciplina.getCode() + " foi cadastrada com sucesso!\n");
                    
                    pararContinuar = controle.continuarCancelar();
    	            
    	            if(pararContinuar == 0){
    	                break;
    	            }
	            }
	        }else if(escolhaMenu == 4){
	            if(listaAlunos.isEmpty()){
	                System.out.println("\nNenhum aluno cadastrado ainda! Cadastre pelo menos um primeiro.\n");
                    continue;
	            }
	            
	            String nomeAluno;
	            
	            System.out.println("\n ---- Cadastrar as disciplina de cada aluno ----\n");
	            
	            while(true){
	                System.out.print("    *** Lista de alunos ***\n");
	                
    	            System.out.println("\n-----------------------------------------------");
                    System.out.printf("%-20s | %-10s | %-20s%n", "Nome", "RA", "Curso");
                    System.out.println("-----------------------------------------------");
    	                
    	            for(Aluno aluno : listaAlunos){
    	               System.out.printf("%-20s | %-10s | %-20s%n", 
                            aluno.getNomeAluno(), 
                            aluno.getRa(), 
                            aluno.getCursoAluno()
                        );
    	            }
    	                
    	            System.out.println("-----------------------------------------------");
    	            
    	            System.out.print("Para qual aluno deseja realizar o cadastro? ");
    	            nomeAluno = pegarDados.nextLine();
    	            
    	            boolean encontrado = false;
    	            Aluno alunoEncontrado = null;
    	            
    	            for(Aluno aluno : listaAlunos){
    	                if(aluno.getNomeAluno().equalsIgnoreCase(nomeAluno)){
    	                    encontrado = true;
    	                    alunoEncontrado = aluno;
    	                    break;
    	                }
    	            }
    	            
    	            if(!encontrado){
                        while(true){
                            System.out.println("Aluno não encontrado!");
                            System.out.print("Digite novamente: ");
                            nomeAluno = pegarDados.nextLine();
                            
                            for(Aluno aluno : listaAlunos){
                                if(aluno.getNomeAluno().equalsIgnoreCase(nomeAluno)){
                                    encontrado = true;
                                    alunoEncontrado = aluno;
                                    break;
                                }
                            }
                    
                            if(encontrado){
                                break; 
                            }
                        }
                    }
                    
                    System.out.print("Quantas matérias deseja cadastrar? ");
                    quantidadeCadastro = pegarDados.nextInt();
                    pegarDados.nextLine();
                    
                    for(int j = 1; j <= quantidadeCadastro; j++){
                        System.out.print("Matéria [" + j + "]: ");
                        String materiaEscolhida = pegarDados.nextLine();
                    
                        Disciplina disciplinaEscolhida = null;
                    
                        //Aqui, eu busco a disciplina na lista geral de disciplinas
                        for(Disciplina d : listaDisciplinas){
                            if(d.getDisciplina().equalsIgnoreCase(materiaEscolhida)){
                                disciplinaEscolhida = d;
                                break;
                            }
                        }
                    
                        //Se não existir, cria nova
                        if(disciplinaEscolhida == null){
                            disciplinaEscolhida = new Disciplina();
                            disciplinaEscolhida.setDisciplina(materiaEscolhida);
                            listaDisciplinas.add(disciplinaEscolhida);
                        }
                    
                        alunoEncontrado.adicionarMatricula(disciplinaEscolhida);
                    }
                    System.out.println("\n -> Disciplinas cadastradas para " + alunoEncontrado.getNomeAluno() + " com sucesso!\n");
                    
                    pararContinuar = controle.continuarCancelar();
                    
                    if(pararContinuar == 0){
                        break;
                    }
	            }
	        }else if(escolhaMenu == 5){
	                if(listaAlunos.isEmpty()){
	                    System.out.println("\nNenhum aluno cadastrado ainda! Cadastre pelo menos um primeiro.\n");
	                    continue;
	                }
	            
                    System.out.println("\n ---- Cadastrar as notas dos alunos ----\n");
                
                    boolean encontrado = false;
                    Aluno selecionado = null;
                
                    System.out.print("    *** Lista de alunos ***\n");
                    System.out.println("\n-----------------------------------------------");
                    System.out.printf("%-20s | %-10s | %-20s%n", "Nome", "RA", "Curso");
                    System.out.println("-----------------------------------------------");
                
                    for (Aluno aluno : listaAlunos) {
                        System.out.printf("%-20s | %-10s | %-20s%n",
                            aluno.getNomeAluno(),
                            aluno.getRa(),
                            aluno.getCursoAluno()
                        );
                    }
                
                    System.out.println("-----------------------------------------------");
                    System.out.print("Aluno: ");
                    String alunoNome = pegarDados.nextLine();
                
                    for(Aluno a : listaAlunos){
                        if(a.getNomeAluno().equalsIgnoreCase(alunoNome)){
                            encontrado = true;
                            selecionado = a;
                            break;
                        }
                    }
                
                    if(!encontrado){
                        while(true){
                            System.out.println("Aluno não encontrado!");
                            System.out.print("Digite novamente: ");
                            alunoNome = pegarDados.nextLine();
                
                            for(Aluno a : listaAlunos){
                                if (a.getNomeAluno().equalsIgnoreCase(alunoNome)){
                                    encontrado = true;
                                    selecionado = a;
                                    break;
                                }
                            }
                
                            if(encontrado){
                                break;
                            }
                        }
                    }
                        
                    //Aqui, vamos pegar todas as matérias desse aluno(a)
                    ArrayList<Boletim> materiasMatriculadas = selecionado.getMatriculas();
                
                    if(materiasMatriculadas.isEmpty()){
                        System.out.println("\n     -> O aluno(a) não está matriculado em nenhuma matéria!\n");
                        System.out.print("Deseja cadastrar disciplinas para este aluno agora? [1] SIM [0] NÃO: ");
                        int opcao = pegarDados.nextInt();
                        pegarDados.nextLine();
                
                        if(opcao == 1){
                            System.out.println("\nRedirecionando para o cadastro de disciplinas...\n");
                
                            System.out.print("Quantas matérias deseja cadastrar? ");
                            int quantidadeCadastro2 = pegarDados.nextInt();
                            pegarDados.nextLine();
                
                            for(int j = 1; j <= quantidadeCadastro2; j++){
                                System.out.print("Matéria [" + j + "]: ");
                                String materiaEscolhida = pegarDados.nextLine();
                
                                Disciplina disciplinaEscolhida = new Disciplina();
                                disciplinaEscolhida.setDisciplina(materiaEscolhida);
                                selecionado.adicionarMatricula(disciplinaEscolhida);
                            }
                
                            System.out.println("\n -> Disciplinas cadastradas para " + selecionado.getNomeAluno() + " com sucesso!\n");
                            materiasMatriculadas = selecionado.getMatriculas();
                        }else{
                            System.out.println("Voltando ao menu principal...");
                            continue;
                        }
                    }
                
                    System.out.println(selecionado.getNomeAluno() + " está matriculado(a) nas seguintes disciplinas: ");
                    System.out.println("\n-----------------------------------------------");
                    System.out.printf("%-20s%n", "Disciplina");
                    System.out.println("-----------------------------------------------");
                
                    for(Boletim b : materiasMatriculadas){
                        System.out.printf("%-20s %n", b.pegarDisciplina().getDisciplina());
                    }
                
                    System.out.println("-----------------------------------------------");
                
                    // Pula direto para o cadastro de notas, mesmo se acabou de cadastrar disciplinas
                    while(true){
                        System.out.print("\nPara qual disciplina deseja cadastrar as notas? ");
                        String disciplinaSelecionada = pegarDados.nextLine();
                
                        Boletim boletimSelecionado = null;
                
                        while(true){
                            for(Boletim b : materiasMatriculadas){
                                if(b.pegarDisciplina().getDisciplina().equalsIgnoreCase(disciplinaSelecionada)){
                                    boletimSelecionado = b;
                                    break;
                                }
                            }
                
                            if(boletimSelecionado != null){
                                break;
                            }else{
                                System.out.println("A disciplina selecionada não corresponde a esse aluno(a)!");
                                System.out.print("Digite novamente o nome da disciplina: ");
                                disciplinaSelecionada = pegarDados.nextLine();
                            }
                        }
                
                        System.out.println("\n    *** Cadastrando notas para " + boletimSelecionado.pegarDisciplina().getDisciplina() + " *** \n");
                
                        System.out.print("Nota prova 1: ");
                        double nota1 = pegarDados.nextDouble();
                        System.out.print("Nota prova 2: ");
                        double nota2 = pegarDados.nextDouble();
                        System.out.print("Nota prova 3: ");
                        double nota3 = pegarDados.nextDouble();
                        pegarDados.nextLine();

                
                        boletimSelecionado.adicionarNotas(nota1);
                        boletimSelecionado.adicionarNotas(nota2);
                        boletimSelecionado.adicionarNotas(nota3);
                
                        System.out.println("\n    -> Notas cadastradas com sucesso!\n");
                
                        pararContinuar = controle.continuarCancelar();
                
                        if (pararContinuar == 0) {
                            break;
                        }
                    }
	            }else if(escolhaMenu == 6){
	                if(listaAlunos.isEmpty()){
	                    System.out.println("\nNenhum aluno cadastrado ainda! Cadastre pelo menos um primeiro.\n");
	                    continue;
	                }
	                
	                System.out.println("\n    *** Listando alunos *** \n");
	                
	                System.out.println("\n-----------------------------------------------");
                    System.out.printf("%-20s | %-10s | %-20s%n", "Nome", "RA", "Curso");
                    System.out.println("-----------------------------------------------");
	                
	                for(Aluno aluno : listaAlunos){
	                    System.out.printf("%-20s | %-10s | %-20s%n", 
                            aluno.getNomeAluno(), 
                            aluno.getRa(), 
                            aluno.getCursoAluno()
                        );
	                }
	                
	                System.out.println("-----------------------------------------------");
	            }else if(escolhaMenu == 7){
	                System.out.println("\n    *** Listando professores *** \n");
	                
	                System.out.println("\n--------------------------------------------------------------------------");
                    System.out.printf("%-20s | %-10s | %-20s%n", "Nome", "ID", "Disciplinas responsável");
                    System.out.println("----------------------------------------------------------------------------");
	                
	                for(Professor professores : listaProfessores){
	                    ArrayList<Disciplina> materiasProfessor = professores.getMateriasProfessor();
	                    StringBuilder nomeDisciplinas = new StringBuilder(); //Com StringBuilder eu crio um "bloco" de palavras, que serão adicionadas nele pelo for
	                    
	                    for(int i = 0; i < materiasProfessor.size(); i++){
	                        nomeDisciplinas.append(materiasProfessor.get(i).getDisciplina());
	                        
	                        if(i < materiasProfessor.size() - 1){
	                            nomeDisciplinas.append(", "); //Essa parte é para não ter uma virgula após a última matéria
	                        }
	                    }
	                    
	                    System.out.printf("%-20s | %-10s | %-30s%n", 
                            professores.getNomeProfessor(), 
                            professores.getIdentificador(),
                            nomeDisciplinas.toString()
                        );
	                }
	                
	                System.out.println("----------------------------------------------------------------------------");
	            }else if(escolhaMenu == 8){
	                System.out.println("\n    *** Listando disciplinas *** \n");

                    System.out.println("\n--------------------------------------------------");
                    System.out.printf("%-20s | %-10s%n", "Disciplina", "Código");
                    System.out.println("--------------------------------------------------");
                    
                    for (Disciplina disciplinas : listaDisciplinas) {
                        System.out.printf("%-20s | %-10s%n",
                            disciplinas.getDisciplina(),
                            disciplinas.getCode()
                        );
                    }

	            }else if(escolhaMenu == 9){
	                if(listaAlunos.isEmpty()){
	                    System.out.println("\nNenhum aluno cadastrado ainda! Cadastre pelo menos um primeiro.\n");
	                    continue;
	                }
	                
	                while(true){
	                    System.out.println("\n    *** Listando alunos *** \n");
	                
    	                System.out.println("\n-----------------------------------------------");
                        System.out.printf("%-20s | %-10s | %-20s%n", "Nome", "RA", "Curso");
                        System.out.println("-----------------------------------------------");
    	                
    	                for(Aluno aluno : listaAlunos){
    	                    System.out.printf("%-20s | %-10s | %-20s%n", 
                                aluno.getNomeAluno(), 
                                aluno.getRa(), 
                                aluno.getCursoAluno()
                            );
    	                }
    	                
    	                System.out.println("-----------------------------------------------");
    	                
    	                System.out.print("Aluno: ");
    	                String alunoEscolhido = pegarDados.nextLine();
    	                boolean existe = false;
    	                Aluno notasAluno = null;
    	                
    	                for(Aluno aluno : listaAlunos){
    	                    if(aluno.getNomeAluno().equalsIgnoreCase(alunoEscolhido)){
    	                        //Significa que o aluno existe
    	                        existe = true;
    	                        notasAluno = aluno;
    	                    }
    	                }
    	                
    	                if(existe){
    	                    //Exibir as notas desse aluno
    	                    System.out.println("\n    *** Notas referentes ao aluno(a) " + notasAluno.getNomeAluno() + " ***\n");
    	                    ArrayList<Boletim> boletins = notasAluno.getMatriculas();
    	                    
    	                    if(boletins.isEmpty()){
    	                        System.out.println("O aluno(a) não está matriculado(a) em nenhuma disciplina.");
    	                    }else{
    	                        System.out.printf("\n%-20s | %-6s | %-6s | %-6s | %-12s | %-10s%n", "Disciplina", "Nota 1", "Nota 2", "Nota 3", "Média Final", "Situação");
                                System.out.println("-----------------------------------------------------------------------");
    	                        for(Boletim b : boletins){
    	                            //A cada vez que o for roda, todas as informações de uma disciplina é exibida
    	                            
    	                            //Aqui precisamos do nome da materia, logo o método getDisciplina() é necessário
    	                            ArrayList<Double> notasIndividuais = b.getNotasBoletim();
                                    String nomeMateria = b.pegarDisciplina().getDisciplina();
                                        
                                    double nota1 = notasIndividuais.size() > 0 ? notasIndividuais.get(0) : 0.0;
                                    double nota2 = notasIndividuais.size() > 1 ? notasIndividuais.get(1) : 0.0;
                                    double nota3 = notasIndividuais.size() > 2 ? notasIndividuais.get(2) : 0.0;
                                    double media = b.calcularMediaFinal();
                                    
                                    //Estilizando com cores
                                    String verde = "\u001B[32m";
                                    String vermelho = "\u001B[31m";
                                    String reset = "\u001B[0m";
                                    //Estilizando com cores
                                    
                                    String resultadoFinal = media >= 6.0 ? verde + "APROVADO" + reset : vermelho + "REPROVADO" + reset;
                                        
                                    System.out.printf("%-20s | %-6.2f | %-6.2f | %-6.2f | %-12.2f | %-10s%n", nomeMateria, nota1, nota2, nota3, media, resultadoFinal);
                                                
                                    System.out.println("-----------------------------------------------------------------------");
    	                        }
    	                    }
    	                }
    	                
    	                pararContinuar = controle.continuarCancelar9();
    	            
        	            if(pararContinuar == 0){
        	                break;
        	            }
	                }
	                
	            }else if(escolhaMenu == 10){
	                if(listaAlunos.isEmpty()){
	                    System.out.println("\nNenhum aluno cadastrado ainda! Cadastre pelo menos um primeiro.\n");
	                    continue;
	                }
	                
	                System.out.println("\n    *** Panorama geral dos alunos e suas disciplinas ***\n");
	                
                    System.out.printf("%-20s | %-20s | %-6s | %-6s | %-6s | %-12s | %-10s%n",
                        "Aluno", "Disciplina", "Nota 1", "Nota 2", "Nota 3", "Média Final", "Situação");
                    System.out.println("-----------------------------------------------------------------------------------------------");

                    for(Aluno aluno : listaAlunos){
                        String nome = aluno.getNomeAluno();
                        ArrayList<Boletim> boletimIndividual = aluno.getMatriculas(); 
                    
                        if (boletimIndividual.isEmpty()) {
                            System.out.printf("%-20s | %-20s | %-6s | %-6s | %-6s | %-12s | %-10s%n",
                                nome, "—", "—", "—", "—", "—", "SEM DISCIPLINAS");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            continue;
                        }
                    
                        for(Boletim b : boletimIndividual){
                            String materia = b.pegarDisciplina().getDisciplina();
                            ArrayList<Double> notas = b.getNotasBoletim();
                    
                            double nota1 = notas.size() > 0 ? notas.get(0) : 0.0;
                            double nota2 = notas.size() > 1 ? notas.get(1) : 0.0;
                            double nota3 = notas.size() > 2 ? notas.get(2) : 0.0;
                            double media = b.calcularMediaFinal();
                            
                            //Aqui vou estilizar um pouco, com cores que correspondem a situação final do aluno
                            String verde = "\u001B[32m";
                            String vermelho = "\u001B[31m";
                            String reset = "\u001B[0m";
                            //Se não tiver esse reset, tudo o que vem depois do texto continuaria da cor setada.
                            
                            String resultadoFinal = media >= 6.0 ? verde + "APROVADO" + reset : vermelho + "REPROVADO" + reset;
                    
                            System.out.printf("%-20s | %-20s | %-6.2f | %-6.2f | %-6.2f | %-12.2f | %-10s%n",
                                nome, materia, nota1, nota2, nota3, media, resultadoFinal);
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }
                    }
	           }else if(escolhaMenu == 11){
    	            System.out.println("Saindo do sistema...");
    	            break;
	            }else{
	                //Aqui novamente, para o tratamento desse erro, vou dar uma estilizada com a cor vermelha
	                String vermelho = "\u001B[91m";
                    String reset = "\u001B[0m";
	                System.out.println(vermelho + "\n⚠️  Opção inválida! Digite um número entre 1 e 11.\n"+ reset);
	            }
	        }	
	}
}
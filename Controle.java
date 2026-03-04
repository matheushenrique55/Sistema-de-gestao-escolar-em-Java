import java.util.Scanner;

class Controle{
    public int decisao;
    Scanner scanner = new Scanner(System.in);
    
    public Controle(){
        this.decisao = 0;
    }
    
    public int continuarCancelar(){
        System.out.println("Deseja continuar cadastrando? \n[1] SIM \n[0] NÃO");
        System.out.print("Escolha: ");
        decisao = scanner.nextInt();
        
        return decisao;
    }
    public int continuarCancelar9(){
        System.out.println("Deseja ver de outro(a) aluno(a)? \n[1] SIM \n[0] NÃO");
        System.out.print("Escolha: ");
        decisao = scanner.nextInt();
        
        return decisao;
    }
}
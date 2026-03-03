package ex04;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private ArrayList<Emprestimo> emprestimos;

    public Pessoa(){
        this.emprestimos = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public String toString(){
        return "---Dados Pessoa---\nNome: "+nome+"\nCPF: "+cpf+"\nEmprestimos: "+getEmprestimos();
    }
    
    
}

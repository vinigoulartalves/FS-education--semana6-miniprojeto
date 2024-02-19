import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {
    private static int idGeral = 0;
    public List<Aluno> listaAlunos = new ArrayList<>();
    private int anoCriacao;
    private Curso curso;
    private int idTurma;

    public Turma() {
        idGeral += 1;
        setIdTurma(idGeral);
    }

    public Turma(Curso curso, int anoCriacao) {
        this.curso = curso;
        this.anoCriacao = anoCriacao;

        idGeral += 1;
        setIdTurma(idGeral);
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getIdTurma() {
        return idTurma;
    }

    private void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void listarAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println("Nome: " + aluno);
            System.out.println("Id: " + aluno + "\n");
        }
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removerAluno(Scanner scanner) {
        System.out.println("Digite o id do aluno que você quer remover");
        listarAlunos();

        int idAluno = scanner.nextInt();
        scanner.nextLine();
        Aluno alunoEscolhido = null;

        for (Aluno aluno : listaAlunos) {
            if (aluno.getIdAluno() == idAluno) {
                alunoEscolhido = aluno;
            }
        }

        listaAlunos.remove(alunoEscolhido);
    }

    public void adicionarTurma(Curso curso, Scanner entrada) {
        entrada = new Scanner(System.in);

        Turma turma = new Turma();

        int anoCriacao;

        System.out.println("Insira o ano de criação da turma: ");
        anoCriacao = entrada.nextInt();
        entrada.nextLine();
        setAnoCriacao(anoCriacao);
        setCurso(curso);
    }


    @Override
    public String toString() {
        return "Turma{" +
                "listaAlunos=" + listaAlunos +
                ", anoCriacao=" + anoCriacao +
                ", curso=" + curso +
                '}';
    }
}
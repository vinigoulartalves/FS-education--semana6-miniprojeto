import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {

    private static int idGeral = 0;
    private int idAluno;
    private StatusMatricula statusMatricula = StatusMatricula.ATIVO;
    private String nome;
    private int idade;

    public Aluno() {
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

        idGeral += 1;
        setIdAluno(idGeral);
    }

    public static StatusMatricula[] getTodosStatusMatriculas() {
        return StatusMatricula.values();
    }

    public static StatusMatricula getStatusMatriculaPorNome(String nome) {
        try {
            return StatusMatricula.valueOf(nome);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Lista os cursos em que o aluno está matriculado
//    public List<Curso> listarCursos(List<Curso> cursos) {
//        List<Curso> cursosdoaluno = new ArrayList<>();
//        for (Curso curso : cursos) { //percorre a lista dos cursos
//            if (curso.getAlunos().contains(this)) { //procurando o aluno na lista
//                cursosdoaluno.add(curso);//adicionando o curso na lista de curso desse aluno
//            }
//        }
//        return cursosdoaluno;
//    }

    public void listarCursosDoAluno() {
        for (Turma turma : DadosTurmas.listaTurmas) {
            for (Aluno aluno : turma.listaAlunos) {
                if (aluno.getIdAluno() == this.getIdAluno()) {
                    System.out.println(turma.getCurso());
                }
            }
        }
    }


    //Adiciona um curso à lista de cursos
    public void adicionarCurso(Curso curso) {
        curso.adicionarAluno(this);
    }

    //Remove um curso da lista de cursos
    public void removerCurso(Curso curso) {
        curso.removerAluno(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return idAluno == aluno.idAluno;
    }

    public void promover() {
        if (statusMatricula.equals(statusMatricula.ATIVO)) {
            statusMatricula = statusMatricula.FORMADO;
            System.out.println("O aluno " + this.nome + " agora está formado!");
        } else if (statusMatricula.equals(statusMatricula.TRANCADO)) {
            System.out.println("O aluno " + this.nome + " está com a matrícula trancada!");
        } else {
            System.out.println("O aluno " + this.nome + " ja é formado!");
        }
    }

    public void trancarMatricula() {
        if (statusMatricula.equals(statusMatricula.ATIVO)) {
            statusMatricula = statusMatricula.TRANCADO;
            System.out.println("O aluno " + this.nome + " agora está com a matrícula trancada!");
        } else if (statusMatricula.equals(statusMatricula.TRANCADO)) {
            System.out.println("O aluno " + this.nome + " ja está com a matrícula trancada!");
        } else {
            System.out.println("O aluno " + this.nome + " ja é formado!");
        }
    }

    public void ativarMatricula() {
        if (statusMatricula.equals(statusMatricula.TRANCADO)) {
            statusMatricula = statusMatricula.ATIVO;
            System.out.println("O aluno " + this.nome + " agora está com a matrícula ativa!");
        } else if (statusMatricula.equals(statusMatricula.ATIVO)) {
            System.out.println("O aluno " + this.nome + " ja está com a matrícula ativa!");
        } else {
            System.out.println("O aluno " + this.nome + " ja é formado!");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAluno);
    }

    @Override
    public String toString() {
        return "[" + idAluno + "]" + " | Nome: " + nome + " | Idade: " + idade + " anos";
    }
}

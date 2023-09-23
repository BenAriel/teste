package entities;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.sql.Date;

public class Prova {
    private int codigo;
    private String disciplina;
    private List<Questao> questaoList = new ArrayList<>();
    private int numeroDeQuestoes;
    private LocalDate data;
    private int questoesFaceis;
    private int questoesMedias;
    private int questoesDificeis;

    
    public Prova(String disciplina, List<Questao> questaoList, int numeroDeQuestoes, int questoesFaceis, int questoesMedias, int questoesDificeis) {
        setDisciplina(disciplina);
        setQuestoes(questaoList);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);
        setData(LocalDate.now()); 
    }
    
    //construtor sem lista de questoes
    public Prova(String disciplina, int numeroDeQuestoes, int questoesFaceis, int questoesMedias, int questoesDificeis) {
        setDisciplina(disciplina);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);
        setData(LocalDate.now()); 
    }

    //construtor para pesquisa
    public Prova(int codigo) {
        this.codigo = codigo;
    }
    
   //construtor para alterar
    public Prova(int codigo,String disciplina, int numeroDeQuestoes, int questoesFaceis, int questoesMedias, int questoesDificeis) {
        setCodigo(codigo);
    	setDisciplina(disciplina);
        setQuestoes(questaoList);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);
        setData(LocalDate.now()); 
    }
    
    //construtor padrão
    public Prova() {
    	
    }

    public void gerarProvas(int numeroDeQuestoes, int questoesFaceis, int questoesMedias, int questoesDificeis) {
    	setCodigo(1); //inicia sempre com um para evitar erros na classe DAO!
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);  
        setData(LocalDate.now()); // coloca a data do momento da criação como data da prova
    }
    
    private void setData(LocalDate now) {
        this.data = LocalDate.now();
    }

    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestoes(List<Questao> questaoList) {
        if (questaoList != null) {
            this.questaoList = questaoList;
        } else {
            System.out.println("Valor inválido para a lista de questões");
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina != null) {
            this.disciplina = disciplina;
        } else {
            System.out.println("Disciplina não pode ser vazia!");
        }
    }

    public int getNumeroDeQuestoes() {
        return numeroDeQuestoes;
    }

    public void setNumeroDeQuestoes(int numeroDeQuestoes) {
        if (numeroDeQuestoes < 1) {
            System.out.println("Numero de questoes não pode ser negativo ou zero!");
            System.exit(1);
        } else {
            this.numeroDeQuestoes = numeroDeQuestoes;
        }
    }

    public void setData(Date localDate) {
        if (localDate != null) {
            this.data = localDate.toLocalDate();
        } else {
            System.out.println("A data não pode ser vazia");
        }
    }

    public LocalDate getData() {
        return this.data;
    }

    public int getQuestoesFaceis() {
        return questoesFaceis;
    }

    public void setQuestoesFaceis(int questoesFaceis) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
            System.out.println("O número de questões FACEIS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + questoesFaceis);
            System.out.println("Questões medias adicionadas: " + this.questoesMedias);
            System.out.println("Questões dificeis adicionadas: " + this.questoesDificeis);
            System.out.println("Você adicionou " + questoesFaceis + " questoes fáceis e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões fáceis sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesFaceis = questoesFaceis;
        }
    }

    public int getQuestoesMedias() {
        return questoesMedias;
    }

    public void setQuestoesMedias(int questoesMedias) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
            System.out.println("O número de questões MEDIAS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + this.questoesFaceis);
            System.out.println("Questões medias adicionadas: " + questoesMedias);
            System.out.println("Questões dificeis adicionadas: " + this.questoesDificeis);
            System.out.println("Você adicionou " + questoesMedias + " questoes médias e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões médias sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesMedias = questoesMedias;
        }
        
    }

    public int getQuestoesDificeis() {
        return questoesDificeis;
    }

    public void setQuestoesDificeis(int questoesDificeis) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes ) {
            System.out.println("O número de questões DIFICEIS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + this.questoesFaceis);
            System.out.println("Questões medias adicionadas: " + this.questoesMedias);
            System.out.println("Questões dificéis adicionadas: " + questoesDificeis);
            System.out.println("Você adicionou " + questoesDificeis + " questoes dificéis e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões dificéis sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesDificeis = questoesDificeis;
        }
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0) {
		this.codigo = codigo;
		} else {
			System.out.println("O código precisa ser maior quer 0!");
		}
	}

	
	@Override
	public String toString() {
		return "Prova [codigo=" + codigo + ", disciplina=" + disciplina + ", questaoList=" + questaoList
				+ ", numeroDeQuestoes=" + numeroDeQuestoes + ", data=" + data + ", questoesFaceis=" + questoesFaceis
				+ ", questoesMedias=" + questoesMedias + ", questoesDificeis=" + questoesDificeis + "]";
	}

	
}

package entities;

public class Questao {
    private int codigo;
    private String disciplina;
    private String enunciado;
    private String gabarito;
    private String assunto;
    private int nivelDeDificuldade;


    public Questao() { // construtor default
    }

    //construtor principal usado para inserir
    public Questao(String disciplina, String enunciado, String gabarito, String assunto, int nivelDeDificuldade) {
    	//sempre vai começar a questão como null, o banco de dados é quem vai organizar
        setDisciplina(disciplina);
        setEnunciado(enunciado);
        setGabarito(gabarito);
        setAssunto(assunto);
        setNivelDeDificuldade(nivelDeDificuldade);
    }
    //construtor usado para fazer alterações de dados
    public Questao(int codigo, String disciplina, String enunciado, String gabarito, String assunto, int nivelDeDificuldade) {
    	//sempre vai começar a questão como null, o banco de dados é quem vai organizar
    	setCodigo(codigo);
        setDisciplina(disciplina);
        setEnunciado(enunciado);
        setGabarito(gabarito);
        setAssunto(assunto);
        setNivelDeDificuldade(nivelDeDificuldade);
    }
    //construtor usado para fazer buscas apenas por código no BD
    public Questao(int codigo) {
    	setCodigo(codigo);
    }

    //métodos set e get dos atributos
    public void setCodigo(int codigo) {
    	if (codigo > 0) {
    	this.codigo = codigo;
    	} else {
    		System.out.println("O código precisa ser maior ou igual a zero, também precisa ser um numero inteiro!");
    	}
        }

    public int getCodigo() {
        return this.codigo;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina != null) {
            this.disciplina = disciplina;
        } else {
            System.out.println("Disciplina não pode ser vazia!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setEnunciado(String enunciado) {
        if (enunciado != null) {
            this.enunciado = enunciado;
        } else {
            System.out.println("Enunciado não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void setGabarito(String gabarito) {
        if (gabarito != null) {
            this.gabarito = gabarito;
        } else {
            System.out.println("Gabarito não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getGabarito() {
        return this.gabarito;
    }

    public void setAssunto(String assunto) {
        if (assunto != null) {
            this.assunto = assunto;
        } else {
            System.out.println("Assunto não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getAssunto() {
        return this.assunto;
    }

    public int getNivelDeDificuldade() {
        return this.nivelDeDificuldade;
    }

    @Override
	public String toString() {
		return "Questao [codigo=" + codigo + ", disciplina=" + disciplina + ", enunciado=" + enunciado + ", gabarito="
				+ gabarito + ", assunto=" + assunto + ", nivelDeDificuldade=" + nivelDeDificuldade + "]";
	}

	public void setNivelDeDificuldade(int nivel) {
        if (nivel < 1 || nivel > 3)
        {
            System.out.println("Valor inválido, nível vai de 1 até 3!");
        }
        else
        {
           this.nivelDeDificuldade = nivel;        
        }    
            
    }

}
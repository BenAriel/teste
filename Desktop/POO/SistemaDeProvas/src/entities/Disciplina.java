package entities;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Questao> questaoList = new ArrayList<>();
    private List<Prova> provalist = new ArrayList<>();
    private int codigo;
    private String descricao;

    //construtor para inicializar a disciplina
    public Disciplina(){};
    public Disciplina(String name,String discri)
    {
        setNome(name);
        setDescricao(discri);
    }

    public Disciplina(String name,List <Questao> questoes,List<Prova> provas,String discri)
    {
        setNome(name);
        setQuestoes(questoes);
        setProvas(provas);
        setDescricao(discri);
    }
    public Disciplina(int codigo) {
        this.codigo = codigo;
    }
    public Disciplina(String name,String discri,int codigo)
    {
        setNome(name);
        setDescricao(discri);
        setCodigo(codigo);
    }

     //métodos gets e sets
    public String getNome ()
    {
        return nome;
    }
    public void setQuestoes(List<Questao> questaoList) {
        if (questaoList != null) {
            this.questaoList = questaoList;
        } else {
            System.out.println("Valor inválido para a lista de questões");
        }
    }

    public List<Questao> getQuestoes()
    {
        return this.questaoList;
    } 

    public void setProvas(List<Prova> provalist) {
        if (provalist != null) {
            this.provalist = provalist;
        } else {
            System.out.println("Valor inválido para a lista de questões");
        }
    }
    public List<Prova> getprovas()
    {
        return this.provalist;
    } 

    public void setNome(String name)
    {
        if(name!= null && name!= "\0")
        this.nome=name;
        else
        System.out.println("Digite um nome válido");
    }

    
    public int  getCodigo ()
    {
        return codigo;
    }

    public void setCodigo(int code)
    {
        if(code!= 0)
        this.codigo=code;
        else
        System.out.println("Digite um código válido");
    }
    
    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String desc)
    {
        if(desc!= null && desc!= "\0")
        this.descricao=desc;
        else
        System.out.println("Digite uma descrição válida");
    }
    //visualiza disciplina e sobrescreve o ToString padrão
    @Override
    public String toString ()
    {
       return ("Nome da disciplina: " + this.nome + "\n código da disciplina: " + this.codigo +"\n descrição da disciplina:" + this.descricao);  
    }
        
}

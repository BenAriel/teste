package connection;
import java.util.ArrayList;

//imports para cada classe que será testada
import entities.Monitor;
import entities.Prova;
import entities.Questao;
import entities.Disciplina;

public class Principal {

	public static void main(String[] args) {
		//descomente as partes para fazer o teste, faça isso em sequencia	
		
		
		//script para testar o Monitor:
		//MonitorDAO dao1 = new MonitorDAO();
		
		//inserir:
		//MonitorDAO dao1 = new MonitorDAO();
		//Monitor monitor1 = new Monitor("Vinícius Gabriel", "Login129082", "Senha089213", "0123456789"); //monitor de teste com Nome, Login, Senha e Matrícula
		//dao1.inserir(monitor1); // Inserindo na tabela de Monitor
		
		
		//alterar:
		//MonitorDAO dao1 = new MonitorDAO();
		//Monitor monitor2 = new Monitor("Vivian Gabriele", "NovoLogin123", "NovaSenha123", "0123456789");
		//dao1.alterar(monitor2); //altera a senha e o login do monitor1 para os novos valores
		
		
		//buscar:
		//MonitorDAO dao1 = new MonitorDAO();
		//Monitor monitor2 = new Monitor("Vivian Gabriele", "NovoLogin123", "NovaSenha123", "0123456789");
		//Monitor monitor1 = new Monitor("Vinícius Gabriel", "Login129082", "Senha089213", "0123456789"); //monitor de teste com Nome, Login, Senha e Matrícula
		//monitor2 = dao1.buscar(monitor1); //busca os dados do monitor1 e mostra na tela, como também retorna para uma novo objeto de monitor
		//System.out.println(monitor2.toString());//mostra que o buscar funcionou
		
		
		//listar:
		//MonitorDAO dao1 = new MonitorDAO();
		//ArrayList<Monitor> monitores = new ArrayList<>(); //cria uma lista de monitores
		//monitores = dao1.listar(); //pega todos os monitores da tabela e guarda no ArrayList de monitores
		//for (Monitor monitor : monitores) { // esse laço for apenas mostra que funcionou
		//  System.out.println(monitor.toString());
		//}
		
		//deletar:
		//MonitorDAO dao1 = new MonitorDAO();
		//Monitor monitor1 = new Monitor("Vinícius Gabriel", "Login129082", "Senha089213", "0123456789"); //monitor de teste com Nome, Login, Senha e Matrícula
		//dao1.remover(monitor1); //remove o monitor1 da tabela, descomente o listar e veja que realmente monitor sumil!
	
		//script para testar QuestaoDAO:-----------------------------------------------------------------------------------------------------
		
		//inserir:
		//QuestaoDAO dao1 = new QuestaoDAO();
		//Questao questao1 = new Questao("Matematica", "Quanto é dois mais 2?", "Quatro", "Matematica Básica", 1);
		//dao1.inserir(questao1);
		
		//alterar:
		//QuestaoDAO dao1 = new QuestaoDAO();
		//Questao questao2 = new Questao(4, "Física", "Como espirrar de olho aberto?", "Impossível", "Matemática Básica", 1);
		//dao1.alterar(questao2);
		
		//buscar:
		//questao1 = dao1.buscar(questao2);
	    //System.out.println(questao1.toString());
		
		//listar:
		//QuestaoDAO dao1 = new QuestaoDAO();
		//ArrayList<Questao> questoes = new ArrayList<>(); //cria uma lista de questoes
		//questoes = dao1.listar();
		//for (Questao questao : questoes) { // esse laço for serve apenas mostra que funcionou
	    //   	  System.out.println(questao.toString());
		//}
		
		//remover:
		//dao1.remover(questao2);
		
		//script para teste de ProvaDAO:-------------------------------------------------------------------------------------------------------
		
		//inserir na tabela de prova:
		//ProvaDAO daoProva = new ProvaDAO();
		//Prova p = new Prova("Matemática", 10, 5, 5, 0);
		//daoProva.inserir(p);
	
		//inserir: na tabela prova_questao, vai inserir as questões do array de questões na prova de código 1
		//ProvaDAO daoProva = new ProvaDAO();
		//QuestaoDAO dao1 = new QuestaoDAO();
		//ArrayList<Questao> questoes = new ArrayList<>(); //cria uma lista de questoes
		//questoes = dao1.listar();
		//Prova p1 = new Prova(2);
		//daoProva.inserir(p1,questoes);
		
		//buscar:
		//ProvaDAO daoProva = new ProvaDAO();
		//Prova p1 = new Prova(2);
		//p1 = daoProva.buscar(p1);
		//System.out.println(p1.toString());
		
		//listar:
		//ProvaDAO daoProva = new ProvaDAO();
		//ArrayList<Prova> provas = new ArrayList<>();
		//provas = daoProva.listar();
		//for (Prova prova : provas) { // esse laço for serve apenas mostra que funcionou
	    //   	  System.out.println(prova.toString());
		//}
		
		//alterar:
		//ProvaDAO daoProva = new ProvaDAO();
		//Prova p1 = new Prova(3, "Física", 20, 10, 5, 5);
		//daoProva.alterar(p1);		
		
		//remover:
		//ProvaDAO daoProva = new ProvaDAO();
		//Prova p1 = new Prova(2); //vai remover a prova que tem código igual a 2
		//daoProva.remover(p1);
		
		//
		//----------------------------------------------------------------//
			//teste disciplina
		
		
		//DisciplinaDAO discDAO = new DisciplinaDAO();
		//Disciplina D = new Disciplina("historia", "estuda a historia");
		//discDAO.inserir(D);
	
		//------------------teste inserir prova e questao---------- 
		//DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		//QuestaoDAO dao1 = new QuestaoDAO();
		//ArrayList<Questao> questoes = new ArrayList<>(); 
		//questoes = dao1.listar();
		//Disciplina d  = new Disciplina(2);
		//disciplinaDAO.inserir(d,questoes,"n");

		//ProvaDAO pdao = new ProvaDAO();
		//ArrayList<Prova> provas = new ArrayList<>(); 
		//provas = pdao.listar();
		//disciplinaDAO.inserir(d,provas);
		//buscar:
		//DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		//Disciplina d = new Disciplina(2);
		//d = disciplinaDAO.buscar(d);
		//System.out.println(d.toString());
		
		//listar:
		//DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		//ArrayList<Disciplina> disciplinas = new ArrayList<>();
		//disciplinas = disciplinaDAO.listar();
		
		//alterar:
		//DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		//Disciplina d = new Disciplina( "geografia","descrição é isso m",1);
		//disciplinaDAO.alterar(d);		
		
		//remover:
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina d = new Disciplina(1);
		disciplinaDAO.remover(d);

	}
}

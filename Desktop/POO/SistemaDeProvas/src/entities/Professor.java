package entities;

public class Professor {
    final String nome = "Dr.Helielcio da Silva"; //como o professor é sempre o mesmo, então o nome é uma constante.
    private String login;
    private String senha;
    final boolean NiveldeAcesso=true; //o nivel de acesso do professor é sempre liberado(true).

    public Professor(){};
    //construtor que inicializa o professor
    public Professor(String Log,String Pass)
    {
        setLogin(Log);
        setSenha(Pass);
    }

    public String getNomeProfessor() {
        return nome;
    }
    //métodos get e sets.
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String Log)
    {
        if(Log!= null && Log != "\0")
        this.login=Log;
        else
        System.out.println("digite um login válido");
    }

     public String getSenha()
    {
        return senha;
    }
    public void setSenha(String Password)
    {
        if(Password!= null && Password != "\0")
        this.senha=Password;
        else
        System.out.println("digite uma senha válida");
    }

    public void Login( String TentativaLogin,String TentativaSenha)
{
    String LoginAtual=getLogin(); //salva o login e a senha atuais em duas variáveis locais.
    String SenhaAtual=getSenha();
    setLogin(TentativaLogin); //chama os métodos set e get para verificar se os dados são válidos.
    setSenha(TentativaSenha);
    if(TentativaLogin==LoginAtual && TentativaSenha == SenhaAtual ) //verifica se o login e a senha inseridos são iguais as senhas atuais.
    {
        System.out.println("Login relalizado com sucesso"); //se for igual,o login é realizado.
    }
    else
    {
        System.out.println("Login ou senha incorretos"); //se nao for igual,o login é negado e volta para a senha e login anteriores.
        login=LoginAtual;
        senha=SenhaAtual;
    }

}
}

package application;
import entities.Biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do{
            System.out.println("[1] Cadastrar entities.Livro");
            System.out.println("[2] Listar entities.Livro");
            System.out.println("[3] Buscar entities.Livro");
            System.out.println("[4] Emprestar entities.Livro");
            System.out.println("[5] Remover entities.Livro");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao){
                case 1:

                    System.out.println("Digite o titulo do livro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o autor do livro " + titulo + ": ");
                    String autor = sc.nextLine();
                    System.out.println("Digite o id do livro " + titulo + ": ");
                    Integer id = sc.nextInt();

                    System.out.println("Digite o ano do livro " + titulo + ": ");
                    Integer ano = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a data de empréstimo do livro " + titulo + ": ");
                    String date = sc.nextLine();
                    try{
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // falha aqui
                        LocalDate data = LocalDate.parse(date,formatter);
                        biblioteca.adicionarLivro(id,titulo,autor,ano,data);
                    }catch (Exception err){
                        System.out.println(Cores.RED + "Formato inválido! Use (dd/MM/yyyy)" + Cores.RESET);
                    }
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.println("Buscar o livro por (titulo / id): ");
                    String tipo = sc.nextLine().toLowerCase();

                    if(tipo.equals("titulo")){
                        System.out.println("Digite o titulo do livro: ");
                        String tituloLivro = sc.nextLine();
                        System.out.println(biblioteca.buscarPorTitulo(tituloLivro));
                    }
                    else if(tipo.equals("id")){
                        System.out.println("Digite o id do livro: ");
                        Integer idLivro = sc.nextInt();
                        System.out.println(biblioteca.buscarPorId(idLivro));
                    }
                    break;
                case 4:
                    System.out.println("Digite o id do livro: ");
                    Integer idEmprestar = sc.nextInt();
                    sc.nextLine();
                    biblioteca.emprestarLivro(idEmprestar);
                    break;
                case 5:
                    System.out.println("Digite o id do livro para remover: ");
                    Integer idRemover = sc.nextInt();
                    biblioteca.removerLivro(idRemover);
                    break;
            }
        }while (opcao != 0);
        System.out.println("==================================");
        System.out.println(Cores.BLUE + "VOCÊ SAIU DO SISTEMA DA BIBLIOTECA" + Cores.RESET);
        System.out.println("==================================");
        sc.close();
    }
}

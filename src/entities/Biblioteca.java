package entities;

import application.Cores;
import entites.enums.StatusLivro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Integer id, String titulo, String autor, Integer ano, LocalDate dataEmprestimo){
        Livro livro = new Livro(id,titulo,autor,ano,dataEmprestimo);
        livros.add(livro);
        System.out.println(Cores.GREEN + "entities.Livro " + "'" +  livro.getTitulo() +  "'" + " cadastrado com sucesso" + Cores.RESET);
    }

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("------------------");
            System.out.println(Cores.YELLOW + "A lista está vazia" + Cores.RESET);
            System.out.println("------------------");
            return;
        }
        System.out.println("Lista dos Livros");
        for(Livro livro : livros){
            System.out.println("================");
            System.out.println(Cores.BLUE + livro + Cores.RESET);
            System.out.println("================");
        }
    }

    public Livro buscarPorTitulo(String tituloLivro){
        return getLivros().stream().filter(l -> l.getTitulo().equals(tituloLivro)).findFirst().orElse(null);
    }

    public Livro buscarPorId(Integer id){
        return getLivros().stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    public void emprestarLivro(Integer id){
        Livro livro = buscarPorId(id);
        if(livro == null){
            System.out.println(Cores.YELLOW +  "entities.Livro não encontrado" + Cores.RESET);
            return;
        }
        if(livro.getStatus() == StatusLivro.EMPRESTADO){
            System.out.println("entities.Livro já está emprestado");
            return;
        }

        livro.setStatus(StatusLivro.EMPRESTADO);
        System.out.println(Cores.GREEN + "entities.Livro emprestado com sucesso" + Cores.RESET);
    }

    public void removerLivro(Integer id){
        Livro livro = buscarPorId(id);
        if(livro == null){
            System.out.println(Cores.YELLOW + "entities.Livro não encontrado" + Cores.RESET);
            return;
        }
        livros.remove(livro);
        System.out.println(Cores.GREEN + "entities.Livro removido com sucesso" + Cores.RESET);
    }

}

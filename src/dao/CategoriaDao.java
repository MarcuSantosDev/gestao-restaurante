package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Categoria;

public class CategoriaDao {
    private List<Categoria> categorias = new ArrayList<>();

    public void adicionar(Categoria categoria) {
        categorias.add(categoria);
    }

    public void remover(Categoria categoria) {
        categorias.remove(categoria);
    }

    public List<Categoria> listar() {
        return categorias;
    }

    public List<Categoria> buscarPorNome(String nome) {
        return categorias.stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}

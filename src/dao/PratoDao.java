package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Categoria;
import model.Prato;

public class PratoDao {
    private List<Prato> pratos = new ArrayList<>();

    public void adicionar(Prato prato) {
        pratos.add(prato);
    }

    public void remover(Prato prato) {
        pratos.remove(prato);
    }

    public List<Prato> listar() {
        return pratos;
    }

    public List<Prato> filtrar(String nome, Categoria categoria, Boolean disponivel) {
        return pratos.stream()
                .filter(p -> (nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase())))
                .filter(p -> (categoria == null || p.getCategoria().equals(categoria)))
                .filter(p -> (disponivel == null || p.isDisponivel() == disponivel))
                .collect(Collectors.toList());
    }
}

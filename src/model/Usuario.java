package model;

public class Usuario {
    private String nome;
    private String cargo;  // "gerente" ou "atendente"

    public Usuario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

/*************  ✨ Windsurf Command ⭐  *************/
    /**
     * Retorna o cargo do usu rio (gerente ou atendente).
     * 
     * @return o cargo do usu rio
     */
/*******  5c683a9d-5507-43a0-aa1f-77b1d11f0d8f  *******/
    public String getCargo() {
        return cargo;
    }

    public boolean isGerente() {
        return cargo.equalsIgnoreCase("gerente");
    }
}

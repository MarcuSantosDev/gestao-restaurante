// gerenc pedidos teste

enum StatusPedido {
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    ENTREGUE
}

class ItemPedido {
    private Prato prato;
    private int quantidade;

    public ItemPedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return prato.getPreco() * quantidade;
    }
}

class Pedido {
    private static int contador = 1;
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.status = StatusPedido.RECEBIDO;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }
}

class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    public Pedido criarPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
        cliente.adicionarPedido(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    public Optional<Pedido> buscarPorId(int id) {
        return pedidos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void atualizarStatus(int idPedido, StatusPedido novoStatus) {
        buscarPorId(idPedido).ifPresent(p -> p.setStatus(novoStatus));
    }

    public void adicionarItemPedido(int idPedido, Prato prato, int quantidade) {
        buscarPorId(idPedido).ifPresent(p -> p.adicionarItem(new ItemPedido(prato, quantidade)));
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("Pedido ID: " + pedido.getId() + " - Cliente: " + pedido.getCliente().getNome());
        System.out.println("Status: " + pedido.getStatus());
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("- %s x%d: R$%.2f\n", item.getPrato().getNome(), item.getQuantidade(), item.getSubtotal());
        }
        System.out.printf("Total: R$%.2f\n", pedido.calcularTotal());
    }

    public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
        List<Pedido> lista = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getCliente().equals(cliente)) {
                lista.add(p);
            }
        }
        return lista;
    }
}

class Prato {
    private static int contador = 1;
    private int id;
    private String nome;
    private double preco;
    private Categoria categoria;
    private boolean disponivel;

    public Prato(String nome, double preco, Categoria categoria, boolean disponivel) {
        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

class Categoria {
    private static int contador = 1;
    private int id;
    private String nome;

    public Categoria(String nome) {
        this.id = contador++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
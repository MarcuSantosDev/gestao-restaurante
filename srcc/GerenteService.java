gerenteservice.java 

public Gerente cadastrarGerente(String nome)
public Optional<Gerente> buscarPorId(int id)

ClienteService clienteService = new ClienteService();
FuncionarioService funcionarioService = new FuncionarioService();
GerenteService gerenteService = new GerenteService();
PedidoService pedidoService = new PedidoService();


Optional<Gerente> gerenteOpt = gerenteService.buscarPorId(idGerente);
Optional<Cliente> clienteOpt = clienteService.buscarPorId(idCliente);

if (gerenteOpt.isPresent() && clienteOpt.isPresent()) {
    gerenteOpt.get().fecharComanda(clienteOpt.get());
}
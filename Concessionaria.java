import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    private String nome;
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Venda> vendas;

    public Concessionaria(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }

    public Veiculo buscarVeiculoPorModelo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public PessoaFisica buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) cliente;
                if (pessoaFisica.getCpf().equals(cpf)) {
                    return pessoaFisica;
                }
            }
        }
        return null;
    }

    public PessoaJuridica buscarClientePorCNPJ(String cnpj) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
                if (pessoaJuridica.getCnpj().equals(cnpj)) {
                    return pessoaJuridica;
                }
            }
        }
        return null;
    }

    public void realizarVenda(Veiculo veiculo, Cliente cliente, double valor) {
        if (veiculo == null || cliente == null) {
            throw new IllegalArgumentException("Veículo e cliente não podem ser nulos!");
        }

        if (!veiculo.isDisponivel()) {
            throw new IllegalStateException("Este veículo já foi vendido!");
        }

        Venda venda = new Venda(veiculo, cliente, valor);
        vendas.add(venda);
    }

    public List<Venda> listarVendas() {
        return new ArrayList<>(vendas);
    }
}
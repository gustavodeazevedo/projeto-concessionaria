import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Venda {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate dataVenda;
    private double valorVenda;

    public Venda(Veiculo veiculo, Cliente cliente, double valorVenda) {
        if (!veiculo.isDisponivel()) {
            throw new IllegalStateException("Este veículo já foi vendido!");
        }

        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataVenda = LocalDate.now();
        this.valorVenda = valorVenda;
        veiculo.realizarVenda(cliente);
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void exibirInformacoes() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=== INFORMAÇÕES DA VENDA ===");
        System.out.println("Veículo: " + veiculo.getModelo() + " (" + veiculo.getFabricante() + ")");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data da Venda: " + dataVenda.format(formatador));
        System.out.println("Valor da Venda: R$ " + String.format("%.2f", valorVenda));
    }
}
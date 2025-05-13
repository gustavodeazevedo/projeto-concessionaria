import java.time.LocalDate;

public abstract class Veiculo {
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String tipo;
    private boolean disponivel;
    private Cliente clienteComprador;
    private LocalDate dataVenda;

    public Veiculo(String modelo, String fabricante, int anoFabricacao, String tipo) {
        this.modelo = modelo;
        this.fabricante = fabricante;

        if (anoFabricacao > 2025) {
            throw new IllegalArgumentException("Ano de fabricação não pode ser superior a 2025");
        }
        this.anoFabricacao = anoFabricacao;

        this.tipo = tipo;
        this.disponivel = true;
        this.clienteComprador = null;
        this.dataVenda = null;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao > 2025) {
            throw new IllegalArgumentException("Ano de fabricação não pode ser superior a 2025");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(Cliente clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void realizarVenda(Cliente cliente) {
        if (!disponivel) {
            throw new IllegalStateException("Este veículo já foi vendido!");
        }

        this.clienteComprador = cliente;
        this.disponivel = false;
        this.dataVenda = LocalDate.now();
    }

    public abstract void exibirInformacoes();

    public String getStatus() {
        return disponivel ? "Disponível" : "Vendido";
    }
}
public class Carro extends Veiculo {
    private int numeroPortas;
    private String tipoCombustivel;

    public Carro(String modelo, String fabricante, int anoFabricacao, int numeroPortas, String tipoCombustivel) {
        super(modelo, fabricante, anoFabricacao, "Carro");
        this.numeroPortas = numeroPortas;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO CARRO ===");
        System.out.println("Modelo: " + getModelo());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Ano de Fabricação: " + getAnoFabricacao());
        System.out.println("Número de Portas: " + numeroPortas);
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
        System.out.println("Status: " + getStatus());

        if (!isDisponivel()) {
            System.out.println("Cliente Comprador: " + getClienteComprador().getNome());
            System.out.println("Data da Venda: " + getDataVenda());
        }
    }
}
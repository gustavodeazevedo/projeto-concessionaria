public class Moto extends Veiculo {
    private int cilindradas;
    private String tipoPartida;

    public Moto(String modelo, String fabricante, int anoFabricacao, int cilindradas, String tipoPartida) {
        super(modelo, fabricante, anoFabricacao, "Moto");
        this.cilindradas = cilindradas;
        this.tipoPartida = tipoPartida;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(String tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DA MOTO ===");
        System.out.println("Modelo: " + getModelo());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Ano de Fabricação: " + getAnoFabricacao());
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Tipo de Partida: " + tipoPartida);
        System.out.println("Status: " + getStatus());

        if (!isDisponivel()) {
            System.out.println("Cliente Comprador: " + getClienteComprador().getNome());
            System.out.println("Data da Venda: " + getDataVenda());
        }
    }
}
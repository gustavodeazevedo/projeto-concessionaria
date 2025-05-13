public class Utilitario extends Veiculo {
    private double capacidadeCarga;
    private String tipoCarroceria;

    public Utilitario(String modelo, String fabricante, int anoFabricacao, double capacidadeCarga,
            String tipoCarroceria) {
        super(modelo, fabricante, anoFabricacao, "Utilitário");
        this.capacidadeCarga = capacidadeCarga;
        this.tipoCarroceria = tipoCarroceria;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO UTILITÁRIO ===");
        System.out.println("Modelo: " + getModelo());
        System.out.println("Fabricante: " + getFabricante());
        System.out.println("Ano de Fabricação: " + getAnoFabricacao());
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " kg");
        System.out.println("Tipo de Carroceria: " + tipoCarroceria);
        System.out.println("Status: " + getStatus());

        if (!isDisponivel()) {
            System.out.println("Cliente Comprador: " + getClienteComprador().getNome());
            System.out.println("Data da Venda: " + getDataVenda());
        }
    }
}
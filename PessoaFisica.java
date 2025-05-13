public class PessoaFisica extends Cliente {
    private String cpf;
    private String rg;

    public PessoaFisica(String nome, String contato, String cpf, String rg) {
        super(nome, contato);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public boolean validarDocumentos() {
        return validarCPF(this.cpf);
    }

    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        return true;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DA PESSOA FÍSICA ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Contato: " + getContato());
        System.out.println("CPF: " + cpf);
        System.out.println("RG: " + rg);
    }
}
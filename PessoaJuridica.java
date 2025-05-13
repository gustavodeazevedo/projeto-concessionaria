public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String nome, String contato, String cnpj, String razaoSocial) {
        super(nome, contato);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (!validarCNPJ(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido!");
        }
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean validarDocumentos() {
        return validarCNPJ(this.cnpj);
    }

    private boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        boolean todosDigitosIguais = true;
        for (int i = 1; i < cnpj.length(); i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
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
        System.out.println("=== INFORMAÇÕES DA PESSOA JURÍDICA ===");
        System.out.println("Nome Fantasia: " + getNome());
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("Contato: " + getContato());
        System.out.println("CNPJ: " + cnpj);
    }
}
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
   Projeto: Sistema de Concessionária de Veículos
 
   Integrantes do Grupo:
  - Gustavo de Azevedo - RA: 922116143
  - Gabriel Silva Moraes- RA: 923100677
  - Felipe Brito da Silva - RA: 922201294
  - Pablo Henrique da Silva Nunes  - RA: 922200441
  - Marcelo Miguel Silva Reis - RA: 924200105
  - Vinicius Lordelo de Lima - RA: 922203037
  - Pedro Vinicius Fontes - RA: 922102822 
  - Vinicius Santos Leal Souza - RA: 924203022
  - Kauan Souza dos Anjos - RA: 924120152
  
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Concessionaria concessionaria = new Concessionaria("AutoShop");

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Concessionária!");
        System.out.println("Concessionária: " + concessionaria.getNome());

        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            try {
                processarOpcao(opcao);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("\nErro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro inesperado: " + e.getMessage());
            }

            if (opcao != 13) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 13);

        System.out.println("Obrigado por utilizar o sistema! Até logo!");
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n====== MENU PRINCIPAL ======");
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Cadastrar Cliente (Pessoa Física / Jurídica)");
        System.out.println("3 - Editar Veículo");
        System.out.println("4 - Editar Cliente");
        System.out.println("5 - Atualizar Veículo");
        System.out.println("6 - Atualizar Cliente");
        System.out.println("7 - Deletar Veículo");
        System.out.println("8 - Deletar Cliente");
        System.out.println("9 - Listar Veículos");
        System.out.println("10 - Listar Clientes");
        System.out.println("11 - Realizar Venda");
        System.out.println("12 - Ver Histórico de Vendas");
        System.out.println("13 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarVeiculo();
                break;
            case 2:
                cadastrarCliente();
                break;
            case 3:
                editarVeiculo();
                break;
            case 4:
                editarCliente();
                break;
            case 5:
                atualizarVeiculo();
                break;
            case 6:
                atualizarCliente();
                break;
            case 7:
                deletarVeiculo();
                break;
            case 8:
                deletarCliente();
                break;
            case 9:
                listarVeiculos();
                break;
            case 10:
                listarClientes();
                break;
            case 11:
                realizarVenda();
                break;
            case 12:
                verHistoricoVendas();
                break;
            case 13:
                // Sair
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        }
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n=== CADASTRO DE VEÍCULO ===");
        System.out.println("Tipo de veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Utilitário");
        System.out.print("Escolha o tipo: ");

        int tipo = lerOpcao();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de veículo inválido!");
            return;
        }

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();

        int anoFabricacao = 0;
        try {
            System.out.print("Ano de Fabricação: ");
            anoFabricacao = scanner.nextInt();
            scanner.nextLine();

            if (anoFabricacao > 2025) {
                System.out.println("Ano de fabricação não pode ser superior a 2025!");
                return;
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Ano de fabricação inválido!");
            return;
        }

        switch (tipo) {
            case 1:
                cadastrarCarro(modelo, fabricante, anoFabricacao);
                break;
            case 2:
                cadastrarMoto(modelo, fabricante, anoFabricacao);
                break;
            case 3:
                cadastrarUtilitario(modelo, fabricante, anoFabricacao);
                break;
        }
    }

    private static void cadastrarCarro(String modelo, String fabricante, int anoFabricacao) {
        int numeroPortas = 0;
        try {
            System.out.print("Número de Portas: ");
            numeroPortas = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Número de portas inválido!");
            return;
        }

        System.out.print("Tipo de Combustível: ");
        String tipoCombustivel = scanner.nextLine();

        Carro carro = new Carro(modelo, fabricante, anoFabricacao, numeroPortas, tipoCombustivel);
        concessionaria.adicionarVeiculo(carro);

        System.out.println("Carro cadastrado com sucesso!");
    }

    private static void cadastrarMoto(String modelo, String fabricante, int anoFabricacao) {
        int cilindradas = 0;
        try {
            System.out.print("Cilindradas: ");
            cilindradas = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Cilindradas inválidas!");
            return;
        }

        System.out.print("Tipo de Partida: ");
        String tipoPartida = scanner.nextLine();

        Moto moto = new Moto(modelo, fabricante, anoFabricacao, cilindradas, tipoPartida);
        concessionaria.adicionarVeiculo(moto);

        System.out.println("Moto cadastrada com sucesso!");
    }

    private static void cadastrarUtilitario(String modelo, String fabricante, int anoFabricacao) {
        double capacidadeCarga = 0;
        try {
            System.out.print("Capacidade de Carga (kg): ");
            capacidadeCarga = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Capacidade de carga inválida!");
            return;
        }

        System.out.print("Tipo de Carroceria: ");
        String tipoCarroceria = scanner.nextLine();

        Utilitario utilitario = new Utilitario(modelo, fabricante, anoFabricacao, capacidadeCarga, tipoCarroceria);
        concessionaria.adicionarVeiculo(utilitario);

        System.out.println("Utilitário cadastrado com sucesso!");
    }

    private static void cadastrarCliente() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.println("Tipo de cliente:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.print("Escolha o tipo: ");

        int tipo = lerOpcao();

        if (tipo < 1 || tipo > 2) {
            System.out.println("Tipo de cliente inválido!");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        switch (tipo) {
            case 1:
                cadastrarPessoaFisica(nome, contato);
                break;
            case 2:
                cadastrarPessoaJuridica(nome, contato);
                break;
        }
    }

    private static void cadastrarPessoaFisica(String nome, String contato) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("RG: ");
        String rg = scanner.nextLine();

        try {
            PessoaFisica pessoaFisica = new PessoaFisica(nome, contato, cpf, rg);

            if (!pessoaFisica.validarDocumentos()) {
                System.out.println("CPF inválido!");
                return;
            }

            concessionaria.adicionarCliente(pessoaFisica);
            System.out.println("Pessoa Física cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void cadastrarPessoaJuridica(String nome, String contato) {
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();

        try {
            PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, contato, cnpj, razaoSocial);

            if (!pessoaJuridica.validarDocumentos()) {
                System.out.println("CNPJ inválido!");
                return;
            }

            concessionaria.adicionarCliente(pessoaJuridica);
            System.out.println("Pessoa Jurídica cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void editarVeiculo() {
        System.out.println("\n=== EDITAR VEÍCULO ===");

        List<Veiculo> veiculos = concessionaria.listarVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
            return;
        }

        System.out.println("Veículos disponíveis:");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            System.out.println((i + 1) + " - " + veiculo.getModelo() + " (" + veiculo.getFabricante() + ") - "
                    + veiculo.getStatus());
        }

        System.out.print("Escolha o veículo para editar (0 para cancelar): ");
        int indice = lerOpcao() - 1;

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Veiculo veiculo = veiculos.get(indice);

        System.out.print("Novo Modelo (atual: " + veiculo.getModelo() + "): ");
        String novoModelo = scanner.nextLine();
        if (!novoModelo.isEmpty()) {
            veiculo.setModelo(novoModelo);
        }

        System.out.print("Novo Fabricante (atual: " + veiculo.getFabricante() + "): ");
        String novoFabricante = scanner.nextLine();
        if (!novoFabricante.isEmpty()) {
            veiculo.setFabricante(novoFabricante);
        }

        System.out.print("Novo Ano de Fabricação (atual: " + veiculo.getAnoFabricacao() + "): ");
        String novoAnoStr = scanner.nextLine();
        if (!novoAnoStr.isEmpty()) {
            try {
                int novoAno = Integer.parseInt(novoAnoStr);
                veiculo.setAnoFabricacao(novoAno);
            } catch (NumberFormatException e) {
                System.out.println("Ano inválido! Este campo não foi atualizado.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Este campo não foi atualizado.");
            }
        }

        if (veiculo instanceof Carro) {
            editarCarro((Carro) veiculo);
        } else if (veiculo instanceof Moto) {
            editarMoto((Moto) veiculo);
        } else if (veiculo instanceof Utilitario) {
            editarUtilitario((Utilitario) veiculo);
        }

        System.out.println("Veículo editado com sucesso!");
    }

    private static void editarCarro(Carro carro) {
        System.out.print("Novo Número de Portas (atual: " + carro.getNumeroPortas() + "): ");
        String novoNumeroPortasStr = scanner.nextLine();

        if (!novoNumeroPortasStr.isEmpty()) {
            try {
                int novoNumeroPortas = Integer.parseInt(novoNumeroPortasStr);
                carro.setNumeroPortas(novoNumeroPortas);
            } catch (NumberFormatException e) {
                System.out.println("Número de portas inválido! Este campo não foi atualizado.");
            }
        }

        System.out.print("Novo Tipo de Combustível (atual: " + carro.getTipoCombustivel() + "): ");
        String novoTipoCombustivel = scanner.nextLine();

        if (!novoTipoCombustivel.isEmpty()) {
            carro.setTipoCombustivel(novoTipoCombustivel);
        }
    }

    private static void editarMoto(Moto moto) {
        System.out.print("Novas Cilindradas (atual: " + moto.getCilindradas() + "): ");
        String novasCilindradasStr = scanner.nextLine();

        if (!novasCilindradasStr.isEmpty()) {
            try {
                int novasCilindradas = Integer.parseInt(novasCilindradasStr);
                moto.setCilindradas(novasCilindradas);
            } catch (NumberFormatException e) {
                System.out.println("Cilindradas inválidas! Este campo não foi atualizado.");
            }
        }

        System.out.print("Novo Tipo de Partida (atual: " + moto.getTipoPartida() + "): ");
        String novoTipoPartida = scanner.nextLine();

        if (!novoTipoPartida.isEmpty()) {
            moto.setTipoPartida(novoTipoPartida);
        }
    }

    private static void editarUtilitario(Utilitario utilitario) {
        System.out.print("Nova Capacidade de Carga (atual: " + utilitario.getCapacidadeCarga() + " kg): ");
        String novaCapacidadeStr = scanner.nextLine();

        if (!novaCapacidadeStr.isEmpty()) {
            try {
                double novaCapacidade = Double.parseDouble(novaCapacidadeStr);
                utilitario.setCapacidadeCarga(novaCapacidade);
            } catch (NumberFormatException e) {
                System.out.println("Capacidade de carga inválida! Este campo não foi atualizado.");
            }
        }

        System.out.print("Novo Tipo de Carroceria (atual: " + utilitario.getTipoCarroceria() + "): ");
        String novoTipoCarroceria = scanner.nextLine();

        if (!novoTipoCarroceria.isEmpty()) {
            utilitario.setTipoCarroceria(novoTipoCarroceria);
        }
    }

    private static void editarCliente() {
        System.out.println("\n=== EDITAR CLIENTE ===");

        List<Cliente> clientes = concessionaria.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            String tipo = cliente instanceof PessoaFisica ? "Pessoa Física" : "Pessoa Jurídica";
            System.out.println((i + 1) + " - " + cliente.getNome() + " (" + tipo + ")");
        }

        System.out.print("Escolha o cliente para editar (0 para cancelar): ");
        int indice = lerOpcao() - 1;

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Cliente cliente = clientes.get(indice);

        System.out.print("Novo Nome (atual: " + cliente.getNome() + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) {
            cliente.setNome(novoNome);
        }

        System.out.print("Novo Contato (atual: " + cliente.getContato() + "): ");
        String novoContato = scanner.nextLine();
        if (!novoContato.isEmpty()) {
            cliente.setContato(novoContato);
        }

        if (cliente instanceof PessoaFisica) {
            editarPessoaFisica((PessoaFisica) cliente);
        } else if (cliente instanceof PessoaJuridica) {
            editarPessoaJuridica((PessoaJuridica) cliente);
        }

        System.out.println("Cliente editado com sucesso!");
    }

    private static void editarPessoaFisica(PessoaFisica pessoaFisica) {
        System.out.print("Novo CPF (atual: " + pessoaFisica.getCpf() + "): ");
        String novoCPF = scanner.nextLine();

        if (!novoCPF.isEmpty()) {
            try {
                pessoaFisica.setCpf(novoCPF);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Este campo não foi atualizado.");
            }
        }

        System.out.print("Novo RG (atual: " + pessoaFisica.getRg() + "): ");
        String novoRG = scanner.nextLine();

        if (!novoRG.isEmpty()) {
            pessoaFisica.setRg(novoRG);
        }
    }

    private static void editarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        System.out.print("Novo CNPJ (atual: " + pessoaJuridica.getCnpj() + "): ");
        String novoCNPJ = scanner.nextLine();

        if (!novoCNPJ.isEmpty()) {
            try {
                pessoaJuridica.setCnpj(novoCNPJ);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Este campo não foi atualizado.");
            }
        }

        System.out.print("Nova Razão Social (atual: " + pessoaJuridica.getRazaoSocial() + "): ");
        String novaRazaoSocial = scanner.nextLine();

        if (!novaRazaoSocial.isEmpty()) {
            pessoaJuridica.setRazaoSocial(novaRazaoSocial);
        }
    }

    private static void atualizarVeiculo() {
        editarVeiculo();
    }

    private static void atualizarCliente() {
        editarCliente();
    }

    private static void deletarVeiculo() {
        System.out.println("\n=== DELETAR VEÍCULO ===");

        List<Veiculo> veiculos = concessionaria.listarVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
            return;
        }

        System.out.println("Veículos disponíveis:");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            System.out.println((i + 1) + " - " + veiculo.getModelo() + " (" + veiculo.getFabricante() + ") - "
                    + veiculo.getStatus());
        }

        System.out.print("Escolha o veículo para deletar (0 para cancelar): ");
        int indice = lerOpcao() - 1;

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Veiculo veiculo = veiculos.get(indice);

        if (!veiculo.isDisponivel()) {
            System.out.println("Não é possível deletar um veículo que já foi vendido!");
            return;
        }

        concessionaria.removerVeiculo(veiculo);
        System.out.println("Veículo deletado com sucesso!");
    }

    private static void deletarCliente() {
        System.out.println("\n=== DELETAR CLIENTE ===");

        List<Cliente> clientes = concessionaria.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            String tipo = cliente instanceof PessoaFisica ? "Pessoa Física" : "Pessoa Jurídica";
            System.out.println((i + 1) + " - " + cliente.getNome() + " (" + tipo + ")");
        }

        System.out.print("Escolha o cliente para deletar (0 para cancelar): ");
        int indice = lerOpcao() - 1;

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Cliente cliente = clientes.get(indice);

        boolean clienteTemVeiculos = false;
        for (Veiculo veiculo : concessionaria.listarVeiculos()) {
            if (!veiculo.isDisponivel() && veiculo.getClienteComprador() == cliente) {
                clienteTemVeiculos = true;
                break;
            }
        }

        if (clienteTemVeiculos) {
            System.out.println("Não é possível deletar um cliente que possui veículos comprados!");
            return;
        }

        concessionaria.removerCliente(cliente);
        System.out.println("Cliente deletado com sucesso!");
    }

    private static void listarVeiculos() {
        System.out.println("\n=== LISTA DE VEÍCULOS ===");

        List<Veiculo> veiculos = concessionaria.listarVeiculos();

        if (veiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
            return;
        }

        System.out.println("Filtrar por:");
        System.out.println("1 - Todos os veículos");
        System.out.println("2 - Apenas disponíveis");
        System.out.println("3 - Apenas vendidos");
        System.out.print("Escolha uma opção: ");

        int opcao = lerOpcao();

        switch (opcao) {
            case 1:
                listarTodosVeiculos(veiculos);
                break;
            case 2:
                listarVeiculosPorStatus(veiculos, true);
                break;
            case 3:
                listarVeiculosPorStatus(veiculos, false);
                break;
            default:
                System.out.println("Opção inválida! Mostrando todos os veículos.");
                listarTodosVeiculos(veiculos);
        }
    }

    private static void listarTodosVeiculos(List<Veiculo> veiculos) {
        System.out.println("\n--- TODOS OS VEÍCULOS ---");

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }

    private static void listarVeiculosPorStatus(List<Veiculo> veiculos, boolean disponivel) {
        String status = disponivel ? "DISPONÍVEIS" : "VENDIDOS";
        System.out.println("\n--- VEÍCULOS " + status + " ---");

        boolean encontrou = false;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel() == disponivel) {
                veiculo.exibirInformacoes();
                System.out.println("-------------------------");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum veículo " + (disponivel ? "disponível" : "vendido") + " encontrado!");
        }
    }

    private static void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");

        List<Cliente> clientes = concessionaria.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        System.out.println("Filtrar por:");
        System.out.println("1 - Todos os clientes");
        System.out.println("2 - Apenas pessoas físicas");
        System.out.println("3 - Apenas pessoas jurídicas");
        System.out.print("Escolha uma opção: ");

        int opcao = lerOpcao();

        switch (opcao) {
            case 1:
                listarTodosClientes(clientes);
                break;
            case 2:
                listarClientesPorTipo(clientes, PessoaFisica.class);
                break;
            case 3:
                listarClientesPorTipo(clientes, PessoaJuridica.class);
                break;
            default:
                System.out.println("Opção inválida! Mostrando todos os clientes.");
                listarTodosClientes(clientes);
        }
    }

    private static void listarTodosClientes(List<Cliente> clientes) {
        System.out.println("\n--- TODOS OS CLIENTES ---");

        for (Cliente cliente : clientes) {
            cliente.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }

    private static <T> void listarClientesPorTipo(List<Cliente> clientes, Class<T> tipo) {
        String tipoCliente = tipo == PessoaFisica.class ? "FÍSICAS" : "JURÍDICAS";
        System.out.println("\n--- PESSOAS " + tipoCliente + " ---");

        boolean encontrou = false;

        for (Cliente cliente : clientes) {
            if (tipo.isInstance(cliente)) {
                cliente.exibirInformacoes();
                System.out.println("-------------------------");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out
                    .println("Nenhuma pessoa " + (tipo == PessoaFisica.class ? "física" : "jurídica") + " encontrada!");
        }
    }

    private static void realizarVenda() {
        System.out.println("\n=== REALIZAR VENDA ===");

        List<Veiculo> veiculosDisponiveis = concessionaria.listarVeiculosDisponiveis();

        if (veiculosDisponiveis.isEmpty()) {
            System.out.println("Não há veículos disponíveis para venda!");
            return;
        }

        System.out.println("Veículos disponíveis para venda:");
        for (int i = 0; i < veiculosDisponiveis.size(); i++) {
            Veiculo veiculo = veiculosDisponiveis.get(i);
            System.out.println((i + 1) + " - " + veiculo.getModelo() + " (" + veiculo.getFabricante() + ")");
        }

        System.out.print("Escolha o veículo para venda (0 para cancelar): ");
        int indiceVeiculo = lerOpcao() - 1;

        if (indiceVeiculo < 0 || indiceVeiculo >= veiculosDisponiveis.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Veiculo veiculo = veiculosDisponiveis.get(indiceVeiculo);

        List<Cliente> clientes = concessionaria.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados! Cadastre um cliente antes de realizar a venda.");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            String tipo = cliente instanceof PessoaFisica ? "Pessoa Física" : "Pessoa Jurídica";
            System.out.println((i + 1) + " - " + cliente.getNome() + " (" + tipo + ")");
        }

        System.out.print("Escolha o cliente comprador (0 para cancelar): ");
        int indiceCliente = lerOpcao() - 1;

        if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
            System.out.println("Opção inválida ou cancelada!");
            return;
        }

        Cliente cliente = clientes.get(indiceCliente);

        double valorVenda = 0;
        try {
            System.out.print("Valor da venda: R$ ");
            valorVenda = scanner.nextDouble();
            scanner.nextLine();

            if (valorVenda <= 0) {
                System.out.println("O valor da venda deve ser maior que zero!");
                return;
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Valor inválido!");
            return;
        }

        System.out.println("\nConfirmar venda:");
        System.out.println("Veículo: " + veiculo.getModelo() + " (" + veiculo.getFabricante() + ")");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Valor: R$ " + String.format("%.2f", valorVenda));
        System.out.print("Confirmar? (S/N): ");

        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            try {
                concessionaria.realizarVenda(veiculo, cliente, valorVenda);
                System.out.println("Venda realizada com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao realizar venda: " + e.getMessage());
            }
        } else {
            System.out.println("Venda cancelada!");
        }
    }

    private static void verHistoricoVendas() {
        System.out.println("\n=== HISTÓRICO DE VENDAS ===");

        List<Venda> vendas = concessionaria.listarVendas();

        if (vendas.isEmpty()) {
            System.out.println("Não há vendas registradas!");
            return;
        }

        for (Venda venda : vendas) {
            venda.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }
}
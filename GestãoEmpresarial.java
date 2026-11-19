package AULA.DEVDOJO.POO;

public class GestãoEmpresarial {

    public static abstract class Funcionario {
        private String nome;
        private String cpf;
        private double salario;

        public Funcionario(String nome, String cpf, double salario) {
            setNome(nome);
            setCpf(cpf);
            setSalario(salario);
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public double getSalario() {
            return salario;
        }

        public void setCpf(String cpf) {
            if (cpf == null || cpf.isEmpty()) {
                throw new IllegalArgumentException("O CPF não pode ser vazio.");
            } else if (cpf.length() != 11) {
                throw new IllegalArgumentException("Formato incorreto de CPF, tem que ser 11 dígitos.");
            }
            this.cpf = cpf;
        }

        public void setNome(String nome) {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("O nome não pode ser vazio.");
            }
            this.nome = nome;
        }

        public void setSalario(double salario) {
            if (salario <= 0) {
                throw new IllegalArgumentException("O salário deve ser maior que zero.");
            }
            this.salario = salario;
        }

        public abstract void calcularSalario();
    }

    public static class Gerente extends Funcionario {
        private double bonusCargo;

        public Gerente(String nome, String cpf, double salario, double bonusCargo) {
            super(nome, cpf, salario);
            setBonusCargo(bonusCargo);
        }

        public double getBonusCargo() {
            return bonusCargo;
        }

        public void setBonusCargo(double bonusCargo) {
            if (bonusCargo < 0) {
                throw new IllegalArgumentException("O bônus do cargo não pode ser negativo.");
            }
            this.bonusCargo = bonusCargo;
        }

        @Override
        public void calcularSalario() {
            double valorTotal = getSalario() + this.bonusCargo;
            System.out.println("Gerente: " + getNome() + " | Salário Final: R$ " + valorTotal);
        }
    }

    public static class Desenvolvedor extends Funcionario {
        private double horasExtras;

        public Desenvolvedor(String nome, String cpf, double salario, double horasExtras) {
            super(nome, cpf, salario);
            setHorasExtras(horasExtras);
        }

        public double getHorasExtras() {
            return horasExtras;
        }

        public void setHorasExtras(double horasExtras) {
            if (horasExtras < 0) {
                throw new IllegalArgumentException("As horas extras não podem ser negativas.");
            }
            this.horasExtras = horasExtras;
        }

        @Override
        public void calcularSalario() {
            double salarioTotal = getSalario() + this.horasExtras;
            System.out.println("Desenvolvedor: " + getNome() + " | Salário Final: R$ " + salarioTotal);
        }
    }

    public static class Estagiario extends Funcionario {
        private double bolsaAuxilio;

        public Estagiario(String nome, String cpf, double salario, double bolsaAuxilio) {
            super(nome, cpf, salario);
            setBolsaAuxilio(bolsaAuxilio);
        }

        public double getBolsaAuxilio() {
            return bolsaAuxilio;
        }

        public void setBolsaAuxilio(double bolsaAuxilio) {
            if (bolsaAuxilio <= 0) {
                throw new IllegalArgumentException("A bolsa auxílio deve ser maior que zero.");
            }
            this.bolsaAuxilio = bolsaAuxilio;
        }

        @Override
        public void calcularSalario() {
            double salarioTotal = getSalario() + this.bolsaAuxilio;
            System.out.println("Estagiário: " + getNome() + " | Salário Final: R$ " + salarioTotal);
        }
    }

    public static class Vendedor extends Funcionario {
        private double comissao;

        public Vendedor(String nome, String cpf, double salario, double comissao) {
            super(nome, cpf, salario);
            setComissao(comissao);
        }

        public double getComissao() {
            return comissao;
        }

        public void setComissao(double comissao) {
            if (comissao < 0) {
                throw new IllegalArgumentException("O valor da comissão não pode ser negativo.");
            }
            this.comissao = comissao;
        }

        public void calcularComissao(double... vendas) {
            this.comissao = 0;
            for (double valorVenda : vendas) {
                if (valorVenda < 0) {
                    throw new IllegalArgumentException("O valor da venda não pode ser negativo.");
                }
                this.comissao += valorVenda * 0.04;
            }
        }

        @Override
        public void calcularSalario() {
            double salarioFinal = getSalario() + this.comissao;
            System.out.println("Vendedor: " + getNome() + " | Comissão (4%): R$ " + comissao + " | Salário Final: R$ " + salarioFinal);
        }
        
    }
    public static void main(String[] args) {
        System.out.println("=== TESTE DE FOLHA DE PAGAMENTO (POLIMORFISMO) ===");

        Funcionario gerente = new Gerente("Carlos Silva", "12345678901", 6000.0, 1500.0);
        Funcionario dev = new Desenvolvedor("Marcelo Júnior", "98765432100", 4500.0, 800.0);
        Funcionario estagiario = new Estagiario("Lucas Alves", "11122233344", 1200.0, 400.0);
        Vendedor vendedor = new Vendedor("Ana Souza", "55566677788", 2500.0, 0.0);


        vendedor.calcularComissao(1000.0, 2500.0, 1500.0);


        Funcionario[] equipe = {gerente, dev, estagiario, vendedor};

        for (Funcionario f : equipe) {
            f.calcularSalario();
        }

        System.out.println("\n=== TESTE DE VALIDAÇÕES (FAIL-FAST) ===");
        try {
            new Gerente("Erro CPF", "123", 5000.0, 500.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado com sucesso: " + e.getMessage());
        }

        try {
            new Desenvolvedor("Erro Salário", "12345678901", -1000.0, 0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado com sucesso: " + e.getMessage());
        }
    }
}

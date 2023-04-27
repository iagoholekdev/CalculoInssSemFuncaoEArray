import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String name;
        String cpf;
        String email;
        String dateBorn;
        String phone;

        do {
            System.out.println("Digite seu nome: ");
            name = myScanner.nextLine();
        } while (name.isEmpty());


        do {
            System.out.println("Digite seu CPF: ");
            cpf = myScanner.nextLine();
        } while (cpf.isEmpty());


        do {
            System.out.println("Digite seu email: ");
            email = myScanner.nextLine();
        } while (email.isEmpty());

        do {
            System.out.println("Digite sua data de nascimento: ");
            dateBorn = myScanner.nextLine();
        } while (dateBorn.isEmpty());

        do {
            System.out.println("Digite seu telefone: ");
            phone = myScanner.nextLine();
        } while (phone.isEmpty());

        final int firstMouth = 1;
        final int lastMouth = 12;
        double acumuladoINSS = 0;
        double acumuladoIRPF = 0;
        String nomeDoMes;

        for (int index = firstMouth; index <= lastMouth; index++) {
            switch (index) {
                case 1 -> nomeDoMes = "Janeiro";
                case 2 -> nomeDoMes = "Fevereiro";
                case 3 -> nomeDoMes = "Março";
                case 4 -> nomeDoMes = "Abril";
                case 5 -> nomeDoMes = "Maio";
                case 6 -> nomeDoMes = "Junho";
                case 7 -> nomeDoMes = "Julho";
                case 8 -> nomeDoMes = "Agosto";
                case 9 -> nomeDoMes = "Setembro";
                case 10 -> nomeDoMes = "Outubro";
                case 11 -> nomeDoMes =  "Novembro";
                case 12 -> nomeDoMes =  "Dezembro";
                default -> nomeDoMes = "";
            }

            System.out.print("Informe o salário de " + nomeDoMes + ": R$");
            double salario = myScanner.nextDouble();

            double inss;
            if (salario <= 1751.81) {
                inss = salario * 0.08;
            } else if (salario <= 2919.72) {
                inss = salario * 0.09;
            } else if (salario <= 5839.45) {
                inss = salario * 0.11;
            } else {
                inss = 5839.45 * 0.11;
            }

            acumuladoINSS += inss;

            double irpf;
            double baseCalculo = salario - inss;

            if (baseCalculo <= 1903.98) {
                irpf = 0;
            } else if (baseCalculo <= 2826.65) {
                irpf = (baseCalculo * 0.075) - 142.80;
            } else if (baseCalculo <= 3751.05) {
                irpf = (baseCalculo * 0.15) - 354.80;
            } else if (baseCalculo <= 4664.68) {
                irpf = (baseCalculo * 0.225) - 636.13;
            } else {
                irpf = (baseCalculo * 0.275) - 869.36;
            }
            acumuladoIRPF += irpf;

            System.out.println("Mês: " + nomeDoMes);
            System.out.printf("INSS: R$ %.2f\n", inss);
            System.out.printf("IRPF: R$ %.2f\n", irpf);
        }

        System.out.printf("Acumulado anual do INSS: R$ %.2f\n", acumuladoINSS);
        System.out.printf("Acumulado anual do IRPF: R$ %.2f\n", acumuladoIRPF);

        myScanner.close();

    }
}
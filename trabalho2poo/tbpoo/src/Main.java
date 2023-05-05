import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Gastos gas = new Gastos();
        Ganhos gan = new Ganhos();
        DataDeGanhos dataDeGanho = new DataDeGanhos();
        DataDeGastos dataDeGasto = new DataDeGastos();
        RelatorioDeGastos relGastos = new RelatorioDeGastos();
        RelatorioDeGanhos relGanhos = new RelatorioDeGanhos();
        TotalDeGanhosEGastos total = new TotalDeGanhosEGastos();
        String pagamento = "";
        int count_gasto = 0;
        int count_ganho = 0;
       


        while(true) {
            System.out.println(" ");
            System.out.println("Gestão Financeira");
            System.out.println("-----------------------");
            System.out.println("1 - Adicionar Gastos");
            System.out.println("2 - Adicionar Ganhos");
            System.out.println("3 - Relatório de Gastos");
            System.out.println("4 - Relatório de Ganhos");
            System.out.println("5 - Relatório Mensal");
            System.out.println("6 - Sair");
            System.out.println(" ");
            System.out.println("Selecione uma opção: ");
            int resposta = scan.nextInt();



            if (resposta == 6) {
                System.out.println("Agradeço a ultilização do programa!");
                return;
            }
            if (resposta == 1) {
                System.out.println("Insira o nome do gasto:");
                scan.nextLine();
                String nomedeGasto = scan.nextLine();
                gas.setNomeDeGasto(nomedeGasto, count_gasto);
                System.out.println("Insira o tipo do gasto:");
                String tipodeGasto = scan.nextLine();
                gas.setTipoGasto(tipodeGasto, count_gasto);
                System.out.println("Insira o dia:");
                int dia = scan.nextInt();
                System.out.println("Insira o mês:");
                int mes = scan.nextInt();
                System.out.println("Insira o ano:");
                int ano = scan.nextInt();



                dataDeGasto.setDia(dia);
                dataDeGasto.setMes(mes);
                dataDeGasto.setAno(ano);
                dataDeGasto.setFormData(dia,mes,ano, count_gasto);



                System.out.println("Insira o valor do gasto:");
                double valordeGasto = scan.nextDouble();
                gas.setValorGasto(valordeGasto, count_gasto);
                System.out.println("Insira a forma de pagamento do gasto: \n1 - PIX\n2 - Boleto \n3 - Credito");
                int pagamentodeGasto = scan.nextInt();
                gas.setPagamentoGasto(pagamentodeGasto, count_gasto);



                while (pagamentodeGasto != 1 && pagamentodeGasto != 2 && pagamentodeGasto != 3) {
                    System.out.println("\n\nO valor inserido não é valido!");
                    System.out.println("Insira a forma de pagamento do gasto: \n1 - PIX\n2 - Boleto \n3 - Credito");
                    pagamentodeGasto = scan.nextInt();
                }



                System.out.printf("\n\n\n\n %30s: %15s","Nome",nomedeGasto);
                System.out.printf("\n %30s: %15s","Tipo",tipodeGasto);
                System.out.printf("\n %30s: %15s","Data",dataDeGasto.getFormData(count_gasto));
                System.out.printf("\n %30s: %15.2f","Valor",valordeGasto);
                System.out.printf("\n %30s: %15s\n\n\n\n","Forma de Pagamento",pagamentodeGasto);



                ++count_gasto;
            } else if (resposta == 2) {
                System.out.println("Insira o nome do ganho:");
                scan.nextLine();
                String nomedeGanho = scan.nextLine();
                gan.setNomeGanho(nomedeGanho, count_ganho);



                System.out.println("Insira o tipo do ganho:");
                String tipodeGanho = scan.nextLine();
                gan.setTipoGanho(tipodeGanho, count_ganho);



                System.out.println("Insira o dia:");
                int dia = scan.nextInt();
                System.out.println("Insira o mês:");
                int mes = scan.nextInt();
                System.out.println("Insira o ano:");
                int ano = scan.nextInt();



                dataDeGanho.setDia(dia);
                dataDeGanho.setMes(mes);
                dataDeGanho.setAno(ano);
                dataDeGanho.setFormData(dia,mes,ano, count_ganho);



                System.out.println("Insira o valor do ganho:");
                double valordeGanho = scan.nextDouble();
                gan.setValorGanho(valordeGanho, count_ganho);



                System.out.printf("\n\n\n\n %30s: %10s","Nome",nomedeGanho);
                System.out.printf("\n %30s: %10s","Tipo",tipodeGanho);
                System.out.printf("\n %30s: %10s","Data",dataDeGanho.getFormData(count_ganho));
                System.out.printf("\n %30s: %10.2f\n\n\n\n","Valor",valordeGanho);



                ++count_ganho;
            } else {
                int i;
                if (resposta == 3) {
                    System.out.printf("%30s%15s%15s%15s%25s \n", "Gastos", "Tipo", "Data", "Valor", "Forma de Pagamento");
                    for (i = 0; i < count_gasto; ++i) {
                        if (gas.getPagamentoDeGasto(i) == 1) {
                            pagamento = "PIX";
                        } else if (gas.getPagamentoDeGasto(i) == 2) {
                            pagamento = "Boleto";
                        } else if (gas.getPagamentoDeGasto(i) == 3) {
                            pagamento = "Crédito";
                        }
                        relGastos.setRelatorio(gas.getNomeDeGasto(i), gas.getTipoDeGasto(i), dataDeGasto.getFormData(i), gas.getValorDeGasto(i), pagamento, i);
                        relGastos.getRelatorio(i);
                    }
                } else if (resposta == 4) {
                    System.out.printf("%30s%15s%15s%15s \n", "Ganhos", "Tipo", "Data", "Valor");

                    for (i = 0; i < count_ganho; ++i) {
                        relGanhos.setRelatorio(gan.getNomedeGanho(i), gan.getTipodeGanho(i), dataDeGanho.getFormData(i), gan.getValordeGanho(i), i);
                        relGanhos.getRelatorio(i);
                    }
                } else if (resposta == 5) {
                    System.out.println("\n\n\n\nEscolha qual o mês referente ao relatório: " +
                            "\n 01-Janeiro" +
                            "\n 02-Fevereiro" +
                            "\n 03-Março" +
                            "\n 04-Abril" +
                            "\n 05-Maio" +
                            "\n 06-Junho" +
                            "\n 07-Julho" +
                            "\n 08-Agosto" +
                            "\n 09-Setembro" +
                            "\n 10-Outubro" +
                            "\n 11-Novembro" +
                            "\n 12-Dezembro");
                    System.out.println("\nResposta: ");
                    scan.nextLine();
                    int mensal = scan.nextInt();
                    System.out.println("Escolha o ano referente ao relatório: EX - 2020");
                    int ano = scan.nextInt();
                    System.out.printf("%30s%15s%15s%15s%25s \n", "Gastos", "Tipo", "Data", "Valor", "Forma de Pagamento");
                    for (i = 0; i < count_gasto; ++i) {
                        if (dataDeGasto.getFormData(i).contains("/" + mensal + "/" + ano)) {
                            if (gas.getPagamentoDeGasto(i) == 1) {
                                pagamento = "PIX";
                            } else if (gas.getPagamentoDeGasto(i) == 2) {
                                pagamento = "Boleto";
                            } else if (gas.getPagamentoDeGasto(i) == 3) {
                                pagamento = "Crédito";
                            }
                            relGastos.setRelatorio(gas.getNomeDeGasto(i), gas.getTipoDeGasto(i), dataDeGasto.getFormData(i), gas.getValorDeGasto(i), pagamento, i);
                            relGastos.getRelatorio(i);
                            total.setGastos(gas.getValorDeGasto(i));
                        } else {
                            System.out.printf("\n%100s", "Não existe registro de Gastos nesse mês!");
                        }
                    }
                    System.out.println("");
                    System.out.println("");
                    System.out.printf("%30s%15s%15s%15s \n", "Ganhos", "Tipo", "Data", "Valor");
                    for (i = 0; i < count_ganho; ++i) {
                        if (dataDeGanho.getFormData(i).contains("/" + mensal + "/" + ano)) {
                            relGanhos.setRelatorio(gan.getNomedeGanho(i), gan.getTipodeGanho(i), dataDeGasto.getFormData(i), gan.getValordeGanho(i), i);
                            relGanhos.getRelatorio(i);
                            total.setGanhos(gan.getValordeGanho(i));
                        } else {
                            System.out.printf("\n%100s", "Não existe registro de Ganhos nesse mês!");
                        }
                    }
                    total.setTotalgg();
                    total.getTotalgg();
                }
            }
        }
    }
}

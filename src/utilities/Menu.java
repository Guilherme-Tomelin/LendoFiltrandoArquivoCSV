package utilities;

import java.util.List;
import entities.User;
import java.util.Scanner;

public class Menu {

    /*
    Opção 1 - Inserir o município residencial
        a. O número total de pacientes do município;
        b. A média de idade dos pacientes separados por gênero;
        c. A média de idade de todos os pacientes;
    */
    public String opcao1(List<User> userList){
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Informe o nome do município residencial: ");
        String nomeMunicipioResidencial = sc.nextLine().trim().toUpperCase();
        
        Utilities utilitie = new Utilities();

        String quantidadePacientes = String.valueOf(utilitie.contaTotalPacientesMunicipio(nomeMunicipioResidencial, userList));//Retorna quantidade de Pacientes do municipio
        double[] vetResultMedias = utilitie.calcularMediaIdade(userList);//Retorna vetor
        //vetor --> mediaIdadeTotal[0], mediaIdadeMasculino[1], mediaIdadeFeminino[2]        
    
        //transformando os dados do vetor em String
        String mediaIdadeTotal = String.valueOf(vetResultMedias[0]);
        String mediaIdadeMasculino = String.valueOf(vetResultMedias[1]);
        String mediaIdadeFeminino = String.valueOf(vetResultMedias[2]);
       

        String resultado = "O número total de pacientes do município é de " + quantidadePacientes + 
        "\n"+"A média de idade dos pacientes Homens é de " + mediaIdadeMasculino +
        "\n"+"A média de idade das pacientes Mulheres é de " + mediaIdadeFeminino +
        "\n"+"A média de idade Total dos pacientes é de " + mediaIdadeTotal +"\n";

        sc.close();

        return resultado;
    }//fecha opcao1
    
    /*
     Opção 2 - Inserir o município residencial 
            Resultado: Exibir uma lista com os anos de 2018 a 2021 
            e a quantidade de pacientes que foram internados por ano.
    */
    public String opcao2(List<User> userList){
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do município residencial: ");
        String nomeMunicipioResidencial = sc.nextLine().trim().toUpperCase();

        Utilities utilitie = new Utilities();

        int[] pessoasPorAno = utilitie.pacientesPorAno(nomeMunicipioResidencial, userList) ;

        int cont2018 = pessoasPorAno[0];
        int cont2019 = pessoasPorAno[1];
        int cont2020 = pessoasPorAno[2];
        int cont2021 = pessoasPorAno[3];

        utilitie.filtraPorAno(nomeMunicipioResidencial, userList);

        String resultado = 
        "\n\n" +
        "Total de pessoas Internadas em "+ nomeMunicipioResidencial +": \n"+
        "ano de 2018: " + cont2018 +"\n"+
        "ano de 2019: " + cont2019 +"\n"+
        "ano de 2020: " + cont2020 +"\n"+
        "ano de 2021: " + cont2021 +"\n";

        sc.close();

        return resultado;
    }//fecha opcao2

    /*
     Opção 3 - Inserir o nome do executante
            Resultado: 
            pacientes internados, 
            idade, 
            município residencial, 
            solicitante, 
            data de autorização, 
            data de internação, 
            data de alta, 
            executante.
    */

    public void opcao3(List<User> userList){
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do executante: ");
        String nomeExecutante = sc.nextLine().trim().toUpperCase();

        Utilities utilitie = new Utilities();

        utilitie.filtroUm(nomeExecutante, userList);

        sc.close();
    }

    /*
     Opção 4 - Inserir o nome do solicitante
            Resultado: 
            a. Uma lista com todos os pacientes;
            b. O nome dos hospitais executantes;
            c. O número de dias que os pacientes permaneceram internados desde a
            solicitação até a alta deste paciente;
    */

    public void opcao4(List<User> userList){
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do solicitante: ");
        
        String nomeSolicitante = sc.nextLine();
        Utilities utilitie = new Utilities();

        try{
            utilitie.filtroDois(nomeSolicitante, userList);
        }catch(Exception e){

        }


        sc.close();
    }//fecha opcao4

    /*
     Opção 5 - Determinar tempos de espera na fila
            Resultado: determinar e exibir os cinco casos com maior tempo de espera na fila
    */
    public void opcao5(List<User> userList){

        int primeiroMaiorValor = 0;
        int segundoMaiorValor = 0;
        int terceiroMaiorValor = 0;
        int quartoMaiorValor = 0;
        int quintoMaiorValor = 0;

        int[] valores = new int[5];

        //Primeiro Maior valor
        for(int i = 0 ; i < userList.size() ; i++){      
            if(i == 0){
                primeiroMaiorValor = userList.get(i).getHoras_na_fila();
                terceiroMaiorValor = userList.get(i).getHoras_na_fila();
                quartoMaiorValor = userList.get(i).getHoras_na_fila();
                quintoMaiorValor = userList.get(i).getHoras_na_fila();

                valores[0] = primeiroMaiorValor;
                valores[2] = terceiroMaiorValor;
                valores[3] = quartoMaiorValor;
                valores[4] = quintoMaiorValor;
            }else{
                if(userList.get(i).getHoras_na_fila() > valores[0]){
                    valores[0] = userList.get(i).getHoras_na_fila();
                }

            }
        }//fecha for

        //Segundo Maior Valor
        for(int i = 0 ; i < userList.size() ; i++){
            if(i == 0){
                segundoMaiorValor = userList.get(i).getHoras_na_fila();
                valores[1] = segundoMaiorValor;
            }else{
                if(userList.get(i).getHoras_na_fila() != valores[0] && userList.get(i).getHoras_na_fila() > valores[1]){
                    valores[1] = userList.get(i).getHoras_na_fila();
                }

            }
        }//fecha for

        //Terceiro Maior Valor
        for(int i = 0 ; i < userList.size() ; i++){
            if(i == 0){
                terceiroMaiorValor = userList.get(i).getHoras_na_fila();
                valores[2] = terceiroMaiorValor;
            }else{
                if(userList.get(i).getHoras_na_fila() != valores[0] && userList.get(i).getHoras_na_fila() != valores[1] && userList.get(i).getHoras_na_fila() > valores[2]){
                    valores[2] = userList.get(i).getHoras_na_fila();
                }

            }
        }//fecha for

        //Quarto Maior Valor
        for(int i = 0 ; i < userList.size() ; i++){
            if(i == 0){
                quartoMaiorValor = userList.get(i).getHoras_na_fila();
                valores[3] = quartoMaiorValor;
            }else{
                if(userList.get(i).getHoras_na_fila() != valores[0] && userList.get(i).getHoras_na_fila() != valores[1] && userList.get(i).getHoras_na_fila() != valores[2] && userList.get(i).getHoras_na_fila() > valores[3]){
                    valores[3] = userList.get(i).getHoras_na_fila();
                }

            }
        }//fecha for

        //Quinto Maior Valor
        for(int i = 0 ; i < userList.size() ; i++){
            if(i == 0){
                quintoMaiorValor = userList.get(i).getHoras_na_fila();
                valores[4] = quintoMaiorValor;
            }else{
                if(userList.get(i).getHoras_na_fila() != valores[0] && userList.get(i).getHoras_na_fila() != valores[1] && userList.get(i).getHoras_na_fila() != valores[2] && userList.get(i).getHoras_na_fila() != valores[3] && userList.get(i).getHoras_na_fila() > valores[4]){
                    valores[4] = userList.get(i).getHoras_na_fila();
                }

            }
        }//fecha for
        


        System.out.println("Primero Maior valor: " + valores[0] +"\n"+
        "Segundo Maior valor: "+ valores[1] +"\n"+
        "Terceiro Maior valor: "+ valores[2] +"\n"+
        "Quarto Maior valor: "+ valores[3] +"\n"+
        "Quinto Maior valor: "+ valores[4] +"\n");


    }//fecha Opcao5

    
}

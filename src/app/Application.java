package app;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import entities.User;
import utilities.Utilities;
import java.util.Date;
import java.text.ParseException;
import utilities.Menu;


public class Application {
    public static void main(String[] args) throws ParseException {
       
        String path = "..\\ProjetoProcessoSeletivo\\gerint_solicitacoes_mod.csv";
        List<User> userList = new ArrayList<User>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            //método readLine, faz a leitura do arquivo até a quebra de linha e reotrna como String

            String line = br.readLine(); 
            line = br.readLine(); //line recebe ReadLine(x2) para começar lendo pela segunda linha (1° user)

            Utilities utilitie = new Utilities();            

            System.out.println("");
            System.out.println("Carregando......");
            System.out.println("");

            while(line != null){
                String[] vect = line.split(";"); 

                Date data_extracao = utilitie.returnValidDate(vect[0]);
                String id_usuario = vect[1];
                String situacao = vect[2];
                String central_regulacao_origem = vect[3];
                Date data_solicitacao = utilitie.returnValidDate(vect[4]);
                String sexo = vect[5].trim();
                Integer idade = utilitie.isEmpty(vect[6]) ? 0 : (int)Float.parseFloat(vect[6].trim());
                String munincipio_residencia = vect[7].trim();
                String solicitante = vect[8];
                String munincipio_solicitante = vect[9];
                String codigo_cid = vect[10];
                String carater = vect[11];
                String tipo_internacao = vect[12];
                String tipo_leito = vect[13];
                Date data_autorizacao = utilitie.returnValidDate(vect[14]);
                Date data_internacao = utilitie.returnValidDate(vect[15]);
                Date data_alta = utilitie.returnValidDate(vect[16]);
                String executante = vect[17].trim();
                Integer horas_na_fila = Integer.parseInt(vect[18]);

                User user = new User(data_extracao, id_usuario, situacao, central_regulacao_origem, data_solicitacao, sexo, idade, munincipio_residencia, solicitante, munincipio_solicitante, codigo_cid, carater, tipo_internacao, tipo_leito, data_autorizacao, data_internacao, data_alta, executante, horas_na_fila);
                userList.add(user);

                line = br.readLine();
            }//fecha while
        }//fecha try
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }//fecha catch

        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();

        int refazer = 1;
        int opcaoMenu = 0;

        while(refazer == 1){
            System.out.println("[1] - Consultar média de idade dos pacientes.");
            System.out.println("[2] - Consultar internações por ano.");
            System.out.println("[3] - Consultar hospitais.");
            System.out.println("[4] - Calcular tempo de internação.");
            System.out.println("[5] - Determinar tempo de espera na fila.");
            System.out.println("[6] - Terminar o programa.");
            System.out.println("");
            System.out.print("Escolha uma operação: ");
            
            try{
                opcaoMenu = sc.nextInt();
                System.out.println("------------------------------------------");
                
                switch(opcaoMenu){
                    case 1:
                        System.out.println("Opção [1] Selecionada.");
                        System.out.println(menu.opcao1(userList));
                        break;
                    case 2:
                        System.out.println("Opção [2] Selecionada.");
                        System.out.println(menu.opcao2(userList));
                        break;
                    case 3:
                        System.out.println("Opção [3] Selecionada.");
                        menu.opcao3(userList);
                        break;
                    case 4:
                        System.out.println("Opção [4] Selecionada.");
                        menu.opcao4(userList);
                        break;
                    case 5:
                        System.out.println("Opção [5] Selecionada.");
                        menu.opcao5(userList);
                        break;
                    case 6:
                        System.out.println("Opção [6] Selecionada.");
                        System.out.println("Encerrando o Programa....");
                        break;
                    default:
                        System.out.println("Opção invalida.");
                        break;
                }


            }catch(Exception e){
                System.out.println("Opção invalida, apenas números são permitidos.");
                refazer = 1;
                opcaoMenu = 0;
            }

            if(opcaoMenu == 6){
                System.out.println("Encerrando o Programa....");
                refazer = 2;
            }else{
                try{
                    System.out.println("------------------------------------------");
                    System.out.println("");
                    System.out.println("Deseja voltar para o menu?");
                    System.out.print("[1] - Sim \n[2] - Nao\n");
                    System.out.print("Opção escolhida: ");
    
                    refazer = sc.nextInt();
                    if(refazer == 2){
                        System.out.println("");
                        System.out.println("Encerrando o programa...");
                    }
                }catch(Exception e){
                    System.out.println("Opcao Invalida, encerrando o programa.");
                    refazer = 2;
                    System.out.println("------------------------------------------");
                    System.out.println("");
                }
            }


        }//fecha while
        
        
        sc.close();
    }//fecha main
}

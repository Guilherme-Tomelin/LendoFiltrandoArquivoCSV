package utilities;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import entities.User;


public class Utilities {

    //----------------------------------------------------filtroDois----------------------------------------------------

    public void filtroDois(String nomeSolicitante, List<User> userList) throws ParseException{

        Date firstDate = new Date();
        Date secondDate = new Date();
        long diffInMillies = 0;
        

        for (int i = 0 ; i < userList.size() ; i++) {
            if(userList.get(i).getSolicitante().toUpperCase().trim().equals(nomeSolicitante)){


                firstDate = userList.get(i).getData_solicitacao();
                secondDate = userList.get(i).getData_alta();
                

                diffInMillies =  secondDate.getTime() - firstDate.getTime();
            
                diffInMillies = diffInMillies / (60 * 60 * 1000) /24;



                System.out.println("------------------------------------------");
                
                System.out.print("ID do paciente: " + userList.get(i).getId_usuario() + "\n");
                System.out.print("Hospital executante: " + userList.get(i).getExecutante() +"\n");
                System.out.print("Total de dias internado(a): " + diffInMillies + "\n");
            }
        }
        
    }
    //----------------------------------------------------filtroUm----------------------------------------------------

    public void filtroUm(String nomeExecutante, List<User> userList){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String dataAut;
        String dataInt;
        String dataAlt;

        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getExecutante().toUpperCase().trim().equals(nomeExecutante)){
                System.out.println("------------------------------------------");
                //paciente
                System.out.print("ID do paciente: " + userList.get(i).getId_usuario());
                System.out.println("");
                //idade
                System.out.print("Idade: " + userList.get(i).getIdade());
                System.out.println("");
                //município residencial
                System.out.print("Município residencial: " + userList.get(i).getMunicipio_residencia());
                System.out.println("");
                //solicitante
                System.out.print("Solicitante: " + userList.get(i).getSolicitante());
                System.out.println("");
                //data de autorização
                dataAut = sdf.format(userList.get(i).getData_autorizacao());
                System.out.print("Data de autorização: " + dataAut);
                System.out.println("");
                //data de internação
                dataInt = sdf.format(userList.get(i).getData_internacao());
                System.out.print("Data de internação: " + dataInt);
                System.out.println("");
                //data da alta
                dataAlt = sdf.format(userList.get(i).getData_alta());
                System.out.print("Data da alta: " + dataAlt);
                System.out.println("");
                //executante
                System.out.print("Executante: " + userList.get(i).getExecutante());
                System.out.println("");
            }
        }
    }//fecha filtroUm

    //----------------------------------------------------filtraPorAno----------------------------------------------------
    public void filtraPorAno(String nomeMunicipioResidencial, List<User> userList){
        String[] DatasEmAno = pacoteDatasAno(userList);

        //for 2018
        for (int i = 0 ; i<userList.size() ; i++) {
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                if(DatasEmAno[i].equals("2018")){
                    System.out.println("2018\n" + "ID do paciente" + userList.get(i).getId_usuario());
                }
            }
        }//fecha for 2018

        //for 2019
        for (int i = 0 ; i<userList.size() ; i++) {
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                if(DatasEmAno[i].equals("2019")){
                    System.out.println("2019\n" + "ID do paciente" + userList.get(i).getId_usuario());
                }
            }
        }//fecha for 2019

        //for 2020
        for (int i = 0 ; i<userList.size() ; i++) {
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                if(DatasEmAno[i].equals("2020")){
                    System.out.println("2020\n" + "ID do paciente" + userList.get(i).getId_usuario());
                }
            }
        }//fecha for 2020

        //for 2021
        for (int i = 0 ; i<userList.size() ; i++) {
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                if(DatasEmAno[i].equals("2021")){
                    System.out.println("2021\n" + "ID do paciente" + userList.get(i).getId_usuario());
                }
            }
        }//fecha for 2021

    
    }

    //----------------------------------------------------reuzData----------------------------------------------------
    public String[] pacoteDatasAno(List<User> userList){

        SimpleDateFormat formataAno = new SimpleDateFormat("yyyy");
        
        String[] anoData = new String[50998];


        for (int i = 0 ; i < userList.size() ; i++) {
            anoData[i] = formataAno.format(userList.get(i).getData_internacao());
        }

        return anoData;
    }

    //----------------------------------------------------contaPacientesPorAno----------------------------------------------------
    public int[] pacientesPorAno(String nomeMunicipioResidencial, List<User> userList){
        String[] DatasEmAno = pacoteDatasAno(userList);
    
        int cont2018 = 0;
        int cont2019 = 0;
        int cont2020 = 0;
        int cont2021 = 0;


        for(int i = 0 ; i<userList.size() ; i++){
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                if(DatasEmAno[i].equals("2018")){
                    cont2018++;
                }
                if(DatasEmAno[i].equals("2019")){
                    cont2019++;
                }
                if(DatasEmAno[i].equals("2020")){
                    cont2020++;
                }
                if(DatasEmAno[i].equals("2021")){
                    cont2021++;
                }

            }
        }

        int[] pessoasPorAno = {cont2018, cont2019, cont2020, cont2021};


        return pessoasPorAno;
    }//fecha pacientesPorAno


    //----------------------------------------------------calcularMediaIdade----------------------------------------------------

    public double[] calcularMediaIdade(List<User> userList){
        //total
        double mediaIdadeTotal = 0;
        int quantidadeIdadesTotal = 0;
        int somaIdadesTotal = 0;
        //Masculino
        double mediaIdadeMasculino = 0;
        int quantidadeIdadesMasculino = 0;
        int somaIdadesMasculino = 0;
        //Feminino
        double mediaIdadeFeminino = 0;
        int quantidadeIdadesFeminino = 0;
        int somaIdadesFeminino = 0;


        for(int i = 0 ; i<userList.size() ; i++){
                if(userList.get(i).getIdade() != 0){
                    quantidadeIdadesTotal++;
                    somaIdadesTotal += userList.get(i).getIdade();
                    if(userList.get(i).getSexo().toUpperCase().equals("FEMININO")){
                        quantidadeIdadesFeminino++;
                        somaIdadesFeminino += userList.get(i).getIdade();
                    }else if(userList.get(i).getSexo().toUpperCase().equals("MASCULINO")){
                        quantidadeIdadesMasculino++;
                        somaIdadesMasculino += userList.get(i).getIdade();
                    }
                }
        }
        try{
            mediaIdadeTotal = somaIdadesTotal/quantidadeIdadesTotal;
            mediaIdadeMasculino = somaIdadesMasculino/quantidadeIdadesMasculino;
            mediaIdadeFeminino = somaIdadesFeminino/quantidadeIdadesFeminino;

        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
         
        double[] vect = {mediaIdadeTotal, mediaIdadeMasculino, mediaIdadeFeminino}; 
        return vect;
    }//fecha calcularMediaIdade
    
    //----------------------------------------------------contaTotalPacientesMunicipio----------------------------------------------------

    public int contaTotalPacientesMunicipio(String nomeMunicipioResidencial, List<User> userList){
        int cont = 0;
        for(int i = 0 ; i<userList.size() ; i++){
            if(userList.get(i).getMunicipio_residencia().toUpperCase().equals(nomeMunicipioResidencial.toUpperCase())){
                cont++;
            }
        }
        return cont;
    }//fecha contaTotalPacientesMunicipio

    //----------------------------------------------------isEmpty----------------------------------------------------
    
    public boolean isEmpty(String texto){
        if(texto.trim().length() > 0){ 
            return false;
        }
        return true;
    }//fecha função isEmpty
    
    //----------------------------------------------------returnValidDate----------------------------------------------------

    public Date returnValidDate(String texto){
        texto = this.isEmpty(texto) ? "0000-00-00" : texto.trim();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");

        Date dateSdf = new Date();

        try {
            if(texto.trim().length() == 23){ 
                dateSdf = sdf1.parse(texto);
            }else if(texto.trim().length() == 19){
                dateSdf = sdf2.parse(texto);
            }else if(texto.trim().length() == 10){
                dateSdf = sdf3.parse(texto);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        
        return dateSdf;
    }//fecha returnValidDate
}

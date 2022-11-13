package autenticacaocpf;

import javax.swing.*;

public class AutenticacaoCpf {
    public static String verificarCpf(String cpf1){
        
         ConexaoSQLite conexao = new ConexaoSQLite("projetocpf.sqlite");
         
         conexao.query("SELECT * FROM tb_cpf");
         
       
        
        int i2 = 0;
        int somaCpf = 0;
        int multiplicador = 10;
        for (int i = 1; i <= 9; i++) {
            somaCpf += Integer.parseInt(cpf1.substring(i2, i)) * multiplicador;
            i2++;
            multiplicador--;
        }

        int verificador = Integer.parseInt(cpf1.substring(9, 10));
        int verificador2 = Integer.parseInt(cpf1.substring(10, 11));

        int resto = somaCpf % 11;

        //1 verificador terminado
        if (resto == 0 || resto == 1){

            int digito10 = 0;

            if(verificador == digito10){

                i2 = 0;
                multiplicador = 11;
                int soma3Cpf = 0;
                for(int i = 1; i <= 10; i++){
                    soma3Cpf += Integer.parseInt(cpf1.substring(i2, i)) * multiplicador;
                    i2++;
                    multiplicador--;
                }

                //System.out.println(soma3Cpf);

                int numeroVerificador = 0;
                soma3Cpf = soma3Cpf % 11;
                //2 verificador  terminado
                if(soma3Cpf == 0 || soma3Cpf == 1) {
                    numeroVerificador = 0;
                    if (numeroVerificador == verificador2) {
                        JOptionPane.showMessageDialog(null, "Cpf válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        String query = "INSERT INTO tb_cpf (cpf) VALUES (";
        query = query + "\"" + cpf1 + "\"";query = query + ")";
         System.out.println("query: "+query);
         conexao.queryUpdate(query);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                    //2 verificador terminado
                }else if(soma3Cpf >= 2){
                    i2 = 0;
                    multiplicador = 11;
                    soma3Cpf = 0;
                    for(int i = 1; i <= 10; i++){
                        soma3Cpf += Integer.parseInt(cpf1.substring(i2, i)) * multiplicador;
                        i2++;
                        multiplicador--;
                    }
                    int resultado = 11 - (soma3Cpf % 11);

                    if(resultado == verificador2){
                        JOptionPane.showMessageDialog(null, "Cpf válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    String query = "INSERT INTO tb_cpf (cpf) VALUES (";
      System.out.println("query: "+query);
        
        conexao.queryUpdate(query);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            //1 verificador terminado
        }else if(resto >= 2){

            int calculoResto_Onze = 11 - resto;

            int digito10 = calculoResto_Onze;
            //-----------
            if(verificador == digito10){

                i2 = 0;
                multiplicador = 11;
                int soma3Cpf = 0;
                for(int i = 1; i <= 10; i++){
                    soma3Cpf += Integer.parseInt(cpf1.substring(i2, i)) * multiplicador;
                    i2++;
                    multiplicador--;
                }
                int resultado = soma3Cpf % 11;
                if(resultado >= 2){
                    int calculo = 11 - resultado;
                    if(calculo == verificador2){
                        JOptionPane.showMessageDialog(null, "Cpf válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    String query = "INSERT INTO tb_cpf (cpf) VALUES (";
        query = query + "\"" + cpf1 + "\"";query = query + ")";
          System.out.println("query: "+query);
          conexao.queryUpdate(query);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }else if(resultado == 0 || resultado == 1){
                    int number11 = 0;
                    if(verificador2 == number11) {
                        JOptionPane.showMessageDialog(null, "Cpf válido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                  String query = "INSERT INTO tb_cpf (cpf) VALUES (";
        query = query + "\"" + cpf1 + "\"";query = query + ")";
         System.out.println("query: "+query);
         conexao.queryUpdate(query);
                    } else{
                        JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Cpf inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}

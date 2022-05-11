/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aula04;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Mattos
 */

public class Aula04_exercicio01
{

    public static double leia(String mensagem)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensagem);
        
        return teclado.nextDouble();
    }
    
    public static double CalcIMC(double altura, double peso)
    {
        return peso/Math.pow(altura, 2);
    }
    
    public static void imprimeNome(String[] nomes, int[] idades, int NUM_PESSOAS)
    {
        int i, j;
        
        for(i=0; i<nomes.length; i++)
        {
            for(j=0; j<nomes.length-1; j++)
            {
                if(nomes[j].compareTo(nomes[j+1])>0)
                {
                    String aux1 = nomes[j+1];
                    nomes[j+1]=nomes[j];
                    nomes[j]=aux1;
                    
                    int aux2 = idades[j+1];
                    idades[j+1]=idades[j];
                    idades[j]=aux2;
                }
            }
        }
        
        System.out.println("\nOrdenas em ordem alfabética:");
        for(i=0; i<NUM_PESSOAS; i++)
        {
            System.out.println("Pessoa ["+(i+1)+"]: "+nomes[i]+", "+idades[i]+" anos.");
        }

        /*OUTRA IMPLEMENTAÇÃO, não faz modificação no vetor
        int cont;
        int[] ordem = new int[nomes.length];
        
        for(i=0; i<nomes.length; i++)
        {
            cont=0;
            for(j=0; j<nomes.length; j++)
            {
                if(i!=j && nomes[i].compareTo(nomes[j])>0)
                {
                    cont++;//calcula o número de nomes que nomes[i] é maior na ordem alfabética.
                    //Se ele for o menor, ficará na primera posição;
                }
            }
            ordem[cont]=i;
        }
        
        for(i=0; i<ordem.length; i++)
        {
            System.out.println(nomes[ordem[i]]+" - "+idades[ordem[i]]);
        }
        */
    }
    
    public static void imprimeIdade(String[] nomes, int[] idades, int NUM_PESSOAS)
    {
        int i, j;
        
        for(i=0; i<idades.length; i++)
        {
            for(j=0; j<idades.length-1; j++)
            {
                if(idades[j]>idades[j+1])
                {
                    String aux1 = nomes[j+1];
                    nomes[j+1]=nomes[j];
                    nomes[j]=aux1;
                    
                    int aux2 = idades[j+1];
                    idades[j+1]=idades[j];
                    idades[j]=aux2;
                }
            }
        }
        
        System.out.println("\nOrdenas em ordem crescente de idade:");
        for(i=0; i<NUM_PESSOAS; i++)
        {
            System.out.println("Pessoa ["+(i+1)+"]: "+nomes[i]+", "+idades[i]+" anos.");
        }
    }
    
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        final int NUM_PESSOAS = 5;
        
        /*
        double altura = leia("Entre com a altura em metros: ");
        double peso = leia("Entre com o peso em quilogramas: ");
        
        System.out.println("O IMC he "+(int)CalcIMC(altura, peso));
        */
        
        String[] nomes = new String[5];
        int[] idades = new int[5];
        
        for(int i=0; i<NUM_PESSOAS; i++)
        {
            System.out.println("Informe o nome de "+(i+1)+": ");
            nomes[i]=teclado.nextLine();
            System.out.println("Informe a idade de "+(i+1)+": ");
            idades[i]=teclado.nextInt();
            teclado.nextLine();//evita queo quebra linha seja lido no próximo nextLine.
            
        }
        
        imprimeNome(nomes, idades, NUM_PESSOAS);
        imprimeIdade(nomes, idades, NUM_PESSOAS);
    }
}

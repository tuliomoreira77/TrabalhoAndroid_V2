package com.example.a06.trabalhoandroid;

import android.graphics.Bitmap;
import android.graphics.Color;

public class DescobreCor {

    /*public static String getNome(int cor)
    {
        float hsv[] = new float[3];
        int hue,sat,val;
        Color.colorToHSV(cor,hsv);
        hue = (int) hsv[0];
        sat = (int) (hsv[1]*100);
        val = (int) (hsv[2]*100);
        String nomeCor = "Cor não detectável";

        if(sat <= 5 && val > 90){
            return "Branco";
        } else if(sat < 15){
            return "Cinza";
        } else if(val<10){
            return "Preto";
        } else if(hue <= 10){
            return "Vermelho";
        } else if(hue <= 40){
            return "Laranja";
        } else if(hue <= 70){
            return "Amarelo";
        } else if(hue <= 160){
            return "Verde";
        } else if(hue <= 210){
            return "Azul Claro";
        } else if(hue <= 250){
            return "Azul Escuro";
        } else if(hue <= 285){
            return "Roxo";
        } else if(hue <= 340){
            return "Rosa";
        } else if(hue <= 360){
            return "Vermelho";
        }
        return nomeCor;
    }*/

    public static Cor getByValue(int cor)
    {
        float hsv[] = new float[3];
        int hue,sat,val;
        Color.colorToHSV(cor,hsv);
        hue = (int) hsv[0];
        sat = (int) (hsv[1]*100);
        val = (int) (hsv[2]*100);

        if(sat <= 5 && val > 90){
            return new Cor("Branco",0);
        } else if(sat < 15 && val>= 10){
            return new Cor("Cinza",1);
        } else if(val< 20){
            return new Cor("Preto", 2);
        } else if(hue <= 10){
            return new Cor("Vermelho",3);
        } else if(hue <= 40){
            return new Cor( "Laranja", 4);
        } else if(hue <= 70){
            return new Cor("Amarelo",5);
        } else if(hue <= 160){
            return new Cor("Verde",6);
        } else if(hue <= 210){
            return new Cor("Azul Claro",7);
        } else if(hue <= 250){
            return new Cor("Azul Escuro",8);
        } else if(hue <= 285){
            return new Cor("Roxo",9);
        } else if(hue <= 340){
            return new Cor("Rosa",10);
        } else if(hue <= 360){
            return new Cor("Vermelho",11);
        }

        return new Cor("Vazio", -1);
    }

    public static Cor getById(int id)
    {
        if(id == 0){
            return new Cor("Branco",0);
        } else if(id == 1){
            return new Cor("Cinza",1);
        } else if(id == 2){
            return new Cor("Preto", 2);
        } else if(id == 3){
            return new Cor("Vermelho",3);
        } else if(id == 4){
            return new Cor( "Laranja", 4);
        } else if(id == 5){
            return new Cor("Amarelo",5);
        } else if(id == 6){
            return new Cor("Verde",6);
        } else if(id == 7){
            return new Cor("Azul Claro",7);
        } else if(id == 8){
            return new Cor("Azul Escuro",8);
        } else if(id == 9){
            return new Cor("Roxo",9);
        } else if(id == 10){
            return new Cor("Rosa",10);
        } else if(id == 11){
            return new Cor("Vermelho",11);
        }

        return new Cor("Vazio", -1);
    }


    public static Cor contaPixels(Bitmap image, int tamanho)
    {
        int inicioX = image.getWidth()/2 - tamanho/2;
        int inicioY = image.getHeight()/2 - tamanho/2;
        int id[] = new int[DescobreCor.numCores()];
        int idMax = 0;

        for(int i=0;i<DescobreCor.numCores();i++)
            id[i] = 0;

        for(int i=0;i<tamanho;i++)
        {
            for(int j=0;j<tamanho;j++)
            {
                int cor = DescobreCor.getByValue(image.getPixel(inicioX+i,inicioY+j)).getId();
                id[cor]++;
            }
        }
        for(int i=0; i < numCores()-1; i++)
        {
            if(id[i] < id[i+1])
                idMax = i+1;
        }

        return DescobreCor.getById(idMax);
    }

    static int numCores()
    {
        return 12;
    }
}

package com.example.home.myapplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class offer
{
    public String[] han(char c, Context context) throws IOException
    {
        String result[]=new String[2];
        String res1="";
        double rval1=0.0;
        String res2="";
        double rval2=0.0;

        String line = "";
        String cvsSplitBy = ",";

        //String f1[]={"Foodpanda","Swiggy","Zomato","JustEat","TastyKhana"};
        String f1[]={"Swiggy","Zomato","Restaurant"};
        //String f2[]={"PizzaHut","Dominos","U.S.Pizza","Eagle Boys Pizza","Papa John's","Smokin Joe's"};
        String f2[]={"PizzaHut","DOMINOS","KFC","Pizza"};

        String c1[]={"Uber","Ola"};
        //String c1[]={"Uber","Ola","Meru Cabs","Easy Cabs","Taxi For Sure","Mega Cabs"};
        //String c2[]={"Zoom Car","U Drive","Let Me Drive","Revv"};
        String s1[]={"Pantaloons","Spencers","Shoppers"};
        String s2[]={"Paytm","Mall","Bazaar","Shop","Amazon","Flipkart"};

        String m1[]={"Inox","cinemas","pvr","cinepolis","cinemax"};

        int i=0;

        //food
        double maxf=0;
        String mf="";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open(get_food(c)))))
        {
            while ((line = br.readLine()) != null)
            {
                String[] x = line.split(cvsSplitBy);
                if(Double.parseDouble(x[2])+200*Double.parseDouble(x[1])>maxf)
                {
                    maxf=Double.parseDouble(x[2])+200*Double.parseDouble(x[1]);
                    mf=x[0];
                }
            }
        }
        catch(Exception e){}

        for(i=0;i<3;i++)
            if(mf.equalsIgnoreCase(f1[i]))
                mf="swiggy";
        for(i=0;i<4;i++)
            if(mf.equalsIgnoreCase(f2[i]))
                mf="pizzahut";

        res1=mf;
        rval1=maxf;
        // System.out.println("Max ="+maxf +" "+mf);

        //Shopping
        double maxs=0;
        String ms="";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open(get_shopping(c)))))
        {
            while ((line = br.readLine()) != null)
            {
                String[] x = line.split(cvsSplitBy);
                if(Double.parseDouble(x[2])+200*Double.parseDouble(x[1])>maxs)
                {
                    maxs=Double.parseDouble(x[2])+200*Double.parseDouble(x[1]);
                    ms=x[0];
                }
            }
        }
        catch(Exception e){}

        for(i=0;i<3;i++)
            if(ms.equalsIgnoreCase(s1[i]))
                ms="pantaloons";
        for(i=0;i<6;i++)
            if(ms.equalsIgnoreCase(s2[i]))
                ms="paytm";

        if(maxs>rval1)
        {
            rval2=rval1;
            res2=res1;
            res1=ms;
            rval1=maxs;
        }
        else
        {
            rval2=maxs;
            res2=ms;
        }
        //System.out.println("Max ="+maxs +" "+ms);


        //cabs
        double maxc=0;
        String mc="";
        try{
            BufferedReader br1 = new BufferedReader(new InputStreamReader(context.getAssets().open(get_cab(c))));
            while ((line = br1.readLine()) != null)
            {
                String[] x = line.split(cvsSplitBy);
                if(Double.parseDouble(x[2])+200*Double.parseDouble(x[1])>maxc)
                {
                    maxc=Double.parseDouble(x[2])+200*Double.parseDouble(x[1]);
                    mc=x[0];
                }
            }
            mc="uber";
        }
        catch(Exception e){}
        if(maxc>rval1)
        {
            rval2=rval1;
            res2=res1;
            rval1=maxc;
            res1=mc;
        }
        else if(maxc>rval2)
        {
            rval2=maxc;
            res2=mc;
        }
        //System.out.println("Max ="+maxc +" "+mc);

        //movie
        double maxm=0.0;
        String mm="";
        try{
            BufferedReader br4 = new BufferedReader(new InputStreamReader(context.getAssets().open(get_movie(c))));
            while ((line = br4.readLine()) != null)
            {
                String[] x = line.split(cvsSplitBy);
                if(Double.parseDouble(x[2])+200*Double.parseDouble(x[1])>maxm)
                {
                    maxm=Double.parseDouble(x[2])+200*Double.parseDouble(x[1]);
                    mm=x[0];
                }
            }
            mm="inox";
        }
        catch(Exception e){}
        if(maxm>rval1)
        {
            rval2=rval1;
            res2=res1;
            rval1=maxm;
            res1=mm;
        }
        else if(maxm>rval2)
        {
            rval2=maxm;
            res2=mm;
        }
        //System.out.println("Max ="+maxm +"maxm=   "+mm); 
        result[0]=res1;
        result[1]=res2;
        return result;
        //System.out.println(result[0]+" "+result[1]);
    }
    private String get_food(char c)
    {
        String s = "cust"+c+"_food.csv";
        return s;
    }
    private String get_cab(char c)
    {
        String s = "cust"+c+"_cab.csv";
        return s;
    }
    private String get_shopping(char c)
    {
        String s = "cust"+c+"_shopping.csv";
        return s;
    }
    private String get_movie(char c)
    {
        String s = "cust"+c+"movie.csv";
        return s;
    }
}
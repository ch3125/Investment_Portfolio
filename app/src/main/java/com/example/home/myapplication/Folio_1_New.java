package com.example.home.myapplication;

import android.content.Context;

import com.example.home.myapplication.Modal.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Folio_1_New
{
    int ipp=30;
    int annual_income;
    int amount_invested;
    int age;
    String cust_id;
    char marital_status;
    char child_status;
    double duration;
    char risk_quotient;
    int cm;
    int already_invested_moderate=0;
    int already_invested_low=0;
    int already_invested_high=0;
    String cust1_path="cust1_inv.csv";
    String cust2_path="cust2_inv.csv";
    String cust3_path="cust3_inv.csv";
    String cust4_path="cust4_inv.csv";
    String low_inv="LOW.csv";
    String moderate_inv="MODERATE.csv";
    String high_inv="HIGH.csv";
    String output="output.csv";
    double max_period=0;
    BufferedReader br = null;
    Context context;
    public void initializer(String a,String ai,String ag,String m,String c,String d,String r)
    {

        annual_income=Integer.parseInt(a);
        amount_invested=Integer.parseInt(ai);
        age=Integer.parseInt(ag);
        marital_status=m.charAt(0);
        child_status=c.charAt(0);
        duration=Double.parseDouble(d);
        risk_quotient=r.charAt(0);
    }

    public String[][] portfolioA() throws IOException
    {
        int flag=0;
        String result="";
        if(risk_quotient=='l')
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("LOW.csv")));
        else if(risk_quotient=='m')
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("MODERATE.csv")));
        else
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("HIGH.csv")));

        double sum=0;
        double perc_return;
        String amt_each="";
        String line="";
        while ((line = br.readLine()) != null)
        {
            String lowcomp[]=line.split(",");
            if(duration>=Double.parseDouble(lowcomp[2]))
            {

                result=result+lowcomp[0]+",";
                flag++;
                sum=sum+Double.parseDouble(lowcomp[1]);
            }
        }
        if(flag==0)
            result="Sorry.You cannot receive a reasonable reccomendation based on your inputs.";
        if(flag>=3)
            result=result.substring(0,result.length()-1);
        perc_return=(sum/flag);
        if(flag==2)
            amt_each=(0.5* amount_invested)+","+(0.5* amount_invested);
        else if(flag==3)
            amt_each=(0.33* amount_invested)+","+(0.33* amount_invested)+","+(0.33* amount_invested);
        else if(flag==4)
            amt_each=(0.25* amount_invested)+","+(0.25* amount_invested)+","+(0.25* amount_invested)+","+(0.25* amount_invested);
        else
            amt_each=""+(amount_invested);

        String arr[][]=new String[3][5];
        String row1[]=result.split(",");
        String row2[]=amt_each.split(",");
        for(int i=0;i<row1.length;i++)
            arr[0][i]=row1[i];
        for(int i=0;i<row2.length;i++)
            arr[1][i]=row2[i];
        arr[2][0]=Double.toString(perc_return);
        return arr;


    }




    public String[][] portfolioB()throws IOException
    {
        int age_in;
        if(age>=0 && age<=40)
            age_in=2;
        else if(age>40 && age<=60)
            age_in=1;
        else
            age_in=0;


        int duration_in;
        if(duration>=0 && duration<=1)
            duration_in=2;
        else if(duration>1 && duration<=3)
            duration_in=1;
        else
            duration_in=0;

        int risk_quotient_in;
        if(risk_quotient=='h')
            risk_quotient_in=2;
        else if(risk_quotient=='m')
            risk_quotient_in=1;
        else
            risk_quotient_in=0;


        if((marital_status=='y')&&(child_status=='y'))
            cm=0;
        else if((marital_status=='y')&&(child_status=='n'))
            cm=1;
        else if((marital_status=='n')&&(child_status=='y'))
            cm=1;
        else
            cm=2;

        int fraction;
        double fraction_amt=(amount_invested*100)/annual_income;
        if( fraction_amt>0&& fraction_amt<=10)
            fraction=2;
        else if(fraction_amt>10&&fraction_amt<=50)
            fraction=1;
        else
            fraction=0;


        int collector[]=new int[5];
        collector[0]=fraction;//perc 2
        collector[1]=age_in;//2
        collector[2]=cm;//1
        collector[3]=(int)duration_in;//2
        collector[4]=risk_quotient_in;//3

        int weights[]=new int[5];
        weights[0]=2;
        weights[1]=2;
        weights[2]=1;
        weights[3]=2;
        weights[4]=3;

        double high,med,low;
        int indivsum=0;
        for(int i=0;i<5;i++)
        {
            if(collector[i]==0)
                indivsum=indivsum+weights[i];
        }
        low=(double)(indivsum)/10;

        indivsum=0;
        for(int i=0;i<5;i++)
        {
            if(collector[i]==1)
                indivsum=indivsum+weights[i];
        }
        med=(double)(indivsum)/10;

        indivsum=0;
        for(int i=0;i<5;i++)
        {
            if(collector[i]==2)
                indivsum=indivsum+weights[i];
        }
        high=(double)(indivsum)/10;

        double low_amt,med_amt,high_amt;
        low_amt=(low)*amount_invested;
        med_amt=(med)*amount_invested;
        high_amt=(high)*amount_invested;

        double overall_sum=0;
        String arr[][]=new String[3][5];
        if(low>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,1,'B');
        else if(med>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,2,'B');
        else if(high>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,3,'B');

        if(low<0.5&&med<0.5&&high<0.5)
            arr=calculater50(low_amt,med_amt,high_amt,-1,'B');

        return arr;
    }

















    public String[][] calculater50(double l, double m, double h, int n,char ids)throws IOException
    {

        double perc_return=0;
        double sum=0;
        String result="";
        String amt_each="";
        double max_duration=0;
        if(n==1)
        {
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("LOW.csv")));
            int c=0;
            String line="";
            while ((line = br.readLine()) != null)
            {
                if(c!=2){
                    String low_storer[]=line.split(",");
                    if(max_duration<=Double.parseDouble(low_storer[2]))
                        max_duration=Double.parseDouble(low_storer[2]);
                    result=result+low_storer[0]+",";
                    sum=sum+((0.5*l)*((Double.parseDouble(low_storer[1]))/100));
                }
                else
                    break;
                c++;

            }

            br=new BufferedReader(new InputStreamReader(context.getAssets().open("MODERATE.csv")));
            line=br.readLine();
            String moderate_storer[]=line.split(",");
            result=result+moderate_storer[0]+",";
            sum=sum+(m*((Double.parseDouble(moderate_storer[1]))/100));


            br=new BufferedReader(new InputStreamReader(context.getAssets().open("HIGH.csv")));
            line=br.readLine();
            String high_storer[]=line.split(",");
            result=result+high_storer[0]+",";
            sum=sum+(h*((Double.parseDouble(high_storer[1]))/100));

            perc_return=(sum/amount_invested)*100;

            amt_each=(0.5*l)+","+(0.5*l)+","+m+","+h;
            result=result.substring(0,result.length()-1);
        }

        if(n==2)
        {
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("MODERATE,csv")));
            String line="";
            int c=0;
            while ((line = br.readLine()) != null)
            {


                if(c!=2){
                    String mod_storer[]=line.split(",");
                    if(max_duration<=Double.parseDouble(mod_storer[2]))
                        max_duration=Double.parseDouble(mod_storer[2]);
                    result=result+mod_storer[0]+",";
                    sum=sum+((0.5*m)*((Double.parseDouble(mod_storer[1]))/100));
                }
                else
                    break;
                c++;

            }

            br=new BufferedReader(new InputStreamReader(context.getAssets().open("LOW.csv")));
            line=br.readLine();
            String low_storer[]=line.split(",");
            result=result+low_storer[0]+",";
            sum=sum+(l*((Double.parseDouble(low_storer[1]))/100));


            br=new BufferedReader(new InputStreamReader(context.getAssets().open("HIGH.csv")));
            line=br.readLine();
            String high_storer[]=line.split(",");
            result=result+high_storer[0]+",";
            sum=sum+(h*((Double.parseDouble(high_storer[1]))/100));

            perc_return=(sum/amount_invested)*100;
            amt_each=(0.5*m)+","+(0.5*m)+","+l+","+h;
            result=result.substring(0,result.length()-1);
        }





        if(n==3)
        {
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("HIGH.csv")));
            String line="";
            int c=0;
            while ((line = br.readLine()) != null)
            {


                if(c!=2){
                    String high_storer[]=line.split(",");
                    if(max_duration<=Double.parseDouble(high_storer[2]))
                        max_duration=Double.parseDouble(high_storer[2]);
                    result=result+high_storer[0]+",";
                    sum=sum+((0.5*h)*((Double.parseDouble(high_storer[1]))/100));
                }
                else
                    break;
                c++;

            }

            br=new BufferedReader(new InputStreamReader(context.getAssets().open("MODERATE.csv")));
            line=br.readLine();
            String moderate_storer[]=line.split(",");
            result=result+moderate_storer[0]+",";
            sum=sum+(m*((Double.parseDouble(moderate_storer[1]))/100));


            br=new BufferedReader(new InputStreamReader(context.getAssets().open("LOW.csv")));
            line=br.readLine();
            String low_storer[]=line.split(",");
            result=result+low_storer[0]+",";
            sum=sum+(l*((Double.parseDouble(low_storer[1]))/100));

            perc_return=(sum/amount_invested)*100;
            amt_each=(0.5*h)+","+(0.5*h)+","+m+","+l;
            result=result.substring(0,result.length()-1);
        }

        if(n==-1)
        {

            String line;
            br=new BufferedReader(new InputStreamReader(context.getAssets().open("HIGH.csv")));
            line=br.readLine();
            String high_storer[]=line.split(",");
            result=result+high_storer[0]+",";
            sum=sum+(h*((Double.parseDouble(high_storer[1]))/100));

            br=new BufferedReader(new InputStreamReader(context.getAssets().open("MODERATE.csv")));
            line=br.readLine();
            String moderate_storer[]=line.split(",");
            result=result+moderate_storer[0]+",";
            sum=sum+(m*((Double.parseDouble(moderate_storer[1]))/100));


            br=new BufferedReader(new InputStreamReader(context.getAssets().open("LOW.csv")));
            line=br.readLine();
            String low_storer[]=line.split(",");
            result=result+low_storer[0]+",";
            sum=sum+(h*((Double.parseDouble(low_storer[1]))/100));

            perc_return=(sum/amount_invested)*100;
            amt_each=h+","+m+","+l;
            result=result.substring(0,result.length()-1);
        }


        String arr[][]=new String[3][5];
        String row1[]=result.split(",");
        String row2[]=amt_each.split(",");
        for(int i=0;i<row1.length;i++)
            arr[0][i]=row1[i];
        for(int i=0;i<row2.length;i++)
            arr[1][i]=row2[i];
        arr[2][0]=Double.toString(perc_return);
        return arr;


    }

    public Folio_1_New(Context context)
    {
        this.context=context;
    }
    public Folio_1_New()
    {

    }
    public String[][] portfolioC()throws IOException//FD,LIC is low/ MUTUAL is Moderate/ EQUITY is high
    {
        SessionManager sessionManager= new SessionManager(context);
        User user = new User();sessionManager.getUserDetails();
        String customer_file="cust"+user.getAcc_no().charAt(user.getAcc_no().length()-1)+"_inv.csv";
        br=new BufferedReader(new InputStreamReader(context.getAssets().open(customer_file)));
        String line="";
        while ((line = br.readLine()) != null)
        {
            String storer[]=line.split(",");
            if(storer[0].equals("FD")||storer[0].equals("LIC"))
            {
                already_invested_low=already_invested_low+Integer.parseInt(storer[2]);
            }
            if(storer[0].equals("MUTUAL"))
            {
                already_invested_moderate=already_invested_moderate+Integer.parseInt(storer[2]);
            }
            if(storer[0].equals("EQUITY"))
            {
                already_invested_high=already_invested_high+Integer.parseInt(storer[2]);
            }
        }
        int indicator=0;
        if(already_invested_high>=already_invested_moderate && already_invested_high>=already_invested_low )
            indicator=2;
        else if(already_invested_moderate>=already_invested_high && already_invested_moderate>=already_invested_low )
            indicator=1;
        else
            indicator=0;

        int age_in;
        if(age>=0 && age<=40)
            age_in=2;
        else if(age>40 && age<=60)
            age_in=1;
        else
            age_in=0;


        int duration_in;
        if(duration>=0 && duration<=1)
            duration_in=2;
        else if(duration>1 && duration<=3)
            duration_in=1;
        else
            duration_in=0;

        int risk_quotient_in;
        if(risk_quotient=='h')
            risk_quotient_in=2;
        else if(risk_quotient=='m')
            risk_quotient_in=1;
        else
            risk_quotient_in=0;


        if((marital_status=='y')&&(child_status=='y'))
            cm=0;
        else if((marital_status=='y')&&(child_status=='n'))
            cm=1;
        else if((marital_status=='n')&&(child_status=='y'))
            cm=1;
        else
            cm=2;

        int fraction;
        double fraction_amt=(amount_invested*100)/annual_income;
        if(fraction_amt>0&&fraction_amt<=10)
            fraction=2;
        else if(fraction_amt>10&&fraction_amt<=50)
            fraction=1;
        else
            fraction=0;


        int collector[]=new int[6];
        collector[0]=fraction;//perc 2
        collector[1]=age_in;//2
        collector[2]=cm;//1
        collector[3]=(int)duration_in;//2
        collector[4]=risk_quotient_in;//3
        collector[5]=indicator;//2


        int weights[]=new int[6];
        weights[0]=2;
        weights[1]=2;
        weights[2]=1;
        weights[3]=2;
        weights[4]=3;
        weights[5]=2;

        double high,med,low;
        int indivsum=0;
        for(int i=0;i<6;i++)
        {
            if(collector[i]==0)
                indivsum=indivsum+weights[i];
        }
        low=(double)(indivsum)/12;

        indivsum=0;
        for(int i=0;i<6;i++)
        {
            if(collector[i]==1)
                indivsum=indivsum+weights[i];
        }
        med=(double)(indivsum)/12;

        indivsum=0;
        for(int i=0;i<6;i++)
        {
            if(collector[i]==2)
                indivsum=indivsum+weights[i];
        }
        high=(double)(indivsum)/12;


        double low_amt,med_amt,high_amt;
        low_amt=(low)*amount_invested;
        med_amt=(med)*amount_invested;
        high_amt=(high)*amount_invested;


        String arr[][]=new String[3][5];

        if(low>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,1,'C');
        if(med>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,2,'C');
        if(high>=0.5)
            arr=calculater50(low_amt,med_amt,high_amt,3,'C');

        if(low<0.5&&med<0.5&&high<0.5)
            arr=calculater50(low_amt,med_amt,high_amt,-1,'C');


        return arr;
    }










}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_parser;

import java.util.Date;

/**
 *
 * @author user
 */
public class PPDocument {
    public String ppdate;
    public String ppnum;
    public String ppamount;
    public String pptype;
    public String ppsendername;
    public String pprecievername;
    public String ppdescription;
    public String ppsenderacc;

PPDocument()
{
    ppdate="";
    ppnum="";
    ppamount="";
    pptype="";
    ppsendername="";
    pprecievername="";
    ppdescription="";
    ppsenderacc="";
}
    
    public void fillppdoc(String[] document){
//        ppdate=document[0];
//        ppnum=document[1];
//        ppamount=document[2];
//        pptype=document[3];
//        ppsendername=document[4];
//        pprecievername=document[5];
//        ppdescription=document[6];
//        ppsenderacc=document[7];
        for(int i=0;i<document.length;i++)
        {
            if (document[i]==null)
                document[i]="";
        }
        for(int i=0;i<document.length;i++)
        {
            if (document[i].contains("Дата=")){
                ppdate=document[i].substring(5,document[i].length());
                }  
            if (document[i].contains("Номер=")){
                ppnum=document[i].substring(6,document[i].length());
                }  
            if (document[i].contains("Сумма=")){
                ppamount=document[i].substring(6,document[i].length());
                }  
            if (document[i].contains("СекцияДокумент=")){
                pptype=document[i].substring(15,document[i].length());
                }  
            if (document[i].contains("Плательщик=")){
                ppsendername=document[i].substring(11,document[i].length());
                }  
            if (document[i].contains("Получатель=")){
                pprecievername=document[i].substring(11,document[i].length());
                }  
             if (document[i].contains("НазначениеПлатежа=")){
                ppdescription=document[i].substring(18,document[i].length());
                }  
            if (document[i].contains("ПлательщикРасчСчет=")){
                ppsenderacc=document[i].substring(19,document[i].length());
                }  
            
        }
}
    }

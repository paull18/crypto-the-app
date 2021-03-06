
        
        
        
        
        
        
        
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import static java.time.Clock.system;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ABS
 */


public class testDePrimality extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public testDePrimality() {
        initComponents();
                
        Rectangle rect=new Rectangle(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        // that, give the available screen space (width and height (without counting the task bar)) 
        setLocation((int)(rect.getWidth()-getWidth())/2, (int)(rect.getHeight()-getHeight())/2); //seting the location of the jFram to be centred
        //                                       ^                                      ^
        //                                 width of the jfram                  height of the jfram
     
        
    }

    
    
    class Timing{
        private
              long start;
              long end;
              long duration;
              
              
        /*long nanoSeconds;      
        long miliSeconds;      
        long second;
        long minutes;
        long hours;
        long days;
        long years; // a year is 365 days 
  */
        public
          
                /*   void formate()
                {long elapsedTime=duration;
                nanoSeconds =  ((elapsedTime)%((long)1e6)); // 1e6 est 10^6   1ms = 10^6 ns
               
                elapsedTime = (long) (elapsedTime/1e6); // le temps restant en milisecond en enlevant la valeur donner à nanoSeconds 

                miliSeconds = ((elapsedTime)%((long)1e3)); // 1s= 1000 ms
                
                elapsedTime = (long) (elapsedTime/1e3); // le reste en s
                
                second = ((elapsedTime)%60); // 1mn= 60s
                
                elapsedTime = (long) (elapsedTime/60); // le reste en mn
                
                minutes = ((elapsedTime)%60); // 1h= 60mn
                
                elapsedTime = (long) (elapsedTime/60); // le reste en h
                
                hours = ((elapsedTime)%24); // 1d= 24h
                
                elapsedTime = (long) (elapsedTime/24); // le reste en d
                
                days = ((elapsedTime)%365); // 1y= 365d
                
                elapsedTime = (long) (elapsedTime/365); // le reste en y
                
                years = elapsedTime; // reste le nombre d'années
                
                }
                */
                        
            /////////////////////////////////////////////////////////F1 format 1: <<y:d:h:mn:s:ms:ns>     
                long getF1ns()
                {
               return  duration%((long)1e6);
                }
                 long getF1ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF1s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF1mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 %60;
                }    
                  long getF1h()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60%24;
                }    
                  long getF1d()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24%365;
                } 
                 long getF1y()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24/365;
                }  
                 
                 /////////////////////////////////////////////////////////F2 format 2: <<d:h:mn:s:ms:ns>>
                 long getF2ns()
                {
               return  duration%((long)1e6);
                }
                 long getF2ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF2s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF2mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 %60;
                }    
                         long getF2h()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60%24;
                }    
                  long getF2d()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24;
                } 
                  
                  
                  
              /////////////////////////////////////////////////////////F3 format 3: <<h:mn:s:ms:ns>>   
                       long getF3ns()
                {
               return  duration%((long)1e6);
                }
                 long getF3ms()
                {
               return  (long)((duration/((long)1e6)) % (long)1e3);
                }      
                 long getF3s()
                {
               return  ((long)((duration/((long)1e6))/ (long)1e3) % 60);
                }     
                 long getF3mn()
                {
               return  ((long)((duration/((long)1e6))/ (long)1e3 / 60) %60);
                }    
                         long getF3h()
                {
               return  (long)((duration/((long)1e6))/ (long)1e3 / 60 /60);
                } 
                  
                    
                         
                         
              /////////////////////////////////////////////////////////F4 format 4: <<mn:s:ms:ns>>    
                          long getF4ns()
                {
               return  duration%((long)1e6);
                }
                 long getF4ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF4s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF4mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60;
                }     
                  
                   
                 
                     /////////////////////////////////////////////////////////F5 format 5: <<s:ms:ns>>    
                          long getF5ns()
                {
               return  duration%((long)1e6);
                }
                 long getF5ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF5s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3;
                } 
                 
                 
                     
                 
                 
                    /////////////////////////////////////////////////////////F6 format 6: <<ms:ns>>    
                          long getF6ns()
                {
               return  duration%((long)1e6);
                }
                 long getF6ms()
                {
               return  (long)(duration/((long)1e6));
                }      
                 
                 /////////////////////////////////////////////////////////////
                 long getInNano()
                 {
                     return duration;
                 }
                
                 long getStart()
                 {
                     return start;
                 }
                 
                 long getEnd()
                 {
                     return end;
                 }
                 
                String strF3Duration()
                {long h,mn,s,ms,ns;
                h=getF3h();mn=getF3mn();s=getF3s();ms=getF3ms();ns=getF3ns();
                   
                return  String.valueOf(getF3h())+"h : "+ String.valueOf(getF3mn())+"mn : "+ String.valueOf(getF3s())+"s : "+ String.valueOf(getF3ms())+"ms : "+ String.valueOf(getF3ns())+"ns";
                }
                 
                 String strF32Duration()
                {
                return  String.valueOf(getF3h())+"h : "+ String.valueOf(getF3mn())+"mn";
                }
                 
                 
                 
                 
                 
                 
                 
                 String strTimeUnivNS()
                 {
                     if(getF1y()!=0)
                         return String.valueOf(getF1y())+" year(s) : "+ String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1d()!=0)
                          return  String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1h()!=0)
                          return   String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                      else if(getF1mn()!=0)
                          return   String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1s()!=0)
                          return   String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                      else if(getF1ms()!=0)
                          return    String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                       
                      else return String.valueOf(getF1ns())+" ns";       
                 
                 }
                 
                  String strTimeUnivMS()
                 {
                     if(getF1y()!=0)
                         return String.valueOf(getF1y())+" year(s) : "+ String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1d()!=0)
                          return  String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1h()!=0)
                          return   String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                      else if(getF1mn()!=0)
                          return   String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1s()!=0)
                          return   String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                      else if(getF1ms()!=0)
                          return    String.valueOf(getF1ms())+" ms";
                       
                      else return String.valueOf(getF1ns())+" ns";       
                 
                 }
                 
                //////////////////////////////////////////////// 
                Timing(){
                start= System.nanoTime();
                   } // starting the counter
               
                ////////////////////////////////////                
                void updateDuration()
                {
                end=System.nanoTime();
                duration= end-start;
                }
         
                ////////////////////////////////////////
    } 
    
    
    
    
    
    
    
    
    
 
    
 
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////
      public  JComponent scaleSwingManual(JComponent cp,int widthAdd,int heightAdd){ //we calculate scaleCoeficient of the width and add to the width
        int width = cp.getWidth() , height=cp.getHeight(), newWidth, newheight,newX,newY;
        
        newWidth=(int) (width+widthAdd);
          newheight=(int) (height+heightAdd);
          
          newX=cp.getX()-(newWidth-width)/2;
          newY=cp.getY()-(newheight-height)/2;
          
        cp.setBounds(newX, newY, newWidth, newheight);
        return cp;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////  
      public JComponent downSwing(JComponent cp,int spaceMove)// move down a component
      {
          cp.setLocation(cp.getX(),cp.getY()+spaceMove);
          return cp;
      }
     ////////////////////////////////////////////////////
       public JComponent rightSwing(JComponent cp,int spaceMove)// move right a component
      {
          cp.setLocation(cp.getX()+spaceMove,cp.getY());
          return cp;
      }
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       public JLabel sccaleFontSwing(JLabel jlb,int intAddToSize)
       {
           jlb.setFont(new Font(jlb.getFont().getFamily(),jlb.getFont().getStyle(),jlb.getFont().getSize()+intAddToSize)); 
           return jlb;
       }
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       
      public JComponent concatinateComponentsHoriz(JComponent cp1, JComponent cp2,int mode) 
       {
           if(mode==1) // mode 1 simple horizantal concatination
           {
           cp2.setLocation(cp1.getX()+cp1.getWidth(), cp1.getY() );
          
           }
           else if(mode==2){ // simple + changing the height to fit the other component
            cp2.setBounds(cp1.getX()+cp1.getWidth(), cp1.getY(),cp2.getWidth(),cp1.getHeight() );    
           }
            return cp2;
       }
      
      /////////////////////////////////////////////////////
      
             
      public JComponent concatinateComponentsVerti(JComponent cp1, JComponent cp2,int mode) 
       {
           if(mode==1) // mode 1 simple horizantal concatination
           {
           cp2.setLocation(cp1.getX(), cp1.getY()+cp1.getHeight() );
          
           }
           else if(mode==2){ // simple + changing the height to fit the other component
            cp2.setBounds(cp1.getX()+cp1.getWidth(), cp1.getY(),cp2.getWidth(),cp1.getHeight() );    
           }
            return cp2;
       }
      
      
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      public JScrollPane scrollAnnimationV(JScrollPane scrp,int msTime, int imgPs, int start,int end) throws InterruptedException
      {
          int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistance = (end-start)/nbrImages;
          long startimer,endtimer;
          scrp.getVerticalScrollBar().setValue(start);
          for(int i=0;i<nbrImages-1;i++){
               scrp.getVerticalScrollBar().setValue(scrp.getVerticalScrollBar().getValue()+intervaleDistance); 
              
               ///////////////////////////////////////////////////// wait
               startimer = System.currentTimeMillis();
               endtimer = startimer;
               while(endtimer-startimer<intervaleTime)
                 endtimer = System.currentTimeMillis();
               /////////////////////////////////////////////////////
          }
        
              scrp.getVerticalScrollBar().setValue(end);
                 return scrp;
      }
   ////////////////////////////////////////////////////   
      public JScrollPane scrollAnnimationH(JScrollPane scrp,int msTime, int imgPs, int start,int end) throws InterruptedException
      {
          int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistance = (end-start)/nbrImages;
          
          scrp.getVerticalScrollBar().setValue(start);
          for(int i=0;i<nbrImages-1;i++){
               scrp.getHorizontalScrollBar().setValue(scrp.getHorizontalScrollBar().getValue()+intervaleDistance); 
               Thread.sleep(intervaleTime);
          }
        
              scrp.getHorizontalScrollBar().setValue(end);
          return scrp;
      }
      
      
      
      
class transitionAnnimSwing extends SwingWorker<JComponent, JComponent> {
    JComponent  cpn;  
    int msTime;
    int imgPs;
    int startX;
     int startY;
    int endX;
     int endY;
    
    public transitionAnnimSwing (JComponent cp,int MsTime, int ImgPs, int StartX,int StartY,int EndX,int EndY)
    {
        cpn = cp;
         msTime=MsTime;
         imgPs=ImgPs;
         startX=StartX;
         startY=StartY;
         endX=EndX;
         endY=EndY;
    }
    
    @Override
       public JComponent doInBackground() throws InterruptedException {
       int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistanceX = (endX-startX)/nbrImages;
         int newX;
          cpn.setLocation(startX,startY);
          
          for(int i=0;i<nbrImages-1;i++){
              newX=cpn.getX()+intervaleDistanceX;
              cpn.setLocation(newX,(endY-startY)/(endX-startX)*(newX-startX)+startY );
              
               Thread.sleep(intervaleTime);
               /////////////////////////////////////////////////////
               publish(cpn);
          }
        
             cpn.setLocation(endX,endY);
                 return cpn;
           
       }

       @Override
       protected void done() {
           try {
              cpn=(JPanel) get();       //  // very important it work well even like this cool !!!!!!!!!!! also we can put the object we want to apply to 
           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
        @Override
  protected void process(final List<JComponent> chunks) {
   
	for (final JComponent  db : chunks) {
            if(!this.isCancelled())
            {
              cpn=(JPanel) db;   // very important it work well even like this cool
            }
            
    }
	
  }
   }

///////////////////////////////////////////:


class transitionAnnimSwingLabel extends SwingWorker<JLabel, JLabel> {
    JLabel  cpn;  
    int msTime;
    int imgPs;
    int startX;
     int startY;
    int endX;
     int endY;
    
    public transitionAnnimSwingLabel (JLabel cp,int MsTime, int ImgPs, int StartX,int StartY,int EndX,int EndY)
    {
        cpn = cp;
         msTime=MsTime;
         imgPs=ImgPs;
         startX=StartX;
         startY=StartY;
         endX=EndX;
         endY=EndY;
    }
    
    @Override
       public JLabel doInBackground() throws InterruptedException {
       int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistanceX = (endX-startX)/nbrImages;
         int newX;
          cpn.setLocation(startX,startY);
          
          for(int i=0;i<nbrImages-1;i++){
              newX=cpn.getX()+intervaleDistanceX;
              cpn.setLocation(newX,(endY-startY)/(endX-startX)*(newX-startX)+startY );
              
               Thread.sleep(intervaleTime);
               /////////////////////////////////////////////////////
               publish(cpn);
          }
        
             cpn.setLocation(endX,endY);
                 return cpn;
           
       }

       @Override
       protected void done() {
           try {
              cpn= get();       //  // very important it work well even like this cool !!!!!!!!!!! also we can put the object we want to apply to 
           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
        @Override
  protected void process(final List<JLabel> chunks) {
   
	for (final JLabel  db : chunks) {
            if(!this.isCancelled())
            {
              cpn=db;   // very important it work well even like this cool
            }
            
    }
	
  }
   }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////







Boolean timerOn ;


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class annimate4SquareWorker extends SwingWorker<Void, JPanel> {
            JPanel p1;  java.awt.Color clr1;
            JPanel p2;  java.awt.Color clr2;
            JPanel p3;  java.awt.Color clr3;
            JPanel p4;  java.awt.Color clr4;
            long timeIntervale; 
    
    public annimate4SquareWorker ( JPanel P1, JPanel P2, JPanel P3, JPanel P4,  long timeIntervaleMS)
    {
             p1=P1;
             p2=P2;
             p3=P3;
             p4=P4;
             
             clr1=p1.getBackground();
             clr2=p2.getBackground();
             clr3=p3.getBackground();
             clr4=p4.getBackground();
             
             timeIntervale = timeIntervaleMS;
    }
    
    @Override
       public Void doInBackground() throws InterruptedException {
        
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);
      
      while(!this.isCancelled()){
      //1
      p2.setBackground(clr1);
      p3.setBackground(clr2); 
      p4.setBackground(clr3);
      p1.setBackground(clr4);
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
            
  
     Thread.sleep(timeIntervale); 
  //2
      p3.setBackground(clr1);
      p4.setBackground(clr2); 
      p1.setBackground(clr3);
      p2.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
       
     Thread.sleep(timeIntervale); 
      
     //3
      p4.setBackground(clr1);
      p1.setBackground(clr2); 
      p2.setBackground(clr3);
      p3.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
        
     Thread.sleep(timeIntervale);
      
      //4
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
     
     Thread.sleep(timeIntervale);
      }
         
      return null;
       } 
       
       

     
       
        @Override
  protected void process(final List<JPanel> chunks) {
   
	for (int i=0;i<chunks.size();i++) {
            if(!this.isCancelled())
            { if(i%4==0)
              p1= chunks.get(i);
            else if(i%4==1)
              p2= chunks.get(i);
            else if(i%4==2)
              p3= chunks.get(i);
            else if(i%4==3)
              p4= chunks.get(i);
            }
            
    }
	
  }
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////
 

BigInteger modPowSM(BigInteger a, BigInteger b, BigInteger m) 
{
  String bBinaryStr = b.toString(2); // 2 pour dire en base 2
      BigInteger aPOWb= BigInteger.valueOf(1); //aPOWb = 1
      for(int i=0; i<bBinaryStr.length();i++)   // pour i parcourant toute la chaine de la représentation binaire de b
      {
          if(bBinaryStr.charAt(i)=='1') // si le bit est 1 alors SM
          {
          aPOWb= aPOWb.multiply(aPOWb);  // squar
          aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
           aPOWb= aPOWb.multiply(a); // multiply
            aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
          }
          else  //sinon 0 et donc squar
          {
                aPOWb= aPOWb.multiply(aPOWb);
               aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
          } 
      }
return aPOWb; // en sortie le BigInteger qui represente a^b
}


/////////////////////////////////////////////////////////////////////



public boolean pseudoPrimTest(BigInteger nbr)
{
    if(modPowSM(BigInteger.valueOf(2), nbr.subtract(BigInteger.ONE) , nbr).equals(BigInteger.ONE)) 
// si 2^(nbr-1)=1 (mod nbr)
    return true; // nbr premier
    else return false; //sinon  composé
}











 //									                      Type1      Type2 // here same
// 												        ||			||
	 class pseudoPrimTest_Worker  extends SwingWorker<Boolean, Void> {
   BigInteger nbr;
    
    public pseudoPrimTest_Worker (BigInteger Nbr) // !!!!! very important this is the bridge
    {
     nbr=Nbr;
    }
    
    @Override
       public Boolean doInBackground() throws InterruptedException { // type 1
	 onWork =true; // work flag on // work have started	 
           jLabel30.setVisible(true);
         jLabel22.setVisible(true);
         jPanel18.setVisible(true);
              workerAnnim1 = new annimate4SquareWorker(jPanel25,jPanel24 , jPanel20, jPanel23, 250) ;
                workerAnnim1.execute();
                
           return pseudoPrimTest(nbr);
       }

       @Override
       protected void done() {
           onWork=false;
           timerOn=false;
           
           timer1.updateDuration();
           timer1Str=timer1.strTimeUnivMS();
           jTextField2.setText(timer1Str);
           
          SwingWorker<Void, Void> workerC   // if not needed type can be Void
       = new SwingWorker<Void, Void>()
       {
           @Override
       public Void doInBackground() {
     while(!workerAnnim1.isDone()) 
           workerAnnim1.cancel(true);
	   return null; // of type type1
       }
       };
        workerC.execute();
           
                                                                                                     
           jPanel18.setVisible(false);
           jLabel22.setVisible(false);
           jLabel30.setVisible(false);
            jLabel24.setVisible(false);
          
           
           try {
           if(get())
              
jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEuYESyes.png"))); // NOI18N

           else
jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEnoNOno.png"))); // NOI18N 
       
           jLabel29.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel29,300,60,180-100,160,180,160);
   worker.execute();

           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
 
   }
   
   
   
         

//////////////////////////////////
//Miller Rabin test
/////////////////////////////////////

class pair2POWtU {
    private
    BigInteger t; // t telque 2^t.u
     BigInteger u;
     
  public
       pair2POWtU(BigInteger nbr) {
        t = BigInteger.ZERO;
        u=nbr;
            while(u.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) ) //tant que  u mod 2 = 0 
            {
                u=u.divide(BigInteger.valueOf(2));
                t=t.add(BigInteger.ONE);
            }
            
        }
     
  BigInteger getT(){
      return t;
  }   
  
 BigInteger getU(){
      return u;
  }   
        
        
}

 

public boolean Temoin(BigInteger nbr, BigInteger base )
{
   pair2POWtU frm2PWtU = new  pair2POWtU(nbr.subtract(BigInteger.ONE));
   
    ///////////////
   BigInteger x = modPowSM(base,frm2PWtU.getU() ,nbr ); // base^u mod nbr
    ///////////////
   
   BigInteger i = BigInteger.ZERO;
   BigInteger xLast;
   
   while (i.compareTo(frm2PWtU.getT())<0) //repeter t fois 
   {   xLast =x;
       x= modPowSM(x, BigInteger.valueOf(2), nbr);
       
        ///////////////
       if(x.equals(BigInteger.ONE)&& 
               !(xLast.equals(BigInteger.ONE)) && !(xLast.equals(nbr.subtract(BigInteger.ONE))))
                return true;
        ///////////////
       
       i=i.add(BigInteger.ONE);
   }
   
   
     ///////////////
       if(!(x.equals(BigInteger.ONE)))
       return true;
     ///////////////  
       
       return false;
           
   
}



///////////////////////////////////////////////////////
public  BigInteger randomBI(BigInteger maxNum) {
    Random rnd = new Random();
    int maxNumBitLength = maxNum.bitLength();
    BigInteger rndNum;
    do {
        rndNum = new BigInteger(maxNumBitLength, rnd);
    } while(rndNum.compareTo(maxNum) >= 0);
    return rndNum;
}

public  BigInteger randomBI(BigInteger minNum, BigInteger maxNum) {
    BigInteger diffr = maxNum.subtract(minNum);
    
    return randomBI(diffr).add(minNum) ;
}

///////////////////////////////////////////////////////////////





public boolean isPrimMR(BigInteger nbr, int s) // s est le nommbre de base à tester
{BigInteger base ;
 for (int i=1; i<=s; i++)   
 {
     base = randomBI(BigInteger.ONE,nbr.subtract(BigInteger.ONE)); // base = random(1,nbr-1)
     if(Temoin(nbr, base))
         return false;
 }
       // si la fonction ne temoine pas à la composition dans aucune base alors nbr est premier (prob)
 return true; 
}
         /////////////////////////////////////////////////////////////////////////
         
         
         
         
         class millerRabinTest_Worker  extends SwingWorker<Boolean, Void> {
   BigInteger nbr;
    int nbrBase;
    public millerRabinTest_Worker (BigInteger Nbr, int NbrBase) // !!!!! very important this is the bridge
    {
     nbr=Nbr;
     nbrBase=NbrBase;
    }
    
    @Override
       public Boolean doInBackground() throws InterruptedException { // type 1
	  onWork2 =true; // work flag on // work have started	   
           jLabel26.setVisible(true);
         jLabel35.setVisible(true);
         jPanel21.setVisible(true);
              
	
         workerAnnim2 = new annimate4SquareWorker(jPanel28,jPanel27 , jPanel22, jPanel26, 250) ;
                workerAnnim2.execute();       
           return isPrimMR(nbr,nbrBase);
       }

       @Override
       protected void done() {
          timer2.updateDuration();
          
          onWork2=false;
           timer2on=false;
           
          timer2Str=timer2.strTimeUnivMS();
          jTextField4.setText(timer2Str);
           
          
               SwingWorker<Void, Void> workerC2   // if not needed type can be Void
       = new SwingWorker<Void, Void>()
       {
           @Override
       public Void doInBackground() {
     while(!workerAnnim2.isDone()) 
           workerAnnim2.cancel(true);
	   return null; // of type type1
       }
       };
        workerC2.execute();
                                                                                                     
           jPanel21.setVisible(false);
           jLabel26.setVisible(false);
           jLabel35.setVisible(false);
            jLabel36.setVisible(false);
           
           try {
           if(get())
              
jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEuYESyes.png"))); // NOI18N

           else
jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEnoNOno.png"))); // NOI18N 
       
           jLabel31.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel31,300,60,450-100,160,450,160);
   worker.execute();
   
           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
 
   }
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    class form2PWtU_Worker extends SwingWorker<pair2POWtU, Void> {
   BigInteger nbr;
    
    public form2PWtU_Worker (BigInteger Nbr) 
    {
      nbr= Nbr;
    }
    
    @Override
       public pair2POWtU doInBackground() throws InterruptedException { // type 1
		return new pair2POWtU(nbr);
           
       }

       @Override
       protected void done() {
           timer3.updateDuration();
           timer3Str=timer3.strTimeUnivMS();
           
            onWork3=false;
           timer3on = false;
           
           jTextField6.setText(timer3Str);
           
           jLabel43.setVisible(false);
           jLabel42.setVisible(false);
           
            jLabel44.setVisible(true);
           try {
           pair2POWtU result = get();
           
           if(result.getU().bitLength()<150)
           {
           jTextArea6.setText("t = "+result.getT().toString()
                   +"\n u = "+result.getU().toString());
           }
           else if(150<=result.getU().bitLength()&&result.getU().bitLength()<5000){
            jTextArea6.setText("t = "+result.getT().toString()
                   +"\n u = "+result.getU().toString());
            FileWriter wf = new FileWriter("out2PWtU.txt");
               wf.write("t = "+result.getT().toString()+"\n u = "+result.getU().toString());
               wf.close();
               
               File file = new File("out2PWtU.txt");
               
                 try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
                 
           }else{
               FileWriter wf = new FileWriter("out2PWtU.txt");
               wf.write("t = "+result.getT().toString()+"\n u = "+result.getU().toString());
               wf.close();
               
               File file = new File("out2PWtU.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
           }
           
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
           Logger.getLogger(testDePrimality.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       
     
   }
      
  //////////////////////////////////////////////////////       
   class genererNombreInterval_Worker extends SwingWorker<BigInteger, Void> {
   BigInteger inf;
   BigInteger sup;
    
    public genererNombreInterval_Worker (BigInteger Inf, BigInteger Sup) // !!!!! very important this is the bridge
    {
        inf =Inf;
        sup=Sup;
    }
    
    @Override
       public BigInteger doInBackground() throws InterruptedException { // type 1
	jLabel45.setVisible(true);
           return randomBI(inf, sup);
           
       }

       @Override
       protected void done() {
           jLabel45.setVisible(false);
            jLabel48.setVisible(false);
           
            onWork4=false;
          
           
           try {
               BigInteger genNum = get();
           if(genNum.bitLength() <5000){
               jTextArea4.setText(genNum.toString());
                jLabel46.setVisible(true);
           }else{
               FileWriter wf = new FileWriter("outGenNumIntervale.txt");
                    
                    wf.write(genNum.toString());
                    
                    wf.close();
                    
                      jLabel47.setVisible(true);
                        jLabel27.setVisible(true);
                          jLabel28.setVisible(true);
                          
                    transitionAnnimSwingLabel workerF = new transitionAnnimSwingLabel(jLabel47,300,40,jLabel47.getX()-70,jLabel47.getY(),jLabel47.getX(),jLabel47.getY());
                    workerF.execute(); // transition annimation on this icon
                    
                     transitionAnnimSwingLabel workerF2 = new transitionAnnimSwingLabel(jLabel27,300,40,jLabel27.getX()+70,jLabel27.getY(),jLabel27.getX(),jLabel27.getY());
                    workerF2.execute(); // transition annimation on this icon
                    
                     transitionAnnimSwingLabel workerF3 = new transitionAnnimSwingLabel(jLabel28,300,40,jLabel28.getX()+70,jLabel28.getY(),jLabel28.getX(),jLabel28.getY());
                    workerF3.execute(); // transition annimation on this icon
                    
           }
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
           Logger.getLogger(testDePrimality.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       
 
   }
        
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel16 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(91, 37, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(47, 34, 45));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("CRYPTO");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, 10));

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tools 100x100 .png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 109));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel14.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/ddd_32x32.png"))); // NOI18N
        jLabel3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel3.setDoubleBuffered(true);
        jLabel3.setFocusable(false);
        jLabel3.setInheritsPopupMenu(false);
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel14.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jPanel9.setBackground(new java.awt.Color(43, 44, 52));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 890, 10));

        jPanel1.add(jPanel14);
        jPanel14.setBounds(0, 0, 943, 140);

        jPanel19.setBackground(new java.awt.Color(28, 24, 34));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(51, 42, 56)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel19);
        jPanel19.setBounds(0, 140, 70, 500);

        jPanel30.setBackground(new java.awt.Color(39, 30, 45));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel30MouseClicked(evt);
            }
        });
        jPanel30.setLayout(null);

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(61, 57, 83)));

        jPanel5.setBackground(new java.awt.Color(51, 48, 66));
        jPanel5.setLayout(new java.awt.GridLayout(9, 1));

        jLabel6.setBackground(new java.awt.Color(60, 60, 84));
        jLabel6.setForeground(new java.awt.Color(130, 122, 122));
        jLabel6.setText("   Aller à Squar and multiply ( modulo Pratique )");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel6.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel6.setOpaque(true);
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel6);

        jLabel8.setBackground(new java.awt.Color(60, 60, 84));
        jLabel8.setForeground(new java.awt.Color(130, 122, 122));
        jLabel8.setText("   Aller à Squar and multiply (pratique)");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel8.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel8.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel8MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel8);

        jLabel10.setBackground(new java.awt.Color(60, 60, 84));
        jLabel10.setForeground(new java.awt.Color(130, 122, 122));
        jLabel10.setText("   Aller à Squar and multiply ( etude )");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel10.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel10.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel10);

        jLabel11.setBackground(new java.awt.Color(60, 60, 84));
        jLabel11.setForeground(new java.awt.Color(130, 122, 122));
        jLabel11.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel11.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel11.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel11MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel11);

        jLabel12.setBackground(new java.awt.Color(60, 60, 84));
        jLabel12.setForeground(new java.awt.Color(130, 122, 122));
        jLabel12.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel12.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel12.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel12);

        jLabel13.setBackground(new java.awt.Color(60, 60, 84));
        jLabel13.setForeground(new java.awt.Color(130, 122, 122));
        jLabel13.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel13.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel13.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel13MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel13);

        jLabel14.setBackground(new java.awt.Color(60, 60, 84));
        jLabel14.setForeground(new java.awt.Color(130, 122, 122));
        jLabel14.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel14.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel14.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel14.setOpaque(true);
        jLabel14.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel14);

        jLabel16.setBackground(new java.awt.Color(60, 60, 84));
        jLabel16.setForeground(new java.awt.Color(130, 122, 122));
        jLabel16.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel16.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel16.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel16.setOpaque(true);
        jLabel16.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel16MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel16);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel10);
        jPanel10.setBounds(0, 0, 250, 500);
        jPanel10.setVisible(false);

        jPanel11.setBackground(new java.awt.Color(51, 31, 55));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(null);

        jLabel48.setForeground(new java.awt.Color(150, 49, 49));
        jLabel48.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel48);
        jLabel48.setBounds(60, 320, 190, 20);
        jLabel48.setVisible(false);

        jLabel42.setForeground(new java.awt.Color(150, 49, 49));
        jLabel42.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel42);
        jLabel42.setBounds(340, 340, 190, 30);
        jLabel42.setVisible(false);

        jLabel43.setBackground(new java.awt.Color(185, 68, 68));
        jLabel43.setForeground(new java.awt.Color(122, 29, 29));
        jLabel43.setText(" Annuler");
        jLabel43.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel43.setOpaque(true);
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel43MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel43MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel43MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel43);
        jLabel43.setBounds(440, 390, 50, 20);
        jLabel43.setVisible(false);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel44MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel44MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel44MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel44);
        jLabel44.setBounds(470, 390, 30, 30);
        jLabel44.setVisible(false);

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 35, 50), 5));

        jTextArea5.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea5.setColumns(20);
        jTextArea5.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("Nombre to 2^t.u");
        jTextArea5.setWrapStyleWord(true);
        jTextArea5.setBorder(null);
        jTextArea5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea5.setDragEnabled(true);
        jTextArea5.setFocusable(false);
        jTextArea5.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea5FocusLost(evt);
            }
        });
        jTextArea5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea5MouseExited(evt);
            }
        });
        jTextArea5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea5KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTextArea5);

        jPanel11.add(jScrollPane5);
        jScrollPane5.setBounds(340, 290, 150, 40);

        jTextField7.setBackground(new java.awt.Color(51, 31, 55));
        jTextField7.setForeground(new java.awt.Color(132, 102, 145));
        jTextField7.setBorder(null);
        jTextField7.setFocusable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField7);
        jTextField7.setBounds(330, 250, 170, 20);

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));

        jTextArea6.setBackground(new java.awt.Color(32, 37, 59));
        jTextArea6.setColumns(20);
        jTextArea6.setForeground(new java.awt.Color(0, 204, 204));
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setWrapStyleWord(true);
        jTextArea6.setBorder(null);
        jTextArea6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea6.setDragEnabled(true);
        jTextArea6.setFocusable(false);
        jTextArea6.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea6MouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(jTextArea6);

        jPanel11.add(jScrollPane6);
        jScrollPane6.setBounds(340, 350, 150, 60);

        jTextField6.setBackground(new java.awt.Color(51, 31, 55));
        jTextField6.setForeground(new java.awt.Color(132, 102, 145));
        jTextField6.setBorder(null);
        jTextField6.setFocusable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField6);
        jTextField6.setBounds(330, 410, 170, 30);

        jPanel12.setBackground(new java.awt.Color(48, 40, 63));

        jLabel17.setForeground(new java.awt.Color(89, 84, 108));
        jLabel17.setText("L'algorithme");

        jLabel18.setForeground(new java.awt.Color(182, 88, 88));
        jLabel18.setText("Test de Primality ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addGap(3, 3, 3)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );

        jPanel11.add(jPanel12);
        jPanel12.setBounds(0, 0, 570, 26);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEnoNOno.png"))); // NOI18N
        jLabel31.setText("jLabel29");
        jPanel11.add(jLabel31);
        jLabel31.setBounds(450, 160, 70, 40);
        jLabel31.setVisible(false);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yes no icon/yes_2_no_64x32BLUEnoNOno.png"))); // NOI18N
        jLabel29.setText("jLabel29");
        jPanel11.add(jLabel29);
        jLabel29.setBounds(180, 160, 70, 40);
        jLabel29.setVisible(false);

        jLabel19.setForeground(new java.awt.Color(119, 55, 55));
        jLabel19.setText("Nbr bases");
        jPanel11.add(jLabel19);
        jLabel19.setBounds(470, 100, 60, 20);

        jPanel13.setBackground(new java.awt.Color(52, 40, 64));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel13);
        jPanel13.setBounds(0, 30, 10, 450);

        jPanel15.setBackground(new java.awt.Color(62, 46, 78));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel15);
        jPanel15.setBounds(560, 30, 10, 450);

        jPanel17.setBackground(new java.awt.Color(51, 40, 63));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel17);
        jPanel17.setBounds(10, 460, 550, 20);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("nombre à tester");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.setDragEnabled(true);
        jTextArea1.setFocusable(false);
        jTextArea1.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea1MouseExited(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel11.add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 150, 100);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(81, 72, 121));
        jLabel33.setText("<html><u>Test de Miller-Rabin </u></html>");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(310, 50, 180, 22);

        jLabel20.setBackground(new java.awt.Color(48, 43, 81));
        jLabel20.setForeground(new java.awt.Color(107, 101, 146));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Tester");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel20MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel20);
        jLabel20.setBounds(80, 210, 70, 20);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("nombre à tester");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea3.setDragEnabled(true);
        jTextArea3.setFocusable(false);
        jTextArea3.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea3FocusLost(evt);
            }
        });
        jTextArea3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea3MouseExited(evt);
            }
        });
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jPanel11.add(jScrollPane3);
        jScrollPane3.setBounds(310, 100, 150, 100);

        jLabel23.setBackground(new java.awt.Color(48, 43, 81));
        jLabel23.setForeground(new java.awt.Color(107, 101, 146));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tester");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel23MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel23);
        jLabel23.setBounds(350, 210, 70, 20);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(90, 84, 122));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("<html><u>La forme 2^t.u d'un nombre </u></html>");
        jPanel11.add(jLabel34);
        jLabel34.setBounds(290, 270, 250, 20);

        jTextField3.setBackground(new java.awt.Color(40, 36, 52));
        jTextField3.setForeground(new java.awt.Color(89, 85, 113));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("nbr Bases");
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField3.setDragEnabled(true);
        jTextField3.setFocusable(false);
        jTextField3.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField3MouseExited(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel11.add(jTextField3);
        jTextField3.setBounds(470, 120, 70, 20);

        jTextField2.setBackground(new java.awt.Color(51, 31, 55));
        jTextField2.setForeground(new java.awt.Color(132, 102, 145));
        jTextField2.setBorder(null);
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField2);
        jTextField2.setBounds(40, 230, 170, 20);

        jTextField4.setBackground(new java.awt.Color(51, 31, 55));
        jTextField4.setForeground(new java.awt.Color(132, 102, 145));
        jTextField4.setBorder(null);
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField4);
        jTextField4.setBounds(310, 230, 170, 20);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jPanel23.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel18.add(jPanel23, gridBagConstraints);

        jPanel20.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel18.add(jPanel20, gridBagConstraints);

        jPanel24.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel18.add(jPanel24, gridBagConstraints);

        jPanel25.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel18.add(jPanel25, gridBagConstraints);

        jPanel11.add(jPanel18);
        jPanel18.setBounds(160, 210, 100, 20);
        jPanel18.setVisible(false);

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new java.awt.GridBagLayout());

        jPanel26.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel21.add(jPanel26, gridBagConstraints);

        jPanel22.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel21.add(jPanel22, gridBagConstraints);

        jPanel27.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel21.add(jPanel27, gridBagConstraints);

        jPanel28.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel21.add(jPanel28, gridBagConstraints);

        jPanel11.add(jPanel21);
        jPanel21.setBounds(430, 210, 100, 20);
        jPanel21.setVisible(false);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file-icon_64x64.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel47MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel47MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel47MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel47MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel47);
        jLabel47.setBounds(60, 350, 70, 80);
        jLabel47.setVisible(false);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel46MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel46MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel46MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel46);
        jLabel46.setBounds(260, 430, 30, 30);
        jLabel46.setVisible(false);

        jLabel30.setBackground(new java.awt.Color(185, 68, 68));
        jLabel30.setForeground(new java.awt.Color(122, 29, 29));
        jLabel30.setText(" Annuler");
        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel30.setOpaque(true);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel30MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel30);
        jLabel30.setBounds(140, 80, 50, 20);
        jLabel30.setVisible(false);

        jLabel22.setForeground(new java.awt.Color(150, 49, 49));
        jLabel22.setText("Calcule en cours");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        jPanel11.add(jLabel22);
        jLabel22.setBounds(40, 80, 100, 20);
        jLabel22.setVisible(false);

        jLabel26.setForeground(new java.awt.Color(150, 49, 49));
        jLabel26.setText("Calcule en cours");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        jPanel11.add(jLabel26);
        jLabel26.setBounds(310, 80, 100, 20);
        jLabel26.setVisible(false);

        jLabel35.setBackground(new java.awt.Color(185, 68, 68));
        jLabel35.setForeground(new java.awt.Color(122, 29, 29));
        jLabel35.setText(" Annuler");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel35MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel35MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel35);
        jLabel35.setBounds(410, 80, 50, 20);
        jLabel35.setVisible(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(142, 65, 159));
        jLabel27.setText("Resultat Large");
        jPanel11.add(jLabel27);
        jLabel27.setBounds(140, 370, 87, 17);
        jLabel27.setVisible(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(162, 87, 179));
        jLabel28.setText("cliquer pour le voir");
        jPanel11.add(jLabel28);
        jLabel28.setBounds(150, 390, 140, 17);
        jLabel28.setVisible(false);

        jLabel45.setBackground(new java.awt.Color(185, 68, 68));
        jLabel45.setForeground(new java.awt.Color(122, 29, 29));
        jLabel45.setText(" Annuler");
        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel45.setOpaque(true);
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel45MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel45MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel45);
        jLabel45.setBounds(230, 330, 50, 20);
        jLabel45.setVisible(false);

        jLabel36.setForeground(new java.awt.Color(150, 49, 49));
        jLabel36.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(320, 190, 150, 30);
        jLabel36.setVisible(false);

        jLabel24.setForeground(new java.awt.Color(150, 49, 49));
        jLabel24.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel24);
        jLabel24.setBounds(50, 190, 190, 30);
        jLabel24.setVisible(false);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setBackground(new java.awt.Color(32, 37, 59));
        jTextArea4.setColumns(20);
        jTextArea4.setForeground(new java.awt.Color(0, 204, 204));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea4.setDragEnabled(true);
        jTextArea4.setFocusable(false);
        jTextArea4.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea4MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTextArea4);

        jPanel11.add(jScrollPane4);
        jScrollPane4.setBounds(30, 330, 250, 120);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(81, 72, 121));
        jLabel37.setText(",");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(120, 290, 10, 40);

        jTextField1.setBackground(new java.awt.Color(40, 36, 52));
        jTextField1.setForeground(new java.awt.Color(89, 85, 113));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("inf");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField1.setDragEnabled(true);
        jTextField1.setFocusable(false);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField1MouseExited(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel11.add(jTextField1);
        jTextField1.setBounds(50, 300, 60, 20);

        jLabel21.setBackground(new java.awt.Color(48, 43, 81));
        jLabel21.setForeground(new java.awt.Color(107, 101, 146));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Generer");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel21MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel21);
        jLabel21.setBounds(230, 300, 60, 20);

        jLabel32.setBackground(new java.awt.Color(48, 43, 81));
        jLabel32.setForeground(new java.awt.Color(107, 101, 146));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("trouver la forme");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel32.setOpaque(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel32MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel32);
        jLabel32.setBounds(340, 330, 150, 20);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(63, 56, 95));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("<html><u>Generer un nombre aléaoirement dans un intervale </u></html>");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(20, 250, 250, 50);

        jPanel29.setBackground(new java.awt.Color(51, 31, 55));
        jPanel29.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(63, 60, 82)));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel29);
        jPanel29.setBounds(310, 260, 210, 170);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(81, 72, 121));
        jLabel39.setText("<html><u>Test pseudo premier</u></html>");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(30, 50, 250, 22);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(81, 72, 121));
        jLabel40.setText("[");
        jPanel11.add(jLabel40);
        jLabel40.setBounds(30, 290, 10, 30);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(81, 72, 121));
        jLabel41.setText("]");
        jPanel11.add(jLabel41);
        jLabel41.setBounds(200, 290, 10, 40);

        jTextField5.setBackground(new java.awt.Color(40, 36, 52));
        jTextField5.setForeground(new java.awt.Color(89, 85, 113));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("sup");
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField5.setDragEnabled(true);
        jTextField5.setFocusable(false);
        jTextField5.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField5MouseExited(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jPanel11.add(jTextField5);
        jTextField5.setBounds(130, 300, 58, 20);

        jPanel30.add(jPanel11);
        jPanel11.setBounds(260, 10, 570, 480);

        jPanel1.add(jPanel30);
        jPanel30.setBounds(70, 140, 880, 500);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText(" X");
        jLabel1.setOpaque(true);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 11, 21, -1));

        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        jPanel3.setBackground(new java.awt.Color(47, 31, 47));
        jPanel3.setMaximumSize(new java.awt.Dimension(4, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(4, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(4, 37));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 945, 4));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 945, 5));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Crypto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 14, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 641, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained
    }//GEN-LAST:event_jLabel1FocusGained

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
jLabel1.setBackground(Color.yellow);
        jLabel1.setForeground(new java.awt.Color(255, 155, 5));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
   jLabel1.setForeground(new java.awt.Color(102, 102, 255));    
jLabel1.setBackground(new java.awt.Color(204, 204, 204));   
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked
Dimension jl6Dimension1 = new Dimension();
Dimension jl9Dimension1 = new Dimension();
Dimension jl8Dimension1 = new Dimension();

Point jL6LocationInitial= new Point();
Point jL9LocationInitial= new Point();

Point jL8LocationInitial= new Point();


    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered

    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited

    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
jLabel9.setBackground(new java.awt.Color(103,255,181)) ;      



// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MousePressed
int Xmouse;
int Ymouse;
    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
  int x=evt.getXOnScreen();
  int y=evt.getYOnScreen();
   
        setLocation(x-Xmouse, y-Ymouse);
  
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
Xmouse=evt.getX();
Ymouse=evt.getY();
//           ^>> get the position of the mouse on the jLabel (our container)
 

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_4.png")));
jLabel4.updateUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png")));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_3.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/home-xxl_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/ddd_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/53529_32x32.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
mainJfram fram = new mainJfram();
fram.setVisible(true);

this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
  outilsMenu fram = new outilsMenu();
fram.setVisible(true);

this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    boolean menuOpen=false;
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
if(!menuOpen){
        jPanel10.setVisible(true);

transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,-jPanel10.getWidth(),0,0,0);
worker.execute();
menuOpen = true;
}
else{
  transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,0,0,-jPanel10.getWidth(),0);
worker.execute();  
menuOpen = false;
}

        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered

jLabel6.setBackground(new java.awt.Color(49, 49, 83));

jLabel6.setForeground(new java.awt.Color(96, 94, 124));

jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));


/*jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(127, 93, 167)));*/

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
jLabel6.setBackground(new java.awt.Color(60, 60, 84));

jLabel6.setForeground(new java.awt.Color(130, 122, 122));
jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
jLabel8.setBackground(new java.awt.Color(60, 60, 84));

jLabel8.setForeground(new java.awt.Color(130, 122, 122)); 

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

jLabel8.setBackground(new java.awt.Color(49, 49, 83));

jLabel8.setForeground(new java.awt.Color(96, 94, 124));  

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

jLabel10.setBackground(new java.awt.Color(49, 49, 83));

jLabel10.setForeground(new java.awt.Color(96, 94, 124));  
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
jLabel10.setBackground(new java.awt.Color(60, 60, 84));

jLabel10.setForeground(new java.awt.Color(130, 122, 122));     
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel11.setBackground(new java.awt.Color(49, 49, 83));

jLabel11.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
jLabel11.setBackground(new java.awt.Color(60, 60, 84));

jLabel11.setForeground(new java.awt.Color(130, 122, 122));    
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel12.setBackground(new java.awt.Color(49, 49, 83));

jLabel12.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
jLabel12.setBackground(new java.awt.Color(60, 60, 84));

jLabel12.setForeground(new java.awt.Color(130, 122, 122));
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
jLabel13.setBackground(new java.awt.Color(49, 49, 83));

jLabel13.setForeground(new java.awt.Color(96, 94, 124)); 
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
jLabel13.setBackground(new java.awt.Color(60, 60, 84));

jLabel13.setForeground(new java.awt.Color(130, 122, 122));    
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

jLabel14.setForeground(new java.awt.Color(96, 94, 124));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
jLabel14.setBackground(new java.awt.Color(60, 60, 84));

jLabel14.setForeground(new java.awt.Color(130, 122, 122)); 

jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
jLabel16.setBackground(new java.awt.Color(49, 49, 83));

jLabel16.setForeground(new java.awt.Color(96, 94, 124));
jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
jLabel16.setBackground(new java.awt.Color(60, 60, 84));

jLabel16.setForeground(new java.awt.Color(130, 122, 122));   
jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_6.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
jTextField3.setFocusable(false);  
jTextField1.setFocusable(false); 
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
jTextField3.setFocusable(false);  
jTextField1.setFocusable(false); 
        
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
jTextField3.setFocusable(false);  
jTextField1.setFocusable(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        jTextField3.setFocusable(false);
        jTextField1.setFocusable(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
jLabel6.setBackground(new java.awt.Color(49, 49, 83));

jLabel6.setForeground(new java.awt.Color(96, 94, 124));

jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
jLabel8.setBackground(new java.awt.Color(49, 49, 83));

jLabel8.setForeground(new java.awt.Color(96, 94, 124));  

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
jLabel10.setBackground(new java.awt.Color(49, 49, 83));

jLabel10.setForeground(new java.awt.Color(96, 94, 124));  
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel11.setBackground(new java.awt.Color(49, 49, 83));

jLabel11.setForeground(new java.awt.Color(96, 94, 124));           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseReleased

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel12.setBackground(new java.awt.Color(49, 49, 83));

jLabel12.setForeground(new java.awt.Color(96, 94, 124));            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
jLabel13.setBackground(new java.awt.Color(49, 49, 83));

jLabel13.setForeground(new java.awt.Color(96, 94, 124)); 
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseReleased

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

        jLabel14.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased
        jLabel16.setBackground(new java.awt.Color(49, 49, 83));

        jLabel16.setForeground(new java.awt.Color(96, 94, 124));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        jLabel6.setBackground(new java.awt.Color(49, 49, 43));

        jLabel6.setForeground(new java.awt.Color(96, 94, 100));

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        jLabel8.setBackground(new java.awt.Color(49, 49, 43));

        jLabel8.setForeground(new java.awt.Color(96, 94, 100));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        jLabel10.setBackground(new java.awt.Color(49, 49, 43));

        jLabel10.setForeground(new java.awt.Color(96, 94, 100));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        jLabel11.setBackground(new java.awt.Color(49, 49, 43));

        jLabel11.setForeground(new java.awt.Color(96, 94, 100));

        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        jLabel12.setBackground(new java.awt.Color(49, 49, 43));

        jLabel12.setForeground(new java.awt.Color(96, 94, 100));

        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
SquareAndMultiplayModuloEfficace fram = new SquareAndMultiplayModuloEfficace();
fram.setVisible(true);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
SquareAndMultiplayEfficace fram = new SquareAndMultiplayEfficace();
fram.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    SquareAndMultiplay fram = new SquareAndMultiplay();
fram.setVisible(true);
this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        jTextArea1.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea1.setForeground(new java.awt.Color(158, 148, 190));

        if(jTextArea1.getText().equals("nombre à tester"))
        jTextArea1.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        jTextArea1.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
        if(jTextArea1.getText().equals(""))
        jTextArea1.setText("nombre à tester");  // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextArea1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseEntered
        if(!jTextArea1.isFocusOwner()){
            jTextArea1.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea1.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MouseEntered

    private void jTextArea1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseExited
        if(!jTextArea1.isFocusOwner()){
            jTextArea1.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea1.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MouseExited

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        int length =jTextArea1.getText().length();
        if(length>1){
            char c =jTextArea1.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea1.setText(jTextArea1.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea1.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextArea1.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        int length =jTextArea1.getText().length();
        if(length>1){
            char c =jTextArea1.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea1.setText(jTextArea1.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea1.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextArea1.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyReleased
Timing timer1; String timer1Str;   // timer 
boolean timer1on ; // timer flag on/of
  boolean onWork = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    pseudoPrimTest_Worker workerMain; // my worker reference 
    annimate4SquareWorker workerAnnim1 ; 
    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
 if(!onWork){
	 if(!(jTextArea1.getText().equals("nombre à tester")||jTextArea1.getText().equals(""))){ // if data are here 
	 jLabel24.setVisible(false);
         jLabel29.setVisible(false);
         
       
         jTextField2.setVisible(true);
             
	 
	
	
      
            
                workerMain = new pseudoPrimTest_Worker(new BigInteger(jTextArea1.getText())); // workerMain is gloabale a reference to allow cancaling forward
                workerMain.execute();
                
                // timer worker
				 timer1=new Timing(); // start timer   // timer1 is globale 

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();
timerOn = true;
                        while(timerOn) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField2.setText(timer1Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField2.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();  
	}else{ 
           jLabel24.setVisible(true);
            jLabel24.setText("Entrer les données d'abord !");  
	 }
	 }else {
            jLabel24.setVisible(true);
            jLabel24.setText("attender le travail en cours !");
	 }     
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setBackground(new java.awt.Color(65, 59, 105));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setBackground(new java.awt.Color(48, 43, 81));

        jLabel20.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        jLabel20.setBackground(new java.awt.Color(92, 96, 146));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseReleased
        jLabel20.setBackground(new java.awt.Color(65, 59, 105));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseReleased

    private void jTextArea3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusGained
        jTextArea3.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea3.setForeground(new java.awt.Color(158, 148, 190));

        if(jTextArea3.getText().equals("nombre à tester"))
        jTextArea3.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusGained

    private void jTextArea3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusLost
        jTextArea3.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        if(jTextArea3.getText().equals(""))
        jTextArea3.setText("nombre à tester");  // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusLost

    private void jTextArea3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea3MouseEntered
        if(!jTextArea3.isFocusOwner()){
            jTextArea3.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea3.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3MouseEntered

    private void jTextArea3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea3MouseExited
        if(!jTextArea3.isFocusOwner()){
            jTextArea3.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea3.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3MouseExited

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
        int length =jTextArea3.getText().length();
        if(length>1){
            char c =jTextArea3.getText().charAt(length-1);
           if(c<48 || c>57) // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea3.setText(jTextArea3.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea3.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextArea3.setText(""); }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3KeyPressed

    private void jTextArea3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyReleased
        int length =jTextArea3.getText().length();
        if(length>1){
            char c =jTextArea3.getText().charAt(length-1);
           if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea3.setText(jTextArea3.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea3.getText().charAt(0);
            if((c<48 || c>57)&&c!='-')
            jTextArea3.setText(""); }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3KeyReleased
Timing timer2; String timer2Str;   // timer 
boolean timer2on ; // timer flag on/of
  boolean onWork2 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    millerRabinTest_Worker workerMain2; // my worker reference 
    annimate4SquareWorker workerAnnim2 ; 
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
 if(!onWork2){
	 if(!(jTextArea3.getText().equals("nombre à tester")||jTextArea3.getText().equals("")
                 ||jTextField3.getText().equals("nbr Bases")||jTextField3.getText().equals(""))){ // if data are here 
	 jLabel36.setVisible(false);
         jLabel31.setVisible(false);
         

         jTextField4.setVisible(true);
             
	 
	
            
                workerMain2 = new millerRabinTest_Worker(
                        new BigInteger(jTextArea3.getText()),Integer.parseInt(jTextField3.getText())); // workerMain is gloabale a reference to allow cancaling forward
                workerMain2.execute();
                
                // timer worker
				 timer2=new Timing(); // start timer   // timer1 is globale 

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();
timer2on = true;
                        while(timer2on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField4.setText(timer2Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField4.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();  
	}else{ 
           jLabel36.setVisible(true);
            jLabel36.setText("Entrer les données d'abord !");  
	 }
	 }else {
            jLabel36.setVisible(true);
            jLabel36.setText("attender le travail en cours !");
	 }             
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setBackground(new java.awt.Color(65, 59, 105));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setBackground(new java.awt.Color(48, 43, 81));

        jLabel23.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        jLabel23.setBackground(new java.awt.Color(92, 96, 146));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
        jLabel23.setBackground(new java.awt.Color(65, 59, 105));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseReleased

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        jTextField3.setBackground(new java.awt.Color(51, 46, 66));
        jTextField3.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField3.getText().equals("nbr Bases"))
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        jTextField3.setBackground(new java.awt.Color(40, 36, 52));

        jTextField3.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField3.getText().equals(""))
        jTextField3.setText("nbr Bases");
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseEntered
        jTextField3.setFocusable(true);
        if(!jTextField3.isFocusOwner()){
            jTextField3.setBackground(new java.awt.Color(46, 41, 60));
            jTextField3.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseEntered

    private void jTextField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseExited
        if(!jTextField3.isFocusOwner()){
            jTextField3.setBackground(new java.awt.Color(40, 36, 52));

            jTextField3.setForeground(new java.awt.Color(89, 85, 113));   }

        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseExited

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        int length =jTextField3.getText().length();
        if(length>1){
            char c =jTextField3.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField3.setText(jTextField3.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField3.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField3.setText("");

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        int length =jTextField3.getText().length();
        if(length>1){
            char c =jTextField3.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField3.setText(jTextField3.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField3.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField3.setText("");
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        workerMain.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
   jLabel30.setBackground(new java.awt.Color(185, 68, 68));

jLabel30.setForeground(new java.awt.Color(122, 29, 29));

      jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));

    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
        jLabel30.setBackground(new java.awt.Color(50, 41, 79));

        jLabel30.setForeground(new java.awt.Color(80, 80, 140));

        jLabel30.setText(" Annuler");

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        workerMain2.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jLabel35.setBackground(new java.awt.Color(222, 85, 85));

        jLabel35.setForeground(new java.awt.Color(149, 35, 35));

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
      jLabel35.setBackground(new java.awt.Color(185, 68, 68));

jLabel35.setForeground(new java.awt.Color(122, 29, 29));



jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));

    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MousePressed
        jLabel35.setBackground(new java.awt.Color(50, 41, 79));

        jLabel35.setForeground(new java.awt.Color(80, 80, 140));

        jLabel35.setText(" Annuler");

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MousePressed

    private void jLabel35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseReleased
        jLabel35.setBackground(new java.awt.Color(222, 85, 85));

        jLabel35.setForeground(new java.awt.Color(149, 35, 35));

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseReleased

    private void jTextArea4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea4MouseEntered
        jTextArea4.setFocusable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4MouseEntered

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setBackground(new java.awt.Color(51, 46, 66));
        jTextField1.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField1.getText().equals("inf"))
        jTextField1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        jTextField1.setBackground(new java.awt.Color(40, 36, 52));

        jTextField1.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField1.getText().equals(""))
        jTextField1.setText("inf");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseEntered
        jTextField1.setFocusable(true);

        if(!jTextField1.isFocusOwner()){
            jTextField1.setBackground(new java.awt.Color(46, 41, 60));
            jTextField1.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseEntered

    private void jTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseExited
        if(!jTextField1.isFocusOwner()){
            jTextField1.setBackground(new java.awt.Color(40, 36, 52));

            jTextField1.setForeground(new java.awt.Color(89, 85, 113));   }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        int length =jTextField1.getText().length();
        if(length>1){
            char c =jTextField1.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField1.setText(jTextField1.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField1.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        int length =jTextField1.getText().length();
        if(length>1){
            char c =jTextField1.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField1.setText(jTextField1.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField1.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField1.setText("");
        }

    }//GEN-LAST:event_jTextField1KeyReleased
boolean onWork4=false;
genererNombreInterval_Worker workerMain4;
    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        if(!onWork4){

            if(!(jTextField1.getText().equals("inf")||jTextField5.getText().equals("sup")
                ||jTextField1.getText().equals("")||jTextField5.getText().equals(""))){
          if(new BigInteger(jTextField1.getText()).compareTo( new BigInteger(jTextField5.getText()))<0)
          { jLabel46.setVisible(false);
            jLabel47.setVisible(false);
            jLabel48.setVisible(false);
             jLabel27.setVisible(false);
            jLabel28.setVisible(false);
            
            jTextArea4.setText("");
            
            
          
           
          

           workerMain4 = new genererNombreInterval_Worker(
                   new BigInteger(jTextField1.getText()), new BigInteger(jTextField5.getText()));
           workerMain4.execute();
           
            onWork4 =true;
          }
          else{
              jLabel48.setVisible(true);
            jLabel48.setText("inf doint etre plus petit que sup");
          }
        }
            else{
        jLabel48.setVisible(true);
            jLabel48.setText("entrer les donné d'abord!");
            }
            
        }
        else
        {jLabel48.setVisible(true);
            jLabel48.setText("attender le travail en cours !");

        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setBackground(new java.awt.Color(65, 59, 105));

        jLabel21.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setBackground(new java.awt.Color(48, 43, 81));

        jLabel21.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        jLabel21.setBackground(new java.awt.Color(92, 96, 146));

        jLabel21.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseReleased
        jLabel21.setBackground(new java.awt.Color(65, 59, 105));

        jLabel21.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseReleased

    private void jTextArea5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea5FocusGained
        jTextArea5.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea5.setForeground(new java.awt.Color(158, 148, 190));

        if(jTextArea5.getText().equals("Nombre to 2^t.u" ))
        jTextArea5.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5FocusGained

    private void jTextArea5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea5FocusLost
        jTextArea5.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea5.setForeground(new java.awt.Color(128, 114, 175));
        if(jTextArea5.getText().equals(""))
        jTextArea5.setText("Nombre to 2^t.u" );  // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5FocusLost

    private void jTextArea5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea5MouseEntered
        if(!jTextArea5.isFocusOwner()){
            jTextArea5.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea5.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea5.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5MouseEntered

    private void jTextArea5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea5MouseExited
        if(!jTextArea5.isFocusOwner()){
            jTextArea5.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea5.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5MouseExited

    private void jTextArea5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea5KeyPressed
        int length =jTextArea5.getText().length();
        if(length>1){
            char c =jTextArea5.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea5.setText(jTextArea5.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea5.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextArea5.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5KeyPressed

    private void jTextArea5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea5KeyReleased
        int length =jTextArea5.getText().length();
        if(length>1){
            char c =jTextArea5.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextArea5.setText(jTextArea5.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextArea5.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextArea5.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5KeyReleased
Timing timer3; String timer3Str;   // timer 
boolean timer3on ; // timer flag on/of
  boolean onWork3 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    form2PWtU_Worker workerMain3; // my worker reference 
    
    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        if(!onWork3){

            if(!(jTextArea5.getText().equals("Nombre to 2^t.u")||jTextArea5.getText().equals(""))){

                jTextArea6.setText("");
                jLabel42.setVisible(false);
                  jLabel44.setVisible(false);
                
                 jLabel43.setVisible(true);
               

                workerMain3 = new form2PWtU_Worker(new BigInteger(jTextArea5.getText()));
                workerMain3.execute();
                timer3=new Timing(); // start timer

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer3on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField6.setText(timer3Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField6.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
                onWork3 =true;
            }
            else{
            jLabel42.setVisible(true);
            jLabel42.setText("entrer les donné d'abord!");
            }
        }
        else
        {jLabel42.setVisible(true);
            jLabel42.setText("attender le travail en cours !");

        }
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        jLabel32.setBackground(new java.awt.Color(65, 59, 105));

        jLabel32.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        jLabel32.setBackground(new java.awt.Color(48, 43, 81));

        jLabel32.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseExited

    private void jLabel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MousePressed
        jLabel32.setBackground(new java.awt.Color(92, 96, 146));

        jLabel32.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MousePressed

    private void jLabel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseReleased
        jLabel32.setBackground(new java.awt.Color(65, 59, 105));

        jLabel32.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseReleased

    private void jTextArea6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea6MouseEntered

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        jTextField5.setBackground(new java.awt.Color(51, 46, 66));
        jTextField5.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField5.getText().equals("sup"))
        jTextField5.setText("");
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        jTextField5.setBackground(new java.awt.Color(40, 36, 52));

        jTextField5.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField5.getText().equals(""))
        jTextField5.setText("sup");
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseEntered
        jTextField5.setFocusable(true);
        if(!jTextField5.isFocusOwner()){
            jTextField5.setBackground(new java.awt.Color(46, 41, 60));
            jTextField5.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseEntered

    private void jTextField5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseExited
        if(!jTextField5.isFocusOwner()){
            jTextField5.setBackground(new java.awt.Color(40, 36, 52));

            jTextField5.setForeground(new java.awt.Color(89, 85, 113));   }


        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseExited

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        int length =jTextField5.getText().length();
        if(length>1){
            char c =jTextField5.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField5.setText(jTextField5.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField5.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField5.setText("");

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        int length =jTextField5.getText().length();
        if(length>1){
            char c =jTextField5.getText().charAt(length-1);
            if(c<48 || c>57)  // equivalent to if(!(c=='0' || c=='1'|| c=='2'|| c=='3'|| c=='4'|| c=='5'|| c=='6'|| c=='7'|| c=='8'|| c=='9'))
            jTextField5.setText(jTextField5.getText().substring(0, length-1));}
        else if(length==1){
            char c =jTextField5.getText().charAt(0);
            if((c<48 || c>57)&&c!='-') jTextField5.setText("");
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        workerMain3.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseEntered

    private void jLabel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseExited
        jLabel30.setBackground(new java.awt.Color(185, 68, 68));

        jLabel30.setForeground(new java.awt.Color(122, 29, 29));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(18, 16, 29)));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseExited

    private void jLabel43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MousePressed
        jLabel30.setBackground(new java.awt.Color(50, 41, 79));

        jLabel30.setForeground(new java.awt.Color(80, 80, 140));

        jLabel30.setText(" Annuler");

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MousePressed

    private void jLabel43MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseReleased
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseReleased

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea6.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jLabel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseExited
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseExited

    private void jLabel44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MousePressed
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MousePressed

    private void jLabel44MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseReleased
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseReleased

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        workerMain4.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        jLabel45.setBackground(new java.awt.Color(222, 85, 85));

        jLabel45.setForeground(new java.awt.Color(149, 35, 35));

        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
        jLabel45.setBackground(new java.awt.Color(185, 68, 68));

        jLabel45.setForeground(new java.awt.Color(122, 29, 29));

        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(18, 16, 29)));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MousePressed
        jLabel45.setBackground(new java.awt.Color(50, 41, 79));

        jLabel45.setForeground(new java.awt.Color(80, 80, 140));

        jLabel45.setText(" Annuler");

        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MousePressed

    private void jLabel45MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseReleased
        jLabel45.setBackground(new java.awt.Color(222, 85, 85));

        jLabel45.setForeground(new java.awt.Color(149, 35, 35));

        jLabel45.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseReleased

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea4.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseEntered
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseEntered

    private void jLabel46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseExited
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseExited

    private void jLabel46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MousePressed
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MousePressed

    private void jLabel46MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseReleased
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseReleased

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        File file = new File("outGenNumIntervale.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseEntered
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseEntered

    private void jLabel47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseExited
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseExited

    private void jLabel47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MousePressed
       jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_2_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MousePressed

    private void jLabel47MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseReleased
       jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseReleased

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJfram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

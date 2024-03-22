/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2labp2_alejandrareyes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author aleja
 */
public class Hilobarritas implements Runnable{
    protected JProgressBar barra1,barra2;
    protected boolean vida1,vida2,terminobarra;
    protected JLabel segundos;
    protected int velo1,velo2;
    protected int gano1,gano2;

    public Hilobarritas(JProgressBar barra1, JProgressBar barra2, JLabel segundos, int velo1, int velo2) {
        this.barra1 = barra1;
        this.barra2 = barra2;
        this.segundos = segundos;
        this.velo1 = velo1;
        this.velo2 = velo2;
    }

    public JProgressBar getBarra1() {
        return barra1;
    }

    public void setBarra1(JProgressBar barra1) {
        this.barra1 = barra1;
    }

    public JProgressBar getBarra2() {
        return barra2;
    }

    public void setBarra2(JProgressBar barra2) {
        this.barra2 = barra2;
    }

    public boolean isVida1() {
        return vida1;
    }

    public void setVida1(boolean vida1) {
        this.vida1 = vida1;
    }

    public boolean isVida2() {
        return vida2;
    }

    public void setVida2(boolean vida2) {
        this.vida2 = vida2;
    }

    public int getVelo1() {
        return velo1;
    }

    public void setVelo1(int velo1) {
        this.velo1 = velo1;
    }

    public int getVelo2() {
        return velo2;
    }

    public void setVelo2(int velo2) {
        this.velo2 = velo2;
    }

    public boolean isTerminobarra() {
        return terminobarra;
    }

    public void setTerminobarra(boolean terminobarra) {
        this.terminobarra = terminobarra;
    }
    
    
    @Override
    public void run() {
        
        String t = "00:00:";
        int cont=0;
      while(vida1==true || vida2==true && terminobarra==false){
                segundos.setText(t + cont);
              cont++;
          barra1.setValue(barra1.getValue()+velo1);
                 barra2.setValue(barra2.getValue()+velo2);
               
                if(barra1.getValue()==100){
                    vida1=false;
                    terminobarra=true;
                    gano1=1;
                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador1");
                    break;
                    
                }
               
                else if (barra2.getValue()==100){
                    vida2=false;
                    terminobarra=true;
                    gano2=2;
                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador2");
                     break;
                }
                
                
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public int ganador (){
        if(gano1==1){
            return 1;
        }
        else {
            return 2;
        }
    }
    
}

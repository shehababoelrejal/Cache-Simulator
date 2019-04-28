package simulator;


import static java.lang.Math.pow;


public class setAssoc {
    private int W ;
    private int C;
    private int B  ;
    private int K ;
//    public  int offsetS = (int) (Math.log(B/K)/Math.log(2)) ; 
//    public  int indexS = (int) (Math.log(C/B)/Math.log(2));
//    public int tagS = W-indexS-offsetS;
//    public int IndexEnd = indexS+tagS;
    public int noSets ;
    public int noLines ;
//    public  int numOfLines = K * noLines;
    public int noWords ;
    
    
    
    public setAssoc(){
    
    W = 32;
    C = 1024;
    B = 64;
    K = 4;
    noSets = C/B;
    noLines = noSets*K;
    noWords = B/K;
    }
    public int getW()
    {
         return W;
    }

    public void setW(int W)
    {
        double Wd = (double)W; 
        if(W > 1024 && Wd % 8 != 0.0 && W <0)
        {
            System.err.println("W value must be <= 1024");
            System.exit(1);
        }
        else
        {
            this.W = W;
        }
    }

    public int getC()
    {
        return C;
    }

    public void setC(int C)
    {
        double Cd=(double)C;
        if(C > pow(2,W) && (Math.log(Cd)/Math.log(2))%1 != 0.0 && C<0)
        {
            System.err.println("C value must be <= 2 power W");
            System.exit(1);
        }
        else
        {
            this.C = C;
        }
    }

    public int getB()
    {
        return B;
    }

    public void setB(int B)
    {
        double Bd = (double)B;
        if(C % Bd == 0 && B > 0)
        {
            this.B = B;
        }
        else
        {
           System.err.println("B must be divisor of C");
           System.exit(1);  
        }
   }

    public int getK() 
    {
        return K;
    }

    public void setK(int K)
    {
        double Kd = (double)K;
        if(B%Kd == 0 && K>0)
        {
            this.K = K;
        }
        else
        {
           System.err.println("K must be divisor of B");
           System.exit(1);  
        }
    }
}

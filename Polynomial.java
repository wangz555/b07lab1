public class Polynomial{
    private double[] coefficient;
    //constructor1
    public Polynomial(){
        coefficient = new double[0];
    }
    //constructor2
    public Polynomial(double[] coefficient){
        this.coefficient = coefficient;
    }
    public Polynomial add(Polynomial other){
        double[] coeff;
        int len1 = this.coefficient.length;
        int len2 = other.coefficient.length;

        if(len1 < len2){
            coeff = new double[len2];
        }
        else{
            coeff = new double[len1];
        }
        for(int i=0;i<len1;i++){
            coeff[i]= coeff[i] + this.coefficient[i];
        }
        for(int i=0;i<len2;i++){
            coeff[i]= coeff[i] + other.coefficient[i];
        }
        return new Polynomial(coeff);
    }
    public double evaluate(double val){
        double result = 0.0;
        for(int i =0; i<this.coefficient.length;i++){
            result = result + this.coefficient[i]*Math.pow(val,i);
        }
        return result;
    }
    public boolean hasRoot(double val){
        return this.evaluate(val)==0.0;
    }
}
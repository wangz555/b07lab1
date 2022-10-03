import java.io.*;
import java.util.Scanner;
public class Polynomial{
    private double[] coefficient;
    private int[] exponents;
    //constructor1
    public Polynomial(){
        coefficient = new double[0];
        exponents = new int[0];
        //array equals to null
    }
    //constructor2
    public Polynomial(double[] coefficient, int[] exponents){
        this.coefficient = coefficient;
        this.exponents = exponents;
    }
    //constructor3
    public Polynomial(File myfile) throws IOException{
        Scanner file = new Scanner(myfile);
        String line = file.nextLine();
        file.close();

        line = line.replace("-","+-");
        String[] poly = line.split("\\+");

        this.coefficient = new double[poly.length];
        this.exponents = new int[poly.length];


        for(int i =0; i < poly.length; i++){
            String[] str = poly[i].split("x");
            this.coefficient[i] = Double.parseDouble(str[0]);
            if(str.length ==1){
                this.exponents[i] = 0;
            }
            else{
                this.exponents[i] = Integer.parseInt(str[1]);
            }
        }
    }
    //public Polynomial add(Polynomial other){}
    public double evaluate(double val){
        double result = 0.0;
        for(int i =0; i<this.coefficient.length;i++){
            result = result + this.coefficient[i]*Math.pow(val,this.exponents[i]);
        }
        return result;
    }
    public boolean hasRoot(double val){
        return this.evaluate(val)==0.0;
    }

    public void saveToFile(String file) throws IOException{
        FileWriter writeTXT = new FileWriter(file);
        String newline = "";
        int i,j;
        if(this.exponents[0]==0){
            newline += this.coefficient[0]+  "+";
            for (i = 1; i < this.coefficient.length -1; i++){
                newline += this.coefficient[i] + "x" + this.exponents[i] + "+";
            }
            newline += this.coefficient[i] + "x" + this.exponents[i];
        }
        else{
            for (j =0; j<this.coefficient.length - 1;j++){
                newline += this.coefficient[j] + "x" + this.exponents[j] + "+";
            }
            newline += this.coefficient[j] + "x" + this.exponents[j];
        }
        writeTXT.write(newline);
        writeTXT.close();
    }
}
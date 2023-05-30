public class Main {
    public static void main(String[] args) {
        double[] x = new double[6];
        double[] y =  new double[6];
        x[0] = 0;
        x[1] = 1;
        x[2] = 2;
        x[3] = 2.5;
        x[4] = 3;
        x[5] = 4;

        y[0]=1.4;
        y[1]=0.6;
        y[2]=1.0;
        y[3]=0.65;
        y[4]=0.6;
        y[5]=1;


/*        double[][] trazadores = cubicos.calcularTrazadoresGrado2(x,y);

        cubicos.imprimirFuncionesGrad2(x, trazadores);

        double[][] trazadoresGrado3 = cubicos.calcularTrazadoresGrado3(x, y);

        cubicos.imprimirFuncionGrado3(x, trazadoresGrado3);*/

        double[] trazadoresGrado0 = cubicos.calcularTrazadoresGrado0(x, y);
        cubicos.imprimirFuncionesGrado0(x, trazadoresGrado0);
        double[] grado1=cubicos.calcularTrazadoresGrado1(x,y);
        cubicos.imprimirFuncionesGrado1(x,grado1);
    }
}
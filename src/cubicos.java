public  class cubicos {
    public static double[][] calcularTrazadoresGrado2(double[] x, double[] y) {
        int n = x.length;
        double[] h = new double[n - 1];
        double[] alfa = new double[n];
        double[] l = new double[n];
        double[] u = new double[n];
        double[] z = new double[n];
        double[] c = new double[n];
        double[] b = new double[n];
        double[][] trazadores = new double[3][n - 1];

        // Calcular h
        for (int i = 0; i < n - 1; i++) {
            h[i] = x[i + 1] - x[i];
        }

        // Calcular alfa
        for (int i = 1; i < n - 1; i++) {
            alfa[i] = (3 / h[i]) * (y[i + 1] - y[i]) - (3 / h[i - 1]) * (y[i] - y[i - 1]);
        }

        // Resolver sistema tridiagonal
        l[0] = 1;
        u[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n - 1; i++) {
            l[i] = 2 * (x[i + 1] - x[i - 1]) - h[i - 1] * u[i - 1];
            u[i] = h[i] / l[i];
            z[i] = (alfa[i] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n - 1] = 1;
        z[n - 1] = 0;
        c[n - 1] = 0;

        // Calcular c y b
        for (int j = n - 2; j >= 0; j--) {
            c[j] = z[j] - u[j] * c[j + 1];
            b[j] = (y[j + 1] - y[j]) / h[j] - h[j] * (c[j + 1] + 2 * c[j]) / 3;
        }

        // Almacenar coeficientes de los trazadores
        for (int i = 0; i < n - 1; i++) {
            trazadores[0][i] = y[i];
            trazadores[1][i] = b[i];
            trazadores[2][i] = c[i];
        }

        return trazadores;
    }

    public static void imprimirFuncionesGrad2(double[] x, double[][] trazadores) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            double a = trazadores[0][i];
            double b = trazadores[1][i];
            double c = trazadores[2][i];

            System.out.println("Función " + (i + 1) + ":");
            System.out.println("f(x) = " + a + " + " + b + " * (x - " + x[i] + ") + " + c + " * (x - " + x[i] + ")^2");
            System.out.println();
        }
    }


    public static double[][] calcularTrazadoresGrado3(double[] x, double[] y) {
        int n = x.length;
        double[] h = new double[n - 1];
        double[] alfa = new double[n];
        double[] l = new double[n];
        double[] u = new double[n];
        double[] z = new double[n];
        double[] c = new double[n];
        double[] b = new double[n];
        double[] d = new double[n];
        double[][] trazadores = new double[4][n - 1];

        // Calcular h
        for (int i = 0; i < n - 1; i++) {
            h[i] = x[i + 1] - x[i];
        }

        // Calcular alfa
        for (int i = 1; i < n - 1; i++) {
            alfa[i] = (3 / h[i]) * (y[i + 1] - y[i]) - (3 / h[i - 1]) * (y[i] - y[i - 1]);
        }

        // Resolver sistema tridiagonal
        l[0] = 1;
        u[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n - 1; i++) {
            l[i] = 2 * (x[i + 1] - x[i - 1]) - h[i - 1] * u[i - 1];
            u[i] = h[i] / l[i];
            z[i] = (alfa[i] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n - 1] = 1;
        z[n - 1] = 0;
        c[n - 1] = 0;

        // Calcular c, b y d
        for (int j = n - 2; j >= 0; j--) {
            c[j] = z[j] - u[j] * c[j + 1];
            b[j] = (y[j + 1] - y[j]) / h[j] - h[j] * (c[j + 1] + 2 * c[j]) / 3;
            d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
        }

        // Almacenar coeficientes de los trazadores
        for (int i = 0; i < n - 1; i++) {
            trazadores[0][i] = y[i];
            trazadores[1][i] = b[i];
            trazadores[2][i] = c[i];
            trazadores[3][i] = d[i];
        }

        return trazadores;
    }

    public static void imprimirFuncionGrado3(double[] x, double[][] trazadores) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            double a = trazadores[0][i];
            double b = trazadores[1][i];
            double c = trazadores[2][i];
            double d = trazadores[3][i];

            System.out.println("Función " + (i + 1) + ":");
            System.out.println("f(x) = " + a + " + " + b + "(x - " + x[i] + ") + " + c + "(x - " + x[i] + ")^2 + " + d + "(x - " + x[i] + ")^3");
            System.out.println();
        }
    }





    public static double[] calcularTrazadoresGrado0(double[] x, double[] y) {
        int n = x.length;
        double[] trazadores = new double[n];

        for (int i = 0; i < n; i++) {
            trazadores[i] = y[i];
        }

        return trazadores;
    }

    public static void imprimirFuncionesGrado0(double[] x, double[] trazadores) {
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double a = trazadores[i];

            System.out.println("Función " + (i + 1) + ":");
            System.out.println("f(x) = " + a);
            System.out.println();
        }
    }



    public static double[] calcularTrazadoresGrado1(double[] x, double[] y) {
        int n = x.length;
        double[] trazadores = new double[2 * (n - 1)];

        for (int i = 0; i < n - 1; i++) {
            double m = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
            double b = y[i] - m * x[i];
            trazadores[2 * i] = m;
            trazadores[2 * i + 1] = b;
        }

        return trazadores;
    }

    public static void imprimirFuncionesGrado1(double[] x, double[] trazadores) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            double m = trazadores[2 * i];
            double b = trazadores[2 * i + 1];

            System.out.println("Función " + (i + 1) + ":");
            System.out.println("f(x) = " + m + " * x + " + b);
            System.out.println();
        }
    }


}

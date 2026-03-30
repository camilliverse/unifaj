package br.com.edu.unifaj.poo.arrow;

public class TesteArrwFunction {
    public static void main(String[] args) {
        testExecute(new Execute() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        })
    }
    public static String testExecute(Execute execute){
        return ex.execute("Maria")
    }
}

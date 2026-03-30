package br.com.edu.unifaj.poo.arrow;

public interface Execute {
    public interface execute {
        String execute(String str);
    }

    public class TesteArrowFunction {
        public static void main(String[] args) {
            System.out.println(
                    testExecute(x -> x.toUpperCase()));
        }

        public static String testExecute(execute ex) {
            return ex.execute("Maria");
        }
    }

import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean a = false;
        while (true) {
            try {
                int opcao = parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção:\n1 - Exercicio 1\n2 - Exercicio 2\n3 - Exercicio 3\n4 - Sair", "Menu", JOptionPane.INFORMATION_MESSAGE));
                switch (opcao) {
                    case 1:
                        exc1();
                        break;
                    case 2:
                        exc2();
                        break;
                    case 3:
                        exc3();
                        break;
                    case 4:
                        a = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
            if (a) {
                break;
            }
        }
    }

    public static void exc1(){
        // Exc1
        int qnt = 0;
        while (true) {
            try{
                qnt = parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de servidores:", "Exc1", JOptionPane.INFORMATION_MESSAGE));
                if (qnt <= 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero");
                    continue;
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
        }
        Stack<Integer> servers = new Stack<>();
        Stack<Integer> pilhAux = new Stack<>();
        for (int i = 0; i < qnt; i++) {
            while(true){
                try{
                    servers.push(parseInt(JOptionPane.showInputDialog(null, "Insira a carga de trabalho do server " + (i + 1) + ":", "Exc1", JOptionPane.INFORMATION_MESSAGE)));
                    if (qnt < 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser negativo");
                    servers.pop();
                    continue;
                    }
                    break;
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Valor Inválido");
                }
            }
        }
        int cont_dias = 0;
        while (true) {
            int cont_valido = 0;
            for(int i = 0; i < servers.size(); i++){
                int aux = servers.pop();
                if (aux < servers.peek()){
                    pilhAux.push(aux);
                    cont_valido++;
                }
            }
            int tmn = pilhAux.size();
            for (int i = 0; i < tmn; i++){
                servers.push(pilhAux.pop());
            }
            if (cont_valido == servers.size() - 1){
                break;
            }
            cont_dias++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cont_dias + " dias para que mais nenhum servidor seja desligado.\n");
        sb.append("Carga de trabalho dos servidores:\n");
        sb.append(servers.toString());
        JOptionPane.showMessageDialog(null, sb.toString(), "Exc1", JOptionPane.INFORMATION_MESSAGE);
        return;
    }


    public static void exc2(){
        // Exc2
        int pessoas = 0;
        while (true) {
            try{
                pessoas = parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de participantes:", "Exc2", JOptionPane.INFORMATION_MESSAGE));
                if (pessoas <= 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero");
                    continue;
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
        }
        int batidas = 0;
        while (true) {
            try{
                batidas = parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de batidas:", "Exc2", JOptionPane.INFORMATION_MESSAGE));
                if (batidas <= 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero");
                    continue;
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
        }

        Queue<Integer> fila = new LinkedList<>();
        for(int i = 0; i < pessoas; i++){
            fila.add(i + 1);
        }
        while(fila.size() > 1){
            for(int i = 0; i < batidas; i++){
                fila.add(fila.poll());
            }
            fila.poll();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("A pessoa que ganhou é a: " + fila.poll() + "\n");
        JOptionPane.showMessageDialog(null, sb.toString(), "Exc2", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    public static void exc3(){
        // Exc3
        LinkedList<Integer> lista = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();

        int aux = 0;
        int qnt = 0;
        while (true) {
            try{
                qnt = parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de números na primeira lista:", "Exc3", JOptionPane.INFORMATION_MESSAGE));
                if (qnt <= 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero");
                    continue;
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
        }
        for (int i = 0; i < qnt; i++) {
            while(true){
                try{
                    int in = parseInt(JOptionPane.showInputDialog(null, "Insira o número " + (i + 1) + " da primeira lista:", "Exc3", JOptionPane.INFORMATION_MESSAGE));
                    if(in < aux && i != 0){
                        JOptionPane.showMessageDialog(null, "Valor não pode ser menor que o anterior");
                        continue;
                    }
                    lista.add(in);
                    aux = in;
                    break;
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Valor Inválido");
                }
            }
        }
        while (true) {
            try{
                qnt = parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de números na segunda lista lista:", "Exc3", JOptionPane.INFORMATION_MESSAGE));
                if (qnt <= 0){
                    JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero");
                    continue;
                }
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valor Inválido");
            }
        }
        for (int i = 0; i < qnt; i++) {
            while(true){
                try{
                    int in = parseInt(JOptionPane.showInputDialog(null, "Insira o número " + (i + 1) + " da segunda lista:", "Exc3", JOptionPane.INFORMATION_MESSAGE));
                    if(in < aux && i != 0){
                        JOptionPane.showMessageDialog(null, "Valor não pode ser menor que o anterior");
                        continue;
                    }
                    lista2.add(in);
                    aux = in;
                    break;
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Valor Inválido");
                }
            }
        }

        LinkedList<Integer> lista_final = new LinkedList<>();

        while(!(lista.isEmpty() || lista2.isEmpty())){
            if(lista.getFirst() < lista2.getFirst()){
                lista_final.add(lista.removeFirst());
            }else if (lista.getFirst() > lista2.getFirst()){
                lista_final.add(lista2.removeFirst());
            } else{
                lista_final.add(lista.removeFirst());
                lista_final.add(lista2.removeFirst());
            }
        }

        while(!lista.isEmpty()){
            lista_final.add(lista.removeFirst());
        }
        while(!lista2.isEmpty()){
            lista_final.add(lista2.removeFirst());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Lista Final: \n" + lista_final.toString());
        JOptionPane.showMessageDialog(null, sb.toString(), "Exc3", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
}


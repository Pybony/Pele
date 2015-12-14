package br.com.chamados.genericos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author lksbr
 */
public class Cliente extends Thread {

    private String host = "192.168.198.129";
    private int porta = 11688;
    private String pkgRecebido;

    public Cliente() {
    }

    @Override
    public void run() {
        MulticastSocket socket = null;
        try {
            // determina endereco e porta
            InetAddress grupo = InetAddress.getByName(host);

            // cria multicast socket e se une ao grupo
            socket = new MulticastSocket(porta);

            socket.joinGroup(grupo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        boolean ativo = true; // habilita laco
        while (ativo) {
            try {
                // prepara buffer (vazio)
                byte[] buf = new byte[256];

                // prepara pacote para resposta
                DatagramPacket pacote = new DatagramPacket(buf, buf.length);

                // recebe pacote
                socket.receive(pacote);

                // exibe dados na area de texto
                String dados = new String(pacote.getData()).trim();

                pkgRecebido = dados + "\n";

                System.out.println("Recebido = " + pkgRecebido);
                JOptionPane.showMessageDialog(null, "Temos chamados novos para serem atendidos.");

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        socket.close();
    }
}

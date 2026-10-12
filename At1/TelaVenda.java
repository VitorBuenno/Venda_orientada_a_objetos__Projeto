package At1;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVenda extends JFrame {

    private JTextField campoMoedasCliente;
    private JTextField campoQuantidade;
    private JButton botaoComprar;
    
    //Informações antes da venda
    private JLabel infoVendedor;
    private JLabel infoCliente;

    public TelaVenda() {
        //Janela inicial
        super("Loja de Camisetas");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Feito para dividir onde cada informação fica
        setLayout(new BorderLayout());

        //Painel de informação
        JPanel painelInfo = new JPanel(new GridLayout(2, 1));
        infoVendedor = new JLabel("", JLabel.CENTER); // Chamado vazio por enquanto
        infoCliente = new JLabel("Cliente: Cleber (Iniciará com 0 camisetas)", JLabel.CENTER);
        
        // Adiciona os rótulos ao painel, e o painel à região Norte da Janela
        painelInfo.add(infoVendedor);
        painelInfo.add(infoCliente);
        add(painelInfo, BorderLayout.NORTH);

        //Centro da tela, onde ficam as informações preenchiveis
        JPanel painelFormulario = new JPanel(new GridLayout(2, 2, 5, 5));
        
        //Rótulo e caixa de escrita
        painelFormulario.add(new JLabel(" Moedas que o Cleber possui:"));
        campoMoedasCliente = new JTextField();
        painelFormulario.add(campoMoedasCliente);

        painelFormulario.add(new JLabel(" Quantidade a Comprar:"));
        campoQuantidade = new JTextField();
        painelFormulario.add(campoQuantidade);

        // Adiciona o painel de formulário ao centro
        add(painelFormulario, BorderLayout.CENTER);

        //Botão no sul
        botaoComprar = new JButton("Comprar");
        add(botaoComprar, BorderLayout.SOUTH);

        // Explicado abaixo
        atualizarInfoVendedor();

        //O qu eacontece quando o botão é apertado
        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Try e Catch para pegar os erros
                try {
                    int moedasCli = Integer.parseInt(campoMoedasCliente.getText());
                    int qtd = Integer.parseInt(campoQuantidade.getText());

                    //Cria o cliente
                    cliente comprador = (cliente) FactoryPessoa.criar("Cliente", "Cleber", moedasCli, 0);

                    // Resgata op vendedor
                    clt vendedor = LojaSingleton.getInstance().getVendedor();

                    //Aciona a venda. Cai no catch se der algum erro nas verificações da propria função
                    vendedor.vender(comprador, qtd);

                    //Mensagem de sucesso
                    String resultado = "COMPRA REALIZADA COM SUCESSO!\n\n" +
                                       "=== ESTADO DEPOIS DA COMPRA ===\n" +
                                       comprador.nota() + "\n" +
                                       vendedor.nota();
                
                    JOptionPane.showMessageDialog(TelaVenda.this, resultado, "Resumo da Operação", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Atualiza os dados do vendedor novamente
                    atualizarInfoVendedor();

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(TelaVenda.this, ex.getMessage(), "Transação Recusada", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    // PEga as informações do vendedor pelo singleton
    private void atualizarInfoVendedor() {
        clt vendedor = LojaSingleton.getInstance().getVendedor();
        infoVendedor.setText("Vendedor Atual: " + vendedor.getNome() + 
                             " | Moedas: " + vendedor.getMoedas() + 
                             " | Estoque: " + vendedor.getCamisetas() + 
                             " | Preço: " + vendedor.getPreco());
    }

    public static void main(String[] args) {
        new TelaVenda().setVisible(true);
    }
}
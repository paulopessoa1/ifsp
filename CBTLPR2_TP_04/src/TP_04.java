/*
 Nome: Paulo Eduardo da Silva Pessoa
 Prontuário: CB303092x

 Nome: Geovanna Barros de Assunção
 Prontario: CB303271X
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class TP_04 implements ActionListener 
{
    private int indiceAtual = 0;
    private static List<Funcionario> listaPessoa = new ArrayList<>();
    private JTextField txtPesquisa;
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JButton btnPesquisa, btnAnterior, btnProximo;

    public static void main(String[] args)
    {
        new TP_04().criarForm();
    }

    public void criarForm()
    {
        JFrame form = new JFrame("TP04 - LPR2");
        form.setSize(400,170);
        form.setLocationRelativeTo(null);
        form.setLayout(new BorderLayout());
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelsuperior = new JPanel(new GridLayout(1,3));
        painelsuperior.setBackground(Color.LIGHT_GRAY);
        painelsuperior.add(new JLabel("Nome:"));
        txtPesquisa = new JTextField();
        painelsuperior.add(txtPesquisa);
        btnPesquisa = new JButton("Pesquisa");
        btnPesquisa.addActionListener(this);
        painelsuperior.add(btnPesquisa);

        JPanel painelInferior = new JPanel(new GridLayout(4,2));
        painelInferior.setBackground(Color.LIGHT_GRAY);
        painelInferior.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        txtNome.setEditable(false);
        painelInferior.add(txtNome);
        painelInferior.add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        txtSalario.setEditable(false);
        painelInferior.add(txtSalario);
        painelInferior.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        txtCargo.setEditable(false);
        painelInferior.add(txtCargo);
        
        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Pr�ximo");

        btnAnterior.addActionListener(this);
        btnProximo.addActionListener(this);
        
        painelInferior.add(btnAnterior);
        painelInferior.add(btnProximo);

        form.add(painelsuperior, BorderLayout.CENTER);
        form.add(painelInferior, BorderLayout.SOUTH);

        form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnPesquisa)
        {
            try {
                String nomePesquisado = txtPesquisa.getText();
                listaPessoa = ExemploSQLServer.pesquisarFuncionarios(nomePesquisado);

                if(listaPessoa.isEmpty()) {
                		JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
                    return;
                }
                indiceAtual = 0;
                exibirFuncionario(indiceAtual);
            }catch (Exception ex) {
            }
        }
        if (e.getSource() == btnProximo) {
            if (indiceAtual < listaPessoa.size() - 1) {
                indiceAtual++;
                exibirFuncionario(indiceAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Último registro!");
            }
        }
        if (e.getSource() == btnAnterior) {
            if (indiceAtual > 0) {
                indiceAtual--;
                exibirFuncionario(indiceAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Primeiro registro!");
            }
        }
    }
    private void exibirFuncionario(int idx) {
        Funcionario f = listaPessoa.get(idx);
        txtNome.setText(f.getNome_func());
        txtSalario.setText(Double.toString(f.getSal_func()));
        txtCargo.setText(f.getDs_cargo());
    }
}
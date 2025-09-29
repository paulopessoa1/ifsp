using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace Proj_Listas_Agenda__WFA_
{
    public partial class Form1 : Form
    {
        private Contatos listaContatos;
        BindingSource bs;
        public Form1()
        {
            InitializeComponent();
            listaContatos = new Contatos(new List<Contato>());
            Contato c1 = new Contato(1, "maria@email.com", "Maria", new Data(15, 5, 1990), new List<Telefone>());
            c1.adicionarTelefone(new Telefone("Celular", "+551199999999"));
            listaContatos.adicionar(c1);

            Contato c2 = new Contato(2, "joao@email.com", "João", new Data(20, 8, 1985), new List<Telefone>());
            c2.adicionarTelefone(new Telefone("Residencial", "1133334444"));
            listaContatos.adicionar(c2);
            atualizarLista();
        }

        private void atualizarLista()
        {
            bs = new BindingSource();
            bs.DataSource = listaContatos.Agenda;
            dataGridView1.DataSource = bs;
            dataGridView1.Columns["DataNascimentoStr"].HeaderText = "Data de Nascimento";
            dataGridView1.Columns["TelefonePrincipalStr"].HeaderText = "Telefone Principal";
        }
        private void btnSair_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void btnAdicionar_Click(object sender, EventArgs e)
        {
            try
            {
                int id = Convert.ToInt32(txtID.Text);
                DateTime selectedDate = dateTimePicker1.Value;
                Contato novo = new Contato(id, txtEmail.Text, txtNome.Text,
                    new Data(selectedDate.Day, selectedDate.Month, selectedDate.Year),
                    new List<Telefone>());

                novo.adicionarTelefone(new Telefone(txtTipo.Text, txtNumero.Text));
                listaContatos.adicionar(novo);
                atualizarLista();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Erro ao adicionar contato: {ex.Message}");
            }
        }
        private void btnAlterar_Click(object sender, EventArgs e)
        {
            if (bs.Position < 0)
            {
                MessageBox.Show("Nenhum contato selecionado.");
                return;
            }
            Contato selecionado = listaContatos.Agenda[bs.Position];
            Contato contatoExistente = listaContatos.pesquisar(new Contato(selecionado.Id));

            if (contatoExistente.Id == -1)
            {
                MessageBox.Show("Contato não encontrado.");
                return;
            }
            DateTime selectedDateTime = dateTimePicker1.Value;

            contatoExistente.Nome = txtNome.Text;
            contatoExistente.Email = txtEmail.Text;
            contatoExistente.DtNasc = new Data(selectedDateTime.Day, selectedDateTime.Month, selectedDateTime.Year);

            DialogResult result = MessageBox.Show("Deseja adicionar um novo telefone? (S/N)", "Alterar contato", MessageBoxButtons.YesNo);
            if (result == DialogResult.Yes)
            {
                try
                {
                    contatoExistente.adicionarTelefone(new Telefone(txtTipo.Text, txtNumero.Text));
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Erro ao adicionar telefone: {ex.Message}");
                }
            }
            listaContatos.alterar(contatoExistente);
            atualizarLista();
        }

        private void btnRemover_Click(object sender, EventArgs e)
        {
            if (bs.Position >= 0)
            {
                Contato selecionado = listaContatos.Agenda[bs.Position];

                if (listaContatos.remover(selecionado))
                {
                    MessageBox.Show("Contato removido com sucesso!");
                    atualizarLista();
                }
                else
                {
                    MessageBox.Show("Erro ao remover contato.");
                }
            }
            else
            {
                MessageBox.Show("Selecione um contato para remover.");
            }
        }
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            MessageBox.Show(this.listaContatos.Agenda[bs.Position].ToString());
        }
        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (bs.Current is Contato c)
            {
                txtID.Text = c.Id.ToString();
                txtNome.Text = c.Nome;
                txtEmail.Text = c.Email;
                dateTimePicker1.Value = new DateTime(c.DtNasc.Ano, c.DtNasc.Mes, c.DtNasc.Dia);

                if (c.Telefones.Any())
                {
                    var tel = c.Telefones.Last();
                    txtTipo.Text = tel.Tipo;
                    txtNumero.Text = tel.Numero;
                }
            }
        }
    }
}

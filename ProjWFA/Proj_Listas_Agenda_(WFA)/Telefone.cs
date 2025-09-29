using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_Listas_Agenda__WFA_
{
    internal class Telefone
    {
        private string tipo;
        private string numero;
        private bool principal = false;
        public string Tipo
        {
            get => tipo;
            set => tipo = value ?? "";
        }
        public string Numero
        {
            get => numero;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                    throw new ArgumentException("Número inválido! Não pode ser vazio.");
                foreach (char c in value)
                {
                    if (!char.IsDigit(c) && c != '+' && c != '-' && c != ' ')
                        throw new ArgumentException("Número inválido! Contém caracteres não permitidos.");
                }

                numero = value;
            }
        }
        public bool Principal { get => principal; set => principal = value; }
        public Telefone(string tipo, string numero)
        {
            this.Tipo = tipo;
            this.Numero = numero;
        }
        public Telefone()
        {
            this.Tipo = "";
            this.Numero = "";
        }
    }
}

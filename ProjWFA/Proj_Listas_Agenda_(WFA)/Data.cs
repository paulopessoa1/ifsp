using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_Listas_Agenda__WFA_
{
    internal class Data
    {
        private int dia;
        private int mes;
        private int ano;
        public int Dia
        {
            get => dia;
            set
            {
                if (value < 1 || value > 31)
                    throw new ArgumentException("Dia inválido! Deve estar entre 1 e 31.");
                dia = value;
            }
        }
        public int Mes
        {
            get => mes;
            set
            {
                if (value < 1 || value > 12)
                    throw new ArgumentException("Mês inválido! Deve estar entre 1 e 12.");
                mes = value;
            }
        }
        public int Ano
        {
            get => ano;
            set
            {
                if (value < 1 || value > 9999)
                    throw new ArgumentException("Ano inválido! Deve ser positivo.");
                ano = value;
            }
        }
        public Data(int dia, int mes, int ano)
        {
            setData(dia, mes, ano);
        }
        public Data()
        {
            this.Dia = 1;
            this.Mes = 1;
            this.Ano = 1900;
        }
        public void setData(int dia, int mes, int ano)
        {
            this.Dia = dia;
            this.Mes = mes;
            this.Ano = ano;
        }
        public override string ToString()
        {
            return $"{this.dia:00}/{this.mes:00}/{this.ano:0000}";
        }
    }
}

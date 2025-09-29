using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_Listas_Agenda__WFA_
{
    internal class Contatos
    {
        private List<Contato> agenda = new List<Contato>();
        internal List<Contato> Agenda { get => agenda; }
        internal Contatos(List<Contato> agenda)
        {
            this.agenda = agenda;
        }
        public bool adicionar(Contato c)
        {
            if (!agenda.Contains(c))
            {
                agenda.Add(c);
                return true;
            }
            return false;
        }
        public Contato pesquisar(Contato c)
        {
            int id = agenda.IndexOf(c);
            if (id >= 0)
                return agenda[id];
            return null;
        }
        public bool alterar(Contato c)
        {
            int id = agenda.IndexOf(c);
            bool resAlterar = false;
            if (id >= 0)
            {
                resAlterar = true;
                agenda[id] = c;
            }
            return resAlterar;
        }
        public bool remover(Contato c)
        {
            bool remover = false;
            if (agenda.Contains(c))
            {
                remover = true;
                agenda.Remove(c);
            }
            return remover;
        }
    }
}

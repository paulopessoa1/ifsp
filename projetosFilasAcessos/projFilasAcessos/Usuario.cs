using System;
using System.Collections.Generic;
using System.Linq;

namespace projFilasAcessos
{
    internal class Usuario
    {
        private int id;
        private string nome;
        private List<Ambiente> ambientes = new List<Ambiente>();

        public int Id { get => id; set => id = value; }
        public string Nome { get => nome; set => nome = value; }
        internal List<Ambiente> Ambientes { get => ambientes; set => ambientes = value; }

        public Usuario(int id, string name)
        {
            Id = id;
            Nome = name ?? string.Empty;
        }

        public Usuario() : this(-1, string.Empty) { }
        public Usuario(int id) : this(id, string.Empty) { }

        public bool concederPermissao(Ambiente ambiente)
        {
            if (ambiente == null) return false;

            // Usa Any para verificar duplicidade de forma clara
            if (Ambientes.Any(a => a.Id == ambiente.Id))
                return false;

            Ambientes.Add(ambiente);
            return true;
        }

        public bool revogarPermissao(Ambiente ambiente)
        {
            if (ambiente == null) return false;

            // Remove apenas o primeiro encontrado (mais eficiente que RemoveAll)
            var item = Ambientes.FirstOrDefault(a => a.Id == ambiente.Id);
            if (item != null)
            {
                Ambientes.Remove(item);
                return true;
            }
            return false;
        }

        public override bool Equals(object obj)
        {
            return obj is Usuario u && Id == u.Id;
        }

        public override int GetHashCode()
        {
            return Id.GetHashCode();
        }
    }
}

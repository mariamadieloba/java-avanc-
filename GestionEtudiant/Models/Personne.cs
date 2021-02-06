using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
    class Personne
    {
        protected int id;
        protected String nomComplet;
        protected String type;
        protected String login;
        protected String pwd;

       
        public Personne()
        {
        }

        public Personne(int id, string nomComplet, string type, string login,string pwd)
        {
            this.Id = id;
            this.NomComplet = nomComplet;
            this.Type = type;
            this.Login = login;
            this.Pwd = pwd;
        }

        public Personne(int id, string nomComplet)
        {
            this.id = id;
            this.nomComplet = nomComplet;
        }

        public Personne(string nomComplet)
        {
            this.nomComplet = nomComplet;
        }

        public Personne(int id, string nomComplet, string type)
        {
            this.id = id;
            this.nomComplet = nomComplet;
            this.type = type;
        }

        public Personne(string login, string pwd)
        {
            this.login = login;
            this.pwd = pwd;
        }

        public int Id { get => id; set => id = value; }
        public string NomComplet { get => nomComplet; set => nomComplet = value; }
        public string Type { get => type; set => type = value; }
        public string Login { get => login; set => login = value; }
        public string Pwd { get => pwd; set => pwd = value; }
        

        public override string ToString()
        {
            return base.ToString();
        }
    }
}

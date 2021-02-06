using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
        class Etudiant: Personne { 

        private String tuteur;
        //manytoone
        private Classe classe;

        public string Tuteur { get => tuteur; set => tuteur = value; }
        public Classe Classe { get => classe; set => classe = value; }

        public Etudiant()
        {
            Type = "Etudiant";
        }


        public Etudiant(int id,string nomComplet,string tuteur):base(id,nomComplet)
        {
            this.Tuteur = tuteur;
            type = "Etudiant";
        }

        public Etudiant(string nomComplet, string tuteur) : base(nomComplet)
        {
            this.Tuteur = tuteur;
            type = "Etudiant";
        }

        public override bool Equals(object obj)
        {
            return base.Equals(obj);
        }

        public override string ToString()
        {
            return base.ToString();
        }
    }

}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
    class Details
    {
        private String annee;
        private List<String> modules;

        //manytoone
        private Classe classe;
        //manytoone
        private Professeur professeur;

        public string Annee { get => annee; set => annee = value; }
        public List<string> Modules { get => modules; set => modules = value; }
        internal Classe Classe { get => classe; set => classe = value; }
        internal Professeur Professeur { get => professeur; set => professeur = value; }

        public Details()
        {
        }

        public Details(Classe classe, Professeur professeur, string annee)
        {
            this.classe = classe;
            this.professeur = professeur;
            Annee = annee;
        }


    }

}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
    class Professeur:Personne
    {
        private String grade;
        private String matricule;
        private List<String> modules;

        public string Grade { get => grade; set => grade = value; }
        public List<string> Modules { get => modules; set => modules = value; }
        public string Matricule{ get => matricule; set => matricule = value; }

        public Professeur()
        {
            Type = "Professeur";
        }

        public Professeur(int id,string nomComplet,string grade,string matricule)
            :base(id,nomComplet)
        {
            this.grade = grade;
            this.matricule = matricule;
            Type = "Professeur";
        }


        public Professeur(string nomComplet,string grade,string matricule):base(nomComplet)
        {
            this.grade = grade;
            this.matricule = matricule;
            Type = "Professeur";
        }

        public override string ToString()
        {
            return base.ToString();
        }
    }
}

using GestionEtudiant.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    class DaoPersonne : IDao<Personne>
    {
        private DaoSql sqlServer;
        public DaoPersonne()
        {
            sqlServer = new DaoSql();
        }

        public int Insert(Personne pers)
        {
            String sql = String.Format("INSERT INTO gestion_schema.personne (type, nom_complet " +
                "tuteur, modules, grade, matricule, " +
                "classe_id,login,pwd) VALUES ({0},{1} ,{2}, {3}, " +
                "{4}, {5},{6},{7}) ", pers.NomComplet, pers.Type,
                ((Etudiant)pers).Tuteur, Models.Convert.ListToString(((Professeur)pers).Modules), 
                ((Professeur)pers).Grade, ((Professeur)pers).Matricule, ((Etudiant)pers).Classe.Id);

            return sqlServer.ExecuteUpdate(sql);

        }

        public DataTable FindByClasse(Classe classe)
        {
            
            //ecrire la requete
            String sql = string.Format("select "
                + "p.id, nom_Complet as 'Nom & Prenom', tuteur, libelle as Classe, nbre_etudiant "
                + "from gestion_schema.personne p, gestion_schema.classe cl "
                + "where classe_id ={0} "
                +"and cl.id = p.classe_id ",classe.Id);

            //Remplir la List d'etudiants

                return sqlServer.ExecuteSelect(sql);

        }

      public Personne FindUserConnect(String login, String pwd)
        {
            Personne pers = null;
            String sql = String.Format("select * from gestion_schema.personne " + 
                                        " where login='{0}' and pwd='{1}' ",
                                        login, pwd);


            //Executer la requete 
            DataTable dt = sqlServer.ExecuteSelect(sql);

            foreach (DataRow row in dt.Rows){
                String type = row.ItemArray[2].ToString().Trim();
                if(type.CompareTo("Admin") == 0)
                {
                    pers = new Admin();
                }

                if (type.CompareTo("Professeur") == 0)
                {
                    pers = new Professeur()
                    {
                        Grade = row.ItemArray[6].ToString().Trim(),
                        Matricule = row.ItemArray[8].ToString().Trim(),
                        Modules = Models.Convert.StringToList(row.ItemArray[7].ToString().Trim())

                    };
                }

                if (type.CompareTo("Etudiant") == 0)
                {
                    pers = new Etudiant()
                    {
                        Tuteur = row.ItemArray[5].ToString().Trim()
                    };
                }

                //Champs Communs
                pers.Id = int.Parse(row.ItemArray[0].ToString().Trim());
                pers.NomComplet = row.ItemArray[1].ToString().Trim();

            }
               
            return pers;
           
        }
    }
}

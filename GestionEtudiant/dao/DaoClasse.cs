using GestionEtudiant.Models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    public class DaoClasse : IDao<Classe>
    {
        private DaoSql sqlServer;

        public DaoClasse()
        {
            sqlServer = new DaoSql();
        }

        public int Insert(Classe classe)
        {
            String sql = String.Format(" INSERT INTO gestion_schema.classe (libelle, nbre_etudiant) VALUES ('{0}',{1}) ",classe.Libelle,classe.NbreEtudiant);
            return sqlServer.ExecuteUpdate(sql);
        }

        public List<Classe> FindAll()
        {
            List<Classe> lClasses = new List<Classe>();

            String sql = String.Format(" select * from gestion_etudiant.gestion_schema.classe ");

            //Remplir la Liste
            DataTable dt = sqlServer.ExecuteSelect(sql);
            //Convertir otre datatable en une list<classe>
            foreach(DataRow row in dt.Rows)
            {
                Classe classe = new Classe()
                {
                    Id = int.Parse(row.ItemArray[0].ToString().Trim()),
                    Libelle = row.ItemArray[1].ToString().Trim(),
                    NbreEtudiant = int.Parse(row.ItemArray[2].ToString().Trim())
                };
                lClasses.Add(classe);

            }

            return lClasses;
        }
    }
}

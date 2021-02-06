using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    class DaoSql
    {
        //gerer la connexion dans base donnee sqlServer
        private SqlConnection conn;
        //execution des requetes 
        private SqlCommand cmd;
        //convertir les enregistrement de la BD dans un DataSet
        private SqlDataAdapter da;

        public DaoSql()
        {
            conn = new SqlConnection();
            cmd = new SqlCommand();
            da = new SqlDataAdapter();

        }

        public void OuvrirConnexionBD()
        {
            if (conn.State==ConnectionState.Closed ||
                conn.State==ConnectionState.Broken)
            {
                conn.ConnectionString = @"Data Source = DESKTOP-I4P5OMV; Initial Catalog=gestion_etudiant;Integrated Security= True";
                conn.Open();
            }


        }

        public void FermerConnexionBD()
        {
            if (conn.State == ConnectionState.Open ||
                conn.State == ConnectionState.Connecting)

            {
                conn.Close();
            }

        }

        public int ExecuteUpdate(string sql)
        {
            int nbreLigne = 0;

              OuvrirConnexionBD();

                cmd.Connection = conn;
                cmd.CommandText = sql;

                nbreLigne=cmd.ExecuteNonQuery();

               FermerConnexionBD();
              
                   return nbreLigne;

        }

        public System.Data.DataTable ExecuteSelect(string sql)
        {
            OuvrirConnexionBD();

                cmd.Connection = conn;
                cmd.CommandText = sql;
            //DataSet=>Base de Donnee en Memoire Centrale(RAM)
            //DataSet est formé de DataTable => Table BD
            DataSet ds = new DataSet();

            // A ajouter
            da.SelectCommand = cmd;

            da.Fill(ds, "result");

            FermerConnexionBD();
            return ds.Tables["result"];
           
        }
    }
}

using GestionEtudiant.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using GestionEtudiant.Services;

namespace GestionEtudiant
{
    public partial class Form1 : Form
    {
        private Service metier = new Service();

        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnAjouter_Click(object sender, EventArgs e)
        {
            if(String.IsNullOrEmpty(txtLibelle.Text) 
                || String.IsNullOrEmpty(txtNbreEtudiant.Text))
            {
                MessageBox.Show("Le libelle ou le Nbre d'Etudiant sont obligatoire",
                    "Message Erreur",
                    MessageBoxButtons.OKCancel,
                    MessageBoxIcon.Error
                    );
            }
            else
            {
                Classe classe = new Classe()
                {
                    Libelle=txtLibelle.Text.Trim(),
                    NbreEtudiant=int.Parse(txtNbreEtudiant.Text.Trim())
                };

                if (metier.CreerClasse(classe))
                {
                    MessageBox.Show(
                    "classe crée avec sucess!!",
                    "Message Information",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information
                    );
                    //Vider les champs
                    txtLibelle.Clear();
                    txtNbreEtudiant.Clear();
                    //recharger le  datagradeview
                    loadDataGridView();
                }
               
                }
            }

        private void Form1_Load(object sender, EventArgs e)
        {
            loadDataGridView();
        }

        private void loadDataGridView()
        {
            dtgvClasses.DataSource = metier.ListerClasse();

        }

        private void dtgvClasses_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
           
        }

        private void dtgvClasses_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            
            //e.RowIndex: index de la Ligne Selectionnee
            //recuperer la ligne selectionnee
                DataGridViewRow row = dtgvClasses.Rows[e.RowIndex];
            // Selectionner toute la ligne
                row.Selected = true;
            // recuperation de l'ID classe
            //  row.Cells :Recupere les cellules de la ligne
            int id = int.Parse(row.Cells[0].Value.ToString());
            Classe classe = new Classe()
            {
                Id = id
            };
            //charger le dtgvEtudiant
            dtgvEtudiants.DataSource = metier.ListerEtudiantParClasse(classe);
        }
    }
    }




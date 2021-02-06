using GestionEtudiant.entityframework;
using GestionEtudiant.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GestionEtudiant
{
    
    public partial class FrmProfesseur : Form
    {
        ServiceEF metier = new ServiceEF();

        public FrmProfesseur()
        {
            InitializeComponent();
        }

        private void FrmProfesseur_Load(object sender, EventArgs e)
        {
            //charger le comboClasse
            cboClasse.DataSource = metier.ListerClasse();
            cboClasse.DisplayMember = "libelle";
            cboClasse.ValueMember = "id";

            //charger le comboGrade
            cboGrade.DataSource = metier.ListerGrade();

            //charger le comboModules
            cboModule.DataSource = metier.ListerModules();

        }

        personne prof;
        

        private void txtMatricule_TextChanged(object sender, EventArgs e)
        {
            if(!string.IsNullOrEmpty(txtMatricule.Text))
            {
                prof= metier.ChercherProfesseurParMatricule(txtMatricule.Text.Trim());
                if (prof !=null)
                {
                    txtNomPrenom.Text = prof.nom_complet;
                    //selectionner le grade du professeur
                    cboGrade.SelectedItem = prof.grade;
                    //Charger les classes enseignés par professeur
                    LoadLboxClassesEnseignes();
                    //Charger les Modules Enseignés Par un Professeur dans une classe
                    LoadLboxModulesEnseignes();
                }
                else
                {
                    txtNomPrenom.Clear();
                    //selectionner le premier element du combo
                    cboGrade.SelectedIndex = 0;
                }
            }
        }

        private void lboClassesEnseignes_SelectedIndexChanged(object sender, EventArgs e)
        {
            //classe selectionne
            LoadLboxModulesEnseignes();
        }

        private void btnAddClasse_Click(object sender, EventArgs e)
        {
            /* classe classeSelected = (classe) cboClasse.SelectedItem;
             //ajout une nouvelle classe dans la listeBox de Classe
             classeEnseignees.Add(classeSelected);
             //Vider Datasource list box
             lboClassesEnseignes.DataSource = null;
             //charger listeBox de la classe
             lboClassesEnseignes.DataSource = classeEnseignees;
             lboClassesEnseignes.DisplayMember = "libelle";
             //selectionner par defaut la classe Ajoutée
            // lboClassesEnseignes.SelectedItem = classeSelected;
         */

            //Vider Datasource list box classe
            lboClassesEnseignes.Items.Clear();
            //Vider Datasource list box modules
            lboModulesEnseignes.Items.Clear();
        }

        private void LoadLboxClassesEnseignes()
        {
            List<classe> classeEnseignees=metier.ClassesEnseignees(prof);  
            foreach (classe cl in classeEnseignees)
            {
                lboClassesEnseignes.Items.Add(cl);
            }
            //selectionner la premeiere classe
            lboClassesEnseignes.SelectedIndex = 0;

        }

        private void LoadLboxModulesEnseignes()
        {
            classe classeSelected = (classe)lboClassesEnseignes.SelectedItem;
            List<String> ModulesEnseignes = metier.ListerModulesProfesseurParClasse(classeSelected, prof); ;
            lboModulesEnseignes.Items.Clear();

            foreach (string module in ModulesEnseignes)
            {
                lboModulesEnseignes.Items.Add(module);
            }

        }

    }
}

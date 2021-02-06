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
    public partial class FrmInscription : Form
    {
        private ServiceEF metierEF = new ServiceEF();


        public FrmInscription()
        {
            InitializeComponent();
        }

        private void FrmInscription_Load(object sender, EventArgs e)
        {
            //Chargement du comboBox
            //propriete afficher=> DisplayMember
            //proprete retournee apres Select d'un elt du combo => ValueMember
            cboClasse.DataSource = metierEF.ListerClasse();
            cboClasse.DisplayMember = "libelle";
            cboClasse.ValueMember = "id";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //Inscripton d'un etudiant 
            if (string.IsNullOrEmpty(txtNomPrenom.Text) || string.IsNullOrEmpty(txtTuteur.Text))
            {
                MessageBox.Show(
                    "Champs Obligatoires",
                    "Erreur",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                    );
            }
            else
            {
                personne pers = new personne()
                {
                    nom_complet = txtNomPrenom.Text.Trim(),
                    tuteur = txtTuteur.Text.Trim(),
                    type="Etudiant",
                    classe_id=int.Parse(cboClasse.SelectedValue.ToString())

                };
                if (metierEF.CreerPersonne(pers))
                {
                    MessageBox.Show(
                    "Etudiant inscrit avec succes",
                    "Information",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information
                    );
                }
                else
                {
                    MessageBox.Show(
                    "Erreur d'inscription",
                    "Erreur",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                    );
                }
            }
        }
    }
}

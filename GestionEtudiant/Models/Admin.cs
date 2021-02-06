using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
    class Admin:Personne
    {
        public Admin():base()
        {
            Type = "Admin";
        }

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.Models
{
    public class Convert
    {
        public static string ListToString(List<String> modules)
        {
            string moduleString = "";
            foreach (var elt in modules)
            {
                moduleString += elt + ";";
            }
            return moduleString;
        }

        public static List<String> StringToList(String modules)
        {
            return modules.Split(';').ToList();
        }
    }
}

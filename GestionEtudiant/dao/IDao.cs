using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestionEtudiant.dao
{
    //T peut etre une personne, un details ou une classe
    public interface IDao<T>
    {
        int Insert(T obj);

    }
}

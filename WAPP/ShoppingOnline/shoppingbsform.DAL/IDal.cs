using shoppingbsform.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.DAL
{
    public interface IDal
    {
        bool Add(IEntity entity);
        bool Delete(string id);

        bool Edit(IEntity entity);

        IList<T> GetList<T>(string where, object obj);

        int GetCount(string where, object obj);

        T GetEntity<T>(string id);

        List<T> GetEntitiesByName<T>(string name, string value);
    }
}

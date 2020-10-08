using Dapper.Contrib.Extensions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Utils
{
    public class EntityHelper
    {
        public static string GetTableName(Type type)
        {
            var attribute = type.GetCustomAttributes(typeof(TableAttribute), false).FirstOrDefault();

            if (attribute == null)
            {
                return null;
            }

            return ((TableAttribute)attribute).Name;
        }

        public static PropertyInfo GetSingleKey(Type type)
        {
            foreach (var propertyInfo in type.GetProperties())
            {

                var attribute = propertyInfo.GetCustomAttributes(typeof(ExplicitKeyAttribute), false).FirstOrDefault();

                if (attribute != null)
                {
                    return propertyInfo;
                }

            }

            return null;

        }
    }
}

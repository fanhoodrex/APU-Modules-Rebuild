using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Utils
{
    /// <summary>
    /// json 序列化方式
    /// </summary>
    public static class JsonHelper
    {
        /// <summary>
        /// jason序列化
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        public static string Serializer(object o)
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(o);
        }
        /// <summary>
        /// jason反序列化
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="s"></param>
        /// <returns></returns>
        public static T Deserialize<T>(string s)
        {

            return Newtonsoft.Json.JsonConvert.DeserializeObject<T>(s);
        }

        /// <summary>
        /// jason反序列化
        /// </summary>
        /// <param name="s">字符串</param>
        /// <param name="type">类型</param>
        /// <returns></returns>
        public static object Deserialize(string s, Type type)
        {
            return Newtonsoft.Json.JsonConvert.DeserializeObject(s, type);
        }
    }
}

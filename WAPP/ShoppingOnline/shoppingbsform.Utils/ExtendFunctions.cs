using Newtonsoft.Json;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Utils
{
    public static class ExtendFunctions
    {
        public static string ToJson(this object data)
        {
            return JsonConvert.SerializeObject(data);
        }
        /// <summary>
        /// 转换为base64
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public static string ToBase64String(this string value)
        {
            if (string.IsNullOrWhiteSpace(value))
            {
                return "";
            }
            byte[] bytes = Encoding.UTF8.GetBytes(value);
            return Convert.ToBase64String(bytes);
        }

        /// <summary>
        /// base64解码
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public static string FromBase64String(this string value)
        {
            if (string.IsNullOrWhiteSpace(value))
            {
                return "";
            }
            byte[] bytes = Convert.FromBase64String(value);
            return Encoding.UTF8.GetString(bytes);
        }
        public static void ThrowIfNullOrEmpty(this string data, string name)
        {
            if (string.IsNullOrEmpty(data))
            {
                throw new ArgumentException(name);
            }
        }

        public static void ThrowIfNullOrEmpty(this IEnumerable data, string name)
        {
            if (data == null || !data.GetEnumerator().MoveNext())
            {
                throw new ArgumentException(name);
            }
        }
        public static int ToInt32(this string value)
        {
            int result;
            int.TryParse(value, out result);
            return result;
        }

        public static short ToInt(this bool value)
        {
            short result;
            result = value ? (short)1 : (short)0;
            return result;
        }

        public static bool IsNullOrEmpty(this string inputvalue)
        {
            if (inputvalue != null)
                inputvalue = inputvalue.Trim();
            return string.IsNullOrEmpty(inputvalue);
        }

        public static bool IsNotNullOrEmpty(this string inputvalue)
        {
            return !string.IsNullOrEmpty(inputvalue);
        }

        public static double ToDouble(this string inputvalue)
        {
            double result;
            double.TryParse(inputvalue, out result);
            return result;
        }

        public static bool ToBoolean(this string inputvalue)
        {
            bool flag = inputvalue.ToLower() == "true";
            bool result;
            if (flag)
            {
                result = true;
            }
            else
            {
                bool flag2 = inputvalue.ToLower() == "false";
                if (flag2)
                {
                    result = false;
                }
                else
                {
                    bool flag3 = inputvalue.ToLower() == "1";
                    if (flag3)
                    {
                        result = true;
                    }
                    else
                    {
                        bool flag4 = inputvalue.ToLower() == "0";
                        if (flag4)
                        {
                            result = false;
                        }
                        else
                        {
                            bool flag5 = inputvalue.ToLower() == "1";
                            result = flag5;
                        }
                    }
                }
            }
            return result;
        }

        public static string IsNulltoString(this object inputvalue)
        {
            string result = "";
            bool flag = inputvalue != null;
            if (flag)
            {
                result = inputvalue.ToString();
            }
            return result;
        }

        /// <summary>
        /// 扩展 获取变量名称(字符串)
        /// </summary>
        /// <param name="var_name"></param>
        /// <param name="exp"></param>
        /// <returns>return string</returns>
        public static string GetVarName<T>(this T var_name, System.Linq.Expressions.Expression<Func<T, T>> exp)
        {
            return ((System.Linq.Expressions.MemberExpression)exp.Body).Member.Name;
        }

    }
}

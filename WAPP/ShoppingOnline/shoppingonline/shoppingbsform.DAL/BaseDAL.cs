using Dapper;
using Dapper.Contrib.Extensions;
using shoppingbsform.Model;
using shoppingbsform.Utils;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.DAL
{
    /// <summary>
    /// 数据库访问基类
    /// </summary>
    /// <typeparam name="T">实体类类型</typeparam>
    public partial class BaseDAL<T> where T : class
    {
        private string _tablename;
        /// <summary>
        /// 对象的表名
        /// </summary>
        public string TableName
        {
            get
            {
                if (_tablename == null)
                {
                    _tablename = EntityHelper.GetTableName(typeof(T));
                }
                return _tablename;
            }
            set
            {
                _tablename = value;
            }
        }

        private PropertyInfo primarykey;
        /// <summary>
        /// 主键属性对象
        /// </summary>
        public PropertyInfo PrimaryKey
        {
            get
            {
                if (primarykey == null)
                {
                    primarykey = EntityHelper.GetSingleKey(typeof(T));
                }
                return primarykey;
            }
            set => primarykey = value;
        }


        /// <summary>
        /// 数据库连接
        /// </summary>
        protected IDbConnection Connection
        {
            get
            {
                var connection = ConnectionFactory.CreateConnection();
                connection.Open();
                return connection;
            }
        }

        /// <summary>
        /// 返回数据库所有的对象集合
        /// </summary>
        /// <returns></returns>
        public IEnumerable<T> GetAll()
        {
            using (IDbConnection dbConnection = Connection)
            {
                return dbConnection.GetAll<T>();
            }
        }


        /// <summary>
        /// 查询数据库,返回指定ID的对象
        /// </summary>
        /// <param name="id">主键的值</param>
        /// <returns></returns>
        public T FindByID(object id)
        {
            using (IDbConnection dbConnection = Connection)
            {
                return dbConnection.Get<T>(id);
            }
        }

        public T FindByName(string name, object obj)
        {
            var sql = $"select * from {TableName} where {name}=@{name}";
            return Connection.QueryFirstOrDefault<T>(sql, obj);
        }

        /// <summary>
        /// 插入指定对象到数据库中
        /// </summary>
        /// <param name="info">指定的对象</param>
        /// <returns></returns>
        public bool Insert(T info)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                dbConnection.Insert(info);
                result = true;
            }
            return result;
        }
        /// <summary>
        /// 插入指定对象集合到数据库中
        /// </summary>
        /// <param name="list">指定的对象集合</param>
        /// <returns></returns>
        public bool Insert(IEnumerable<T> list)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.Insert(list) > 0;
            }
            return result;
        }

        /// <summary>
        /// 更新对象属性到数据库中
        /// </summary>
        /// <param name="info">指定的对象</param>
        /// <returns></returns>
        public bool Update(T info)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.Update(info);
            }
            return result;
        }
        /// <summary>
        /// 更新指定对象集合到数据库中
        /// </summary>
        /// <param name="list">指定的对象集合</param>
        /// <returns></returns>
        public bool Update(IEnumerable<T> list)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.Update(list);
            }
            return result;
        }
        /// <summary>
        /// 从数据库中删除指定对象
        /// </summary>
        /// <param name="info">指定的对象</param>
        /// <returns></returns>
        public bool Delete(T info)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.Delete(info);
            }
            return result;
        }
        /// <summary>
        /// 从数据库中删除指定对象集合
        /// </summary>
        /// <param name="list">指定的对象集合</param>
        /// <returns></returns>
        public bool Delete(IEnumerable<T> list)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.Delete(list);
            }
            return result;
        }
        /// <summary>
        /// 根据指定对象的ID,从数据库中删除指定对象
        /// </summary>
        /// <param name="id">对象的ID</param>
        /// <returns></returns>
        public bool Delete(object id)
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                string query = string.Format("DELETE FROM {0} WHERE {1} = @id", TableName, PrimaryKey.Name);
                var parameters = new DynamicParameters();
                parameters.Add("@id", id);

                result = dbConnection.Execute(query, parameters) > 0;
            }
            return result;
        }
        /// <summary>
        /// 从数据库中删除所有对象
        /// </summary>
        /// <returns></returns>
        public bool DeleteAll()
        {
            bool result = false;
            using (IDbConnection dbConnection = Connection)
            {
                result = dbConnection.DeleteAll<T>();
            }
            return result;
        }

    }
}

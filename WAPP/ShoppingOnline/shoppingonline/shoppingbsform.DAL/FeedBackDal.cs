using Dapper;
using shoppingbsform.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.DAL
{
    public class FeedBackDal : BaseDAL<Feedback>
    {
        public Feedback FindFeedback(string userid, FeedBackState state)
        {
            var sql = string.Empty;
            if (state == FeedBackState.UnReplay)
            {
                sql = $"select * from {TableName} where state=@state";
            }
            else
            {
                sql = $"select * from {TableName} where userid=@userid and state=@state";
            }
            var obj = Connection.QueryFirstOrDefault<Feedback>(sql, new Feedback { Userid = userid, State = state });
            return obj;
        }
    }
}

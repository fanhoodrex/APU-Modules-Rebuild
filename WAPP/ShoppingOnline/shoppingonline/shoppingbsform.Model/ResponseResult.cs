using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Model
{
    public class ResponseResult
    {
        public string message { get; set; }

        public bool Success { get; set; }

        public object Data { get; set; }
    }
}

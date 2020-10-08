using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Model
{
    public class UserCart
    {
        public string CartId { get; set; }
        public string Username { get; set; }

        public string Userid { get; set; }

        public string Bookname { get; set; }

        public string Bookid { get; set; }

        public decimal BookPrice { get; set; }

        public string Image { get; set; }
    }
}

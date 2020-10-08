using shoppingbsform.Model;
using shoppingbsform.Utils;
using shoppingbsform.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace shoppingbsform.Views
{
    public partial class BookDetail : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request.Url.AbsoluteUri.Split('?').Length > 1 && Request.HttpMethod == "GET")
            {
                var id = Request.Url.AbsoluteUri.Split('?')[1].ToLower().Replace("modify", string.Empty);
                var book = BooksViewModel.Instance.GetBook(id);

                bookname.Text = book.Name;
                Price.Text = book.Price.ToString();
                DescriptionTxt.Text = book.Description;
                InfomationsTxt.Text = book.Information;
                bookimage.ImageUrl = "data:image/jpeg;base64," + book.Image;
            }
        }

        protected void uploadimage_Load(object sender, EventArgs e)
        {

        }

        protected void save_Click(object sender, EventArgs e)
        {
            if (Request.Url.AbsoluteUri.Split('?').Length > 1 && Request.Url.AbsoluteUri.ToLower().EndsWith("modify"))
            {
                var id = Request.Url.AbsoluteUri.Split('?')[1].ToLower().Replace("modify", string.Empty);

                var image = bookimage.ImageUrl.Replace("data:image/jpeg;base64,", string.Empty);
                if (uploadimage.PostedFile.ContentLength > 0)
                {
                    
                    image = Tool.StreamToBase64(uploadimage.PostedFile.InputStream);
                }
                var book = new Book()
                {
                    Id = id,
                    Name = bookname.Text,
                    Image = image,
                    Description = DescriptionTxt.Text,
                    Information  = InfomationsTxt.Text
                };

                book.Price = Convert.ToDecimal(Price.Text);
                var result = BooksViewModel.Instance.ModifyBook(book);
                if (result)
                {
                    Response.Redirect("~/");
                }
            }
            else
            {
                var imageurl = bookimage.ImageUrl;
                var image = Tool.StreamToBase64(uploadimage.PostedFile.InputStream);

                var result = BooksViewModel.Instance.AddBook(bookname.Text, image, Convert.ToDecimal(Price.Text), DescriptionTxt.Text, InfomationsTxt.Text);
                if (result)
                {
                    Response.Redirect("~/");
                }
            }
        }
    }
}
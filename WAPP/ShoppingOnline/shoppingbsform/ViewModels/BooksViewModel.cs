using shoppingbsform.DAL;
using shoppingbsform.Model;
using shoppingbsform.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace shoppingbsform.ViewModels
{
    public class BooksViewModel
    {
        public static BooksViewModel Instance = new BooksViewModel();

        private BookDal dal = new BookDal();
        public List<Book> GetALlBooks()
        {
            try
            {
                return dal.GetAll().OrderBy(m=>m.Name).ToList();
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return new List<Book>();
        }

        public Book GetBook(string id)
        {
            try
            {
                return dal.FindByID(id);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return null;
        }
        public bool AddBook(string bookname, string image,decimal price, string description, string information)
        {
            try
            {
                bookname = bookname.Replace("'", "");
                description = description.Replace("'", "");
                information = information.Replace("'", "");
                var book = new Book()
                {
                    Name = bookname,
                    Image = image,
                    Description = description,
                    Information = information,
                    Price = price
                };
                book.Id = Tool.GetNewGuid();

                return dal.Insert(book);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }

        public bool ModifyBook(Book book)
        {
            try
            {
                book.Name = book.Name.Replace("'", "");
                book.Description = book.Description.Replace("'", "");
                book.Information = book.Information.Replace("'", "");
                return dal.Update(book);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }

        public bool DeleteBook(string id)
        {
            try
            {
                var result =  dal.Delete(id);
                if (result) //delete carts
                {
                    dal.DeleteCartsByBook(id);
                }
                return true;
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }
    }
}
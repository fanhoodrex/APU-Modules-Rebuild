using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;

namespace shoppingbsform.Utils
{
    public class Tool
    {
        public static string GetNewGuid()
        {
            return System.Guid.NewGuid().ToString();
        }

        public static void SaveBase64ToPhoto(string UserPhoto, string filePath)
        {
            try
            {
                UserPhoto = UserPhoto.Replace("data:image/jpeg;base64,", string.Empty);
                //将Base64String转为图片并保存
                byte[] arr2 = Convert.FromBase64String(UserPhoto);
                using (MemoryStream ms2 = new MemoryStream(arr2))
                {
                    System.Drawing.Bitmap bmp2 = new System.Drawing.Bitmap(ms2);
                    ////只有把当前的图像复制一份，然后把旧的Dispose掉，那个文件就不被锁住了，
                    ////这样就可以放心覆盖原始文件，否则GDI+一般性错误(A generic error occurred in GDI+)
                    //System.Drawing.Bitmap bmpNew = new System.Drawing.Bitmap(bmp2);
                    //bmp2.Dispose();
                    //bmp2 = null;
                    bmp2.Save(filePath, System.Drawing.Imaging.ImageFormat.Jpeg);
                    //bmp2.Save(filePath + ".jpg", System.Drawing.Imaging.ImageFormat.Jpeg);
                    //bmp2.Save(filePath + ".bmp", System.Drawing.Imaging.ImageFormat.Bmp);
                    //bmp2.Save(filePath + ".gif", System.Drawing.Imaging.ImageFormat.Gif);
                    //bmp2.Save(filePath + ".png", System.Drawing.Imaging.ImageFormat.Png);
                    bmp2.Dispose();
                }
            }
            catch (Exception ex)
            {
                Log.Error("图片保存错误", ex);
            }
        }

        public static void SaveFaceBase64ToPhoto(string UserPhoto, string filePath)
        {
            try
            {
                UserPhoto = UserPhoto.Replace("data:image/jpeg;base64,", string.Empty);
                //将Base64String转为图片并保存
                byte[] arr2 = Convert.FromBase64String(UserPhoto);
                using (MemoryStream ms2 = new MemoryStream(arr2))
                {

                    using (var bmp2 = new System.Drawing.Bitmap(ms2))
                    {
                        if (ms2.Length > 50 * 1024)
                        {
                            using (var faceBmp = ConvertImageSize(bmp2))
                            {
                                faceBmp.Save(filePath, System.Drawing.Imaging.ImageFormat.Jpeg);
                            }
                        }
                        else
                        {
                            bmp2.Save(filePath, System.Drawing.Imaging.ImageFormat.Jpeg);
                        }
                    }

                }
            }
            catch (Exception ex)
            {
                Log.Error("图片保存错误", ex);
            }
        }
        static Bitmap ConvertImageSize(Bitmap srcimage)
        {
            try
            {
                var scale = 1.0;
                if (srcimage.PixelFormat == System.Drawing.Imaging.PixelFormat.Format24bppRgb)
                {
                    scale = 560 / (1.0 * srcimage.Height);
                }
                else if (srcimage.PixelFormat == System.Drawing.Imaging.PixelFormat.Format32bppRgb)
                {
                    scale = 130 / (1.0 * srcimage.Height);
                }
                else
                {
                    scale = 1;
                }

                if (scale != 1)
                {

                    var b = new Bitmap(srcimage, Convert.ToInt32(srcimage.Width * scale), Convert.ToInt32(srcimage.Height * scale));

                    return b;
                }
                else
                {
                    return srcimage;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }

            return null;
        }
        public static string PhotoPathToBase64(string filepath)
        {
            try
            {
                if (File.Exists(filepath))
                {
                    using (var bmp = new Bitmap(filepath))
                    {
                        using (var ms = new MemoryStream())
                        {
                            bmp.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);
                            byte[] arr = new byte[ms.Length];
                            ms.Position = 0;
                            ms.Read(arr, 0, (int)ms.Length);
                            ms.Close();
                            return Convert.ToBase64String(arr);
                        }
                    }
                    ;
                }


            }
            catch (Exception ex)
            {
                Log.Error("图片保存错误", ex);
                return string.Empty;
            }
            return string.Empty;
        }

        public static string StreamToBase64(Stream stream)
        {

            byte[] arr = new byte[stream.Length];
            stream.Position = 0;
            stream.Read(arr, 0, (int)stream.Length);
            return Convert.ToBase64String(arr);

        }
        public static T CopyValues<T>(object source)
        {
            try
            {

                var json = JsonHelper.Serializer(source);
                var dest = JsonHelper.Deserialize<T>(json);
                //foreach (var propertySource in source.GetType().GetProperties())
                //{
                //    foreach (var propertyDest in dest.GetType().GetProperties())
                //    {
                //        if (propertySource.Name == propertyDest.Name)
                //        {
                //            propertyDest.SetValue(dest, propertySource.GetValue(source));
                //        }
                //    }
                //}

                return dest;
            }
            catch (Exception ex)
            {
                Log.Error("CopyValues", ex);
            }

            return Activator.CreateInstance<T>();
        }

        public static string ConvertNameToID<T>(string namevalues, string name, List<T> list)
        {

            var ids = string.Empty;

            if (namevalues.IsNotNullOrEmpty())
            {
                var names = namevalues.Split(';');
                // var str = "";

                var Nameproperty = typeof(T).GetProperties().FirstOrDefault(m => m.Name.ToLower() == name.ToLower());
                var Idproperty = typeof(T).GetProperties().FirstOrDefault(m => m.Name.ToLower() == "id");
                foreach (var item in names)
                {

                    var obj = list.FirstOrDefault(p => Nameproperty.GetValue(p).ToString() == item);
                    if (obj != null)
                    {
                        ids += Idproperty.GetValue(obj) + ";";
                    }
                }

                ids = ids.Trim(';');
            }



            return ids;
        }

        /// <summary> 
        /// 将c# DateTime时间格式转换为Unix时间戳格式 
        /// </summary> 
        /// <param name="time">时间</param> 
        /// <returns>long</returns> 
        public static long ConvertDateTimeToInt(System.DateTime time)
        {
            System.DateTime startTime = TimeZone.CurrentTimeZone.ToLocalTime(new System.DateTime(1970, 1, 1, 0, 0, 0, 0));
            long t = (time.Ticks - startTime.Ticks) / 10000;   //除10000调整为13位     
            return t;
        }

        public static void SetTimeOut(int time, Action action)
        {
            Task.Run(() =>
            {
                Thread.Sleep(time);
                action();
            });
        }
    }
}

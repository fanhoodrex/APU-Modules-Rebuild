using NLog;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace shoppingbsform.Utils
{
    public class Log
    {
        private static Logger logger = LogManager.GetCurrentClassLogger();

        public static void Info(string message)
        {

            logger.Info(message);
        }

        public static void Error(string message)
        {
            logger.Error(message);
        }

        public static void Error(Exception exception)
        {
            logger.Error(exception);
        }

        public static void Error(string message, Exception exception)
        {
            logger.Error(message);
            logger.Error(exception);
        }

        public static void Debug(string message)
        {
            logger.Debug(message);
        }

        public static void Warn(string message)
        {
            logger.Warn(message);
        }

        public static void Debug(object message)
        {
            logger.Debug(message);
        }

    }
}

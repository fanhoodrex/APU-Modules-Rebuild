using shoppingbsform.DAL;
using shoppingbsform.Model;
using shoppingbsform.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace shoppingbsform.ViewModels
{
    public class FeedBackViewModel
    {
        public static FeedBackViewModel Instance = new FeedBackViewModel();
        private FeedBackDal dal = new FeedBackDal();

        public bool AddUserFeedBack(string userid,string feedtitle,string feedcontent)
        {
            try
            {
                var feedback = new Feedback()
                {
                    Id = Tool.GetNewGuid(),
                    Userid = userid,
                    Title = feedtitle,
                    Content = feedcontent,
                    State = FeedBackState.UnReplay
                };

                return dal.Insert(feedback);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }
        public bool ReplayFeedBack(string id, string replay)
        {
            try
            {
                var feedback = dal.FindByID(id);
                feedback.Reply = replay;
                feedback.State = FeedBackState.Replaied;
                return dal.Update(feedback);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }

        public bool ConfirmFeedback(string id)
        {
            try
            {
                var feedback = dal.FindByID(id);
                feedback.State = FeedBackState.UserConfirm;
                return dal.Update(feedback);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return false;
        }

        public Feedback GetReplaiedFeedBack(string userid)
        {
            try
            {
                return dal.FindFeedback(userid,FeedBackState.Replaied);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return null;
        }

        public Feedback GetUnReplayFeedback()
        {
            try
            {
                return dal.FindFeedback(string.Empty, FeedBackState.UnReplay);
            }
            catch (Exception ex)
            {
                Log.Error(ex);
            }

            return null;
        }
    }
}
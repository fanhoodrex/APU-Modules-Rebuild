function val (){
if (frm.email.value =="")
{
  alert("please enter the email");
  frm.email.focus();
  return false;
  }
  var reg = /^([A-Za-z0-9_\-\.]) + \@([A-Za-z0-9_\-\.])+\.([A-Za-z] {2,4})$/;
  if (reg.test(frm.email.value) ==false)
  {
   alert('Invalid email address');
   frm.email.focus();
   return false;
  }
  return true;

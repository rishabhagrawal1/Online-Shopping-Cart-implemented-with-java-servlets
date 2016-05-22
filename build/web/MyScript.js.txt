function validate(form)
{
var a=form.card_no.value;
var b=form.pin_no.value;
var str=/^[0-9]+$/;

 if(a.length<1)
{
 alert("Please enter card no.");
return false;
} 
 else if(a.length!=16)
{
alert("Please Enter valid card no.");
return false;
}
else if(!(str.test(a)))
{
alert("invalid card no.");
return false;
}
else if(b.length<1){
alert("Please enter Pin no.");
return false;
}
else if(b.length!=4)
{
alert("Please enter valid Pin no.");
return false;
}
else
{
return true;
}

}
function validate(form)
        {
        var a=form.name.value;
        var b=form.password.value;
        if(a.length<1)
        {
        alert("must provide user name");
        return false;
        }
       else if(b.length<1)
        {
        alert("must provide password");
        return false;
        }
        else
        {
        return true;
        }
        
        }
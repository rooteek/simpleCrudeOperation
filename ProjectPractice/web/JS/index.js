function ajaxCall(method, url, data, destination, isHtml) {
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (isHtml) {
                document.getElementById(destination).innerHTML = this.responseText;
            } else {
                document.getElementById(destination).value = this.responseText;
            }
        }
    };
    xhttp.open(method, url, false);
    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
    xhttp.send(data);
}


function checkValidation(){
    name=document.getElementById("username").value
    password=document.getElementById("password").value
    ajaxCall("POST","logintController","username="+name+"&password="+password,"ajax",true)
    status=document.getElementById("ajax").innerHTML;
    if(status=='1'){
        alert("Login Successfull....");
        window.location.href="dashboard.jsp"
    }
    else{
        alert("Invalid Password or id");
}
return false;
}
function LogoutUser(){
    logout=confirm("Are you sure do you really want to logout!")
    if(logout){
        window.location.href="logoutController";
    }
}

function processData(process) {
//    alert(process)
    ajaxCall("POST", "processData", "process="+process, "ajax", true);
}
function insertData(){
    name=document.getElementById("uname").value
    email=document.getElementById("emailId").value
    password=document.getElementById("pass").value
    mobile=document.getElementById("phone").value
    add=document.getElementById("add").value
    ajaxCall("POST","processData","process=insData&name="+name+"&email="+email+"&password="+password+"&mobile="+mobile+"&address="+add,"inserData",true)
    let status=document.getElementById("inserData").innerHTML
    if(status=='1'){
        alert("Data Insert Successfully");
        processData("insert")
    }
}
function deleteData(element){
    let id=element.getAttribute("Did");
    alert(id);
    ajaxCall("POST","processData","process=dele&element="+id,"dell",true)
    let status=document.getElementById("dell").innerHTML
    if(status=='1'){
        alert("Data Delete Successfully....")
        processData('delete')
    }
}


 function getaData(updata){
     let id=updata.getAttribute("uid");
//     alert(id);
     ajaxCall("POST","processData","process=getData&id="+id,"",true);
 }

function editData(){
    id=document.getElementById("uid").value;
    name=document.getElementById("uname").value
    email=document.getElementById("emailId").value
    password=document.getElementById("pass").value
    mobile=document.getElementById("phone").value
    add=document.getElementById("add").value
    ajaxCall("POST","processData","process=updataData&name="+name+"&email="+email+"&password="+password+"&mobile="+mobile+"&address="+add+"&id="+id,"updateDa",true)
    let status=document.getElementById("updateDa").innerHTML
    if(status>='1'){
        alert("Data Update Successfully");
        processData("view")
    }
}
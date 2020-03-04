
    $(".menu").on('click',function () {
        const s = $(this).next();
        s.slideToggle(500);
    });


function GetSelected() {
    //Create an Array.
    var selected = [];
    //Reference the Table.
    const tblAccounts = document.getElementById("tbl-accounts");
    //Reference all the CheckBoxes in Table.
    const chks = tblAccounts.getElementsByTagName("INPUT");
    // Loop and push the checked CheckBox value in Array.
    for (let i = 0; i < chks.length; i++) {
        if (chks[i].checked) {
            selected.push(chks[i].value);
        }
    }
    active(selected);
}

function active(selected) {

    $.ajax({
        type: "POST",
        url : "http://localhost:8080/activeAllSelected",
        data : {
            myselected : selected
        },
        success: function(data){
            alert(data)
        }


    });
}

function loadPage(page) {
    
    $.ajax({
        type: "GET",
        url: page,
        success: function(response) {
            $("#app-content-load").html( response );
        }
    });
}
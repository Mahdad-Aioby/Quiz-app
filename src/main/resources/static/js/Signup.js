function signup() {
    const username = $("#username").val();
    const password = $("#password").val();
    const email = $("#email").val();
    const firstname = $("#firstname").val();
    const lastname = $("#lastname").val();
    const type = $('input[name="type"]:checked').val();

    const url = 'http://localhost:8080/Signupme?username= ' + username + '&password=' + password + '&type=' + type;

    const http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {

        }
    };

    http.open('GET', url, true);
    http.send();

}

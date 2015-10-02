$(document).ready(function() {
    
    var persons = []
    var baseUrl = 'http://localhost:8080/REST_JAX_RS_Person/api/persons/'
    
    getPersons(appendPersons)
    
    function getPersons(callback) {
        $.getJSON(baseUrl, function(res) {
            countries = res
            callback(countries)
            console.log(res)
        })
    }
    
    function appendPersons(list) {
        list.forEach(function(elm) {
            $("#persons").append("<tr><td>" + elm.fName + " " + elm.lName + "</td><td>" + elm.phone + "</td><td><a href='#' class='btn btn-danger btn-xs' data-personid='" + elm.id + "'>delete</a></td></tr>")
        }) 
    }
   
})
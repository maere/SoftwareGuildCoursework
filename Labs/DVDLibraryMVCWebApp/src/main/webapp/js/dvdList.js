/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    loadDvds();

    // add method, on click
    $('#add-button').on('click', function (e) {

        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'dvd',
            data: JSON.stringify({
                //the properties on the left MUST match the properties in the DTO verbatim 
                title: $('#add-title').val(), //this is simply a list of parameters with accessors
                releaseDate: $('#add-releaseDate').val(),
                mpaaRating: $('#add-rating').val(),
                director: $('#add-director').val(),
                studio: $('#add-studio').val(),
                note: $('#add-note').val()

            }),
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
                    //end ajax

        }).success(function (data, status) {

            $('#add-title').val(''); //note that these are executable statements calling a method and require a semicolon
            $('#add-releaseDate').val('');
            $('#add-rating').val('');
            $('#add-director').val('');
            $('#add-studio').val('');
            $('#add-note').val('');

            //clear out any validation error messages and empty (not yet added)
            $('#validationErrors').empty();
        
            loadDvds();
            //do .error method fo validation           

        }) //end success & start .error validation
                .error(function(data, status){
                    
                    var errors = data.responseJSON.fieldErrors;
                    
                    $.each(errors, function(index, validationError){
                        //this is how we find the div we added, we also clear on each pass
                        var errorDiv = $('#validationErrors'); 
                        errorDiv.append(validationError.message).append('<br>');
                        
                    });
                    
                });//end error

    }); //end on click




}); //end on document ready on page load


//getting and displaying objects

function fillDvdTable(dvdList, status) {

    //call method that clears previous data--need to write
    clearDvdTable();

    var dvdTable = $('#contentRows'); // this gets the table element
                                        //ANGULAR has a very structure way for building the HTML from the data 
                                        //instead of the messy approach below
    $.each(dvdList, function (index, dvd) {
        dvdTable.append($('<tr>'))
                .append($('<td>')
                        .append($('<a>')
                                .attr({ //data- is a very special tag taht the browser let's hang around jQuery will parse data- by grabing the second half
                                    'data-dvd-id': dvd.id,
                                    'data-toggle': 'modal',//this is bootstrap convention--turns it on
                                    'data-target': '#detailsModal' //botstrap convention
                                })
                                .text(dvd.title)))

                .append($('<td>').text(dvd.director))

                .append($('<td>').append(
                        $('<a>')
                        .attr({
                            'data-dvd-id': dvd.id,
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')
                        ))

                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDvd(' + dvd.id + ')' //calling our own JS function we buillt in this same page
                                })
                                .text('Delete')
                                )
                        );
    });
}

function loadDvds() {

    $.ajax({
        url: "dvds"
        //default is always GET
    }).success(function (data, status) {

        fillDvdTable(data, status);
    }); //end ajax

} //end method


function clearDvdTable() {
    $('#contentRows').empty();

}


//  //our delete functoin
function deleteDvd(id) {

    var answer = confirm("Do you really want to delete this DVD?");
    //we're relying on browser for this, but we could also do as a model (and confim details)
    if (answer === true) //=== is testing both TYPE and value
    {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {

            loadDvds();
        });
    } //end if
}

//details modal event handler
$('#detailsModal').on('show.bs.modal', function (event) { //when the show modal event happens...

    var element = $(event.relatedTarget); //value of this is our link that led here -- the target was the a link
    var id = element.data('dvd-id'); //check contact code for line up: this will need to read "data-dvd-id" in our HTML!
    var modal = $(this); //this is currently #detailsModal object

    $.ajax({
        type: 'GET',
        url: 'dvd/' + id //we construct this on the fly
    })
            .success(function (dvd) {
                modal.find('#dvd-id').text(dvd.id); 
                modal.find('#dvd-title').text(dvd.title);
                modal.find('#dvd-releaseDate').text(dvd.releaseDate);
                modal.find('#dvd-rating').text(dvd.mpaaRating);
                modal.find('#dvd-director').text(dvd.director);
                modal.find('#dvd-studio').text(dvd.studio);
                modal.find('#dvd-note').text(dvd.note);
            }); //end success function

});//end onclick

//edit modal event handler
$('#editModal').on('show.bs.modal', function (event) {
    
    var element = $(event.relatedTarget); //the value of this element is the <a link> we clicked on that triggered the event

    var id = element.data('dvd-id'); //this says go to the data-name-attribute, and pull the second half of the data- (data-dash)

    var modal = $(this); //the "this" is the handler event (e.g. #editModal)

    $.ajax({
        type: 'GET',
        url: 'dvd/' + id //I hada faulty request here...wasn't getting to my route bc the the slash was outside the parenthesis
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.id);//heck this value in contacts-not clear about where itshows up
        
        modal.find("#edit-dvd-id").val(dvd.id);
        modal.find("#edit-title").val(dvd.title);
        modal.find("#edit-releaseDate").val(dvd.releaseDate);
        modal.find("#edit-rating").val(dvd.mpaaRating);
        modal.find("#edit-director").val(dvd.director);
        modal.find("#edit-studio").val(dvd.studio);
        modal.find("#edit-note").val(dvd.note);
        //convention for HTML/CSS attributes is dash-dash, and anything that's handled in JS, JSON, and sent back to endpoints is lowerCamelCase
    });

});

//edit button
$('#edit-button').click(function (event) {
    event.preventDefault();

    $.ajax({
        type: 'PUT', //because this is getting put back to the model, when we serialize we *must* match Java values
        url: 'dvd/' + $('#edit-dvd-id').val(), //this takes the value of edit-dvd-id attribute and passes as the URL
        data: JSON.stringify({ //the above id is from the button edit
            id: $('#edit-id').val(), //this method takes the values of the #attribute and pairs it with the property in our Java DTO object
            title: $('#edit-title').val(),
            releaseDate: $('#edit-releaseDate').val(),
            mpaaRating: $('#edit-rating').val(),
            director: $('#edit-director').val(),
            studio: $('#edit-studio').val(),
            note: $('#edit-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    })

            .success(function () {
                loadDvds();
            });

});//end edit button handler

//search button event handler--th haven't written the search part yet

$('#search-button').click(function (event) {

    event.preventDefault();

    $.ajax({
        type: 'POST',
        url: 'search/dvds',
        data: JSON.stringify({
            title: $('#search-title').val(),
            releaseDate: $('#search-releaseDate').val(),
            mpaaRating: $('#search-rating').val(),
            director: $('#search-director').val(),
            studio: $('#search-studio').val(),
            note: $('#search-note').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    })

            .success(function (data, status) {//if it succeeds, empty the attribute value in the DOM elements
                $('#search-title').val('');
                $('#search-releaseDate').val('');
                $('#search-rating').val('');
                $('#search-director').val('');
                $('#search-studio').val('');
                $('#search-note').val('');
                
                fillDvdTable(data, status);
            });

});
















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

            loadDvds();
            //do .error method fo validation           

        }); //end success

        //errors validation goes after success

    }); //end on click




}); //end on document ready on page load


//getting and displaying objects

function fillDvdTable(dvdList, status) {

    //call method that clears previous data--need to write
    clearDvdTable();

    var dvdTable = $('#contentRows'); // this gets the table element

    $.each(dvdList, function (index, dvd) {
        dvdTable.append($('<tr>'))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-id': dvd.id,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(dvd.title)))

                .append($('<td>').text(dvd.director))

                .append($('<td>').append(
                        $('<a>')
                        .attr({
                            'data-id': dvd.id,
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')
                        ))

                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDvd(' + dvd.id + ')'
                                })
                                .text('Delete')
                                )
                        );
    });
}

function loadDvds() {

    $.ajax({
        url: "dvds"
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
$('#detailsModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);
    var id = element.data('dvd-id'); //check contact code for line up
    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'dvd/' + id
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
    var element = $(event.relatedTarget);

    var id = element.data('dvd-id');

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'dvd' / +id
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.id);//heck this value in contacts-not clear about where itshows up
        modal.find("#edit-dvd-id").val(dvd.id);
        modal.find("#edit-title").val(dvd.title);
        modal.find("#edit-releaseDate").val(dvd.releaseDate);
        modal.find("#edit-rating").val(dvd.mpaaRating);
        modal.find("#edit-director").val(dvd.director);
        modal.find("#edit-studio").val(dvd.studio);
        modal.find("#edit-note-id").val(dvd.note);

    });

});

//edit button
$('#edit-button').click(function (event) {
    event.preventDefault();

    $.ajax({
        type: 'PUT',
        url: 'contact/' + $('#edit-dvd-id').val(), //this takes the value of edit-dvd-id attribute and passes as the URL
        data: JSON.stringify({
            id: $('#edit-dvd-id').val(), //this method takes the values of the #attribute and pairs it with the property in our Java DTO object
            title: $('#edit-dvd-title').val(),
            releaseDate: $('#edit-dvd-releaseDate').val(),
            mpaaRating: $('#edit-dvd-rating').val(),
            director: $('#edit-dvd-director').val(),
            studio: $('#edit-dvd-studio').val(),
            note: $('#edit-dvd-note').val(),
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
        url: 'search/contacts',
        data: JSON.stringify({
            title: $('#search-title').val(),
            releaseDate: $('#search-releaseDate').val(),
            mpaaRating: $('#search-rating').val(),
            director: $('#search-director').val(),
            studio: $('#search-studio').val(),
            note: $('#search-notee').val()
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
















/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    loadDvds();

    // add method, on click
    $('#add-button').on('click', function(e) {

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

        }).success(function(data, status) {

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

    $.each(dvdList, function(index, dvd) {
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
    }).success(function(data, status) {

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
        }).success(function() {

            loadDvds();
        });
    } //end if
}
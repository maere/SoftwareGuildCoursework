/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    loadContacts(); //will call this when the doc loads

    //we are going to set up an eventlistener on our add button
    $('#add-button').on('click', function (e) {
        //since the add button lives inside a form, and the default functionality of the button is to submit the form and refresh the page...but we want to stoip that from happening
        e.preventDefault();
        //and make an AJAX call instead
        $.ajax({//there are three incoming paramaters...
            type: 'POST',
            url: 'contact',
            data: JSON.stringify({//JS object, will take taht and turn it into JSON   (outgoing?)
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            //these are our HTTP headers to tell server ew are sending JSON - ajax takes this paramater as well, for the server
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            //also have to tell jQuerty we are sending JSON
            dataType: 'json'

                    //jquery allows us to chain things, and we are going chain some methods to json pboject, a function that takes params 
        }).success(function (data, status) { //this is what happens if it's successful

            //if call succeecs, we are going to clear evertying
                    $('#add-first-name').val('');
                    $('#add-last-name').val('');
                    $('#add-company').val('');
                    $('#add-email').val('');
                    $('#add-phone').val('');
                    loadContacts(); //after we've cleared we'll add contacts again

        });
    });
});

function loadContacts() {

    clearContactTable();
    //will grab the table we have in our page so we can reference it throughout our code
    var cTable = $('#contentRows'); //cTable will only be available inside this method
    
   //will create a very similar AJAX function to the one we just made above in the display 
   $.ajax({
       url: "contacts" 
   }).success(function(data, status){ //this is the data passed back from the server...
       
           //and now we'll pass that data to the the each function (not our prevoius test data called "testContactData" from below)
    $.each(data, function (index, contact) //each takes these two params, a collection and a function, 
            //the function we are passing takes two params -- an index and a contact object (we declare this)
            {
                cTable.append($("<tr>")
                        .append($('<td>').append($('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text(contact.firstName + " " + contact.lastName)))
                        .append($('<td>').text(contact.company))
                        .append($('<td>').append(
                                $('<a>')
                                .attr({
                                    'data-contact-id': contact.contactId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')
                                ))
                        .append($('<td>').text('Delete')));
                //this function will add table rows and content to our body - similar to our for/each with JSTL, but on client side vs. serverside
            }
    );
       
   });
    
    //we use jQuerty's each method to append our contact infor to the table

}//end loadContacts function



function clearContactTable()
{                       //contentRows is the id we gave the content to grab it
    $("#contentRows").empty(); //we don't use the variable in the above function bc it would be out of scope
    //better to just pass it in for this function  
}

//now that we've added modal dialog into HTML, we'll add something to our JS
//piece of jQuerty--is NOT a js function

$('#detailsModa').on("show.bs.modal", function (event) { //when an element with this tag is clicked on, the modal will show and the following will happen

    var element = $(event.relatedTarget); //this doesn't necessarily come up with the dot

    var contactId = element.data('contact-id'); //we'll have the data from the wiring on our table

    var modal = $(this); //this now refers to the modal dialog object
    modal.find('#contact-id').text(dummyDetailsContact.contactId); //so nnfor only THIS object, we want to look through and find
    //           // our contact-ids, with the following text....NOT looking through the entire DOM
    //could also have said $(this.find)--but we're are being explicit here for instructional purposes
    //find will return you a list of elements -- modal var will hold the return of this array
    modal.find('#contact-first-name').text(dummyDetailsContact.firstName);
    modal.find('#contact-last-name').text(dummyDetailsContact.lastName);
    modal.find('#contact-company').text(dummyDetailsContact.company);
    modal.find('#contact-phone').text(dummyDetailsContact.phone);
    modal.find('#contact-email').text(dummyDetailsContact.email);
});
//use the selector for editModal
$('#editModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);
    modal.find('#edit-id').text(dummyEditContact.contactId);
    modal.find('#edit-first-name').val(dummyEditContact.firstName);
    modal.find('#edit-last-name').val(dummyEditContact.lastName);
    modal.find('#edit-company').val(dummyEditContact.lastName);
    modal.find('#edit-phone').val(dummyEditContact.phone);
    modal.find('#edit-email').val(dummyEditContact.email);
});
//TEST DATA BELOW


////this is our struts bucket
////this is how we make a collection in JS, this is a JS object, is an object that is within the memory in the browser
////vs. JSON which is a serialized thing...if you parsed a JSON object would get this data strcutre as a result
//var testContactData = [
//    {
//        contactId: 1,
//        firstName: "Susan",
//        lastName: "Williams",
//        company: "IBM",
//        email: "swilliamms@ibm.com",
//        phone: "555-1212"
//    },
//    {
//        contactId: 2,
//        firstName: "George",
//        lastName: "Smith",
//        company: "EMC",
//        email: "smith@emc.com",
//        phone: "555-1234"
//    },
//    {
//        contactId: 3,
//        firstName: "Chuck",
//        lastName: "Knoble",
//        company: "3M",
//        email: "chuck@3m.com",
//        phone: "555-5656"
//    }
//
//];
////global variable
//var dummyDetailsContact =
//        {
//            contactId: 42,
//            firstName: "Kent",
//            lastName: "Hrbek",
//            company: "3M",
//            email: "kent@ibm.com",
//            phone: "444-6789"
//
//        };
////global variable
//var dummyEditContact =
//        {
//            contactId: 52,
//            firstName: "Kirby",
//            lastName: "Puckett",
//            company: "Sun",
//            email: "kirby@sun.com",
//            phone: "123-5599"
//
//        };

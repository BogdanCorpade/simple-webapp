/**
 * Created by bcorpade on 4/30/2014.
 */
$(document).ready(function() {
    var oTable = $('#myTable').dataTable( {
        "bProcessing": true,
        "sAjaxSource": "/language/findAll",
        "aoColumns": [
            { "mData": "engine" },
            { "mData": "browser" },
            { "mData": "platform" },
            { "mData": "version" },
            { "mData": "grade" }
        ]
    } );
} );

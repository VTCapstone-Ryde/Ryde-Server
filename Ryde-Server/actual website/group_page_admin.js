
var data_members = [
    {
        "Name": "Mark",
        "Status": "Admin",
        "Last Drove": "April 3rd",
        "Actions": "Demote"
    },
    {
        "Name": "Mary",
        "Status": "Admin",
        "Last Drove": "April 1st",
        "Actions": "Demote"
    },
    {
        "Name": "Alex",
        "Status": "Regular User",
        "Last Drove": "April 2nd",
        "Actions": "Promote  Remove"
    },
    {
        "Name": "Bob",
        "Status": "Regular User",
        "Last Drove": "April 1st",
        "Actions": "Promote  Remove"
    },
    {
        "Name": "David",
        "Status": "Regular User",
        "Last Drove": "April 2nd",
        "Actions": "Promote  Remove"
    },
    {
        "Name": "Jeff",
        "Status": "Regular User",
        "Last Drove": "N/A",
        "Actions": "Promote  Remove"
    }
];

$(function () {
    $('#members').bootstrapTable({
        data: data_members
    });
});

var data_members = [
    {
        "Name": "Mary",
        "Status": "Admin",
        "Last Drove": "April 3rd"
    },
    {
        "Name": "Mark",
        "Status": "Admin",
        "Last Drove": "April 1st"
    },
    {
        "Name": "Alex",
        "Status": "Regular User",
        "Last Drove": "April 2nd"
    },
    {
        "Name": "Bob",
        "Status": "Regular User",
        "Last Drove": "April 1st"
    },
    {
        "Name": "David",
        "Status": "Regular User",
        "Last Drove": "April 2nd"
    },
    {
        "Name": "Jeff",
        "Status": "Regular User",
        "Last Drove": "N/A"
    }
];

$(function () {
    $('#members').bootstrapTable({
        data: data_members
    });
});
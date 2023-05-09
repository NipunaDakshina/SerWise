const nav = document.querySelector('.navigation');

const innerText = "<img src=\"/SerWise_war/Assets/SerWise.png\" class=\"navimg\">\n" +
    "<table>\n" +
    "    <tr>\n" +
    "        <td><a href=\"/SerWise_war/BranchManager/Home/home.jsp\" class=\"nava\">Home</a></td>\n" +
    "        <td><a href=\"/SerWise_war/ServletlistAppoinment\">Appoinment</a></td>\n" +
    "        <td><a href=\"/SerWise_war/ServletlistallJobs\">Jobs</a></td>\n" +
    "        <td><a href=\"/SerWise_war/BranchManager/Report/viewReport.jsp\">Report</a></td>\n" +
    "        <td><a href=\"/SerWise_war/ServletlistInventoryList\">Inventory</a></td>\n" +
    "        <td><a href=\"/SerWise_war//ServletemployeeList\">Employee</a></td>\n" +
    "        <td><a href='/SerWise_war//ServletLogout'><button class=\"button\">Logout</button></a></td>\n" +
    "        <td><a href=\"#\"><img src=\"/SerWise_war/Assets/ProfilePic.jpg\" class=\"profile\"></a></td>\n" +
    "    </tr>\n" +
    "</table>";

nav.innerHTML=innerText;
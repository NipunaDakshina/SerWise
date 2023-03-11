<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/content.css">
    <link rel="stylesheet" href="../../CSS/navigation.css">
    <link rel="stylesheet" href="../../CSS/footer.css">
    <link rel="stylesheet" href="../../CSS/background.css">
    <title>Document</title>
</head>
<body>
    <header class="navigation">
        <img src="../../Assets/SerWise.png" class="navimg">
    </header>

    <div class="single-content-div title">
        <div>
            <span class="title">SerWise Branch - B001</span><br>
            <span class="subtitle">December 2022</span>
        </div>
    </div>

    <div class="single-content-div center title">
        select the month :
        <form action="/SerWise_war/ReportController">

            <select name="months">
                <option value="">Select a month</option>
                <option value="01">January</option>
                <option value="02">February</option>
                <option value="03">March</option>
                <option value="04">April</option>
                <option value="05">May</option>
                <option value="06">June</option>
                <option value="07">July</option>
                <option value="08">August</option>
                <option value="09">September</option>
                <option value="10">October</option>
                <option value="11">November</option>
                <option value="12">December</option>
            </select>

            select the year :

            <label for="year-select">Select a year:</label>
            <select id="year-select" name="year">
                <option value="">Select a year</option>
                <!-- Generate options with a loop -->
                <script>
                    var yearSelect = document.getElementById("year-select");
                    for (var year = 2020; year <= 2025; year++) {
                        var option = document.createElement("option");
                        option.value = year;
                        option.text = year;
                        yearSelect.add(option);
                    }
                </script>
            </select>

            <input type="submit" value="Search" class="button">
        </form>
    </div>

    <div class="report-table glass">
        <table>
            <tr>
                <td>
                    <span class="subtitle">Appointments Done</span><br>
                    <span class="title">95</span>
                </td>
                <td>
                    <span class="subtitle">Total Profit</span><br>
                    <span class="title">Rs.820,000.00</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span class="subtitle">Total Income</span><br>
                    <span class="title">Rs.1,200,000.00</span>
                </td>
                <td>
                    <span class="subtitle">Rank by Profit</span><br>
                    <span class="title">5<sup>th</sup></span>
                </td>
            </tr>
        </table>
    </div>

    <footer class="footer">
        <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
        <div class="center"><a href="#"> Contact Us </a> &nbsp| 
            &nbsp<a href="#"> About Us </a> &nbsp|
            &nbsp <a href="#"> Legal Stuff </a></div>
        <div class="center">All Rights Recieved</div>
    </footer>
</body>
</html>
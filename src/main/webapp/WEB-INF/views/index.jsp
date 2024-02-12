<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JPA</title>
    </head>

    <body>

        <form>
            <select name="country" id="country" onchange="changeFunction()">

            </select>
            <select name="state" id="state" onchange="changeFunctionState()">

            </select>
            <select name="city" id="city">

            </select>
        </form>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

        <script>
            window.onload = function onLoadfunction() {

                var countrySel = document.getElementById('country')

                $.ajax({
                    type: 'GET',
                    url: 'http://localhost:8080/api/country',
                    success: function (response) {
                        response.data.forEach(element => {
                            console.log(element.countryName);
                            var newOption = $('<option>');
                            newOption.attr('value', element.countryName).text(element.countryName);
                            newOption.attr('id', element.id)
                            $('#country').append(newOption)
                        });
                    }
                })

            }

            function updateCountry(countryId) {
                console.log(countryId);
            }

            function changeFunction() {
                var selectBox = document.getElementById('country');
                var selectedValue = selectBox.options[selectBox.selectedIndex].id;
                $.ajax({
                    type: 'GET',
                    url: 'http://localhost:8080/api/country/' + selectedValue + "/state",
                    success: function (response) {
                        console.log(response.data);
                        var stateSel = document.getElementById('state')
                        while (stateSel.firstChild) stateSel.removeChild(stateSel.firstChild);

                        var citySel = document.getElementById('city')
                        while (citySel.firstChild) citySel.removeChild(citySel.firstChild);

                        response.data.forEach(element => {
                            var newOption = $('<option>');
                            newOption.attr('value', element.stateName).text(element.stateName);
                            newOption.attr('id', element.id)
                            $('#state').append(newOption)
                        });

                    }
                })
            }

            function changeFunctionState() {
                var selectBox = document.getElementById('country');
                var selectedCountry = selectBox.options[selectBox.selectedIndex].id;

                var selectBox = document.getElementById('state');
                var selectedState = selectBox.options[selectBox.selectedIndex].id;
                $.ajax({
                    type: 'GET',
                    // http://localhost:8080/api/country/5/state/2/city
                    url: 'http://localhost:8080/api/country/' + selectedCountry + "/state/" + selectedState + "/city",
                    success: function (response) {
                        console.log(response.data);
                        var citySel = document.getElementById('city')
                        while (citySel.firstChild) citySel.removeChild(citySel.firstChild);

                        response.data.forEach(element => {
                            var newOption = $('<option>');
                            newOption.attr('value', element.cityName).text(element.cityName);
                            newOption.attr('id', element.id)
                            $('#city').append(newOption)
                        });

                    }
                })
            }

        </script>

    </body>

    </html>
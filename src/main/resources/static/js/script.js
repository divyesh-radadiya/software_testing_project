function clearScreen() {
 document.getElementById("result").value = "";
}

function clearScreen2() {
 document.getElementById("result2").value = "";
}

function display(value) {
 document.getElementById("result").value += value;
}

function display2(value) {
 document.getElementById("result2").value += value;
}


// var base="http://localhost:8081";
var base="http://172.16.134.139:8081";

function calculatePower() {
    const p = document.getElementById("result").value;
    const b = document.getElementById("result2").value;

    fetch(base+'/getPower', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            input1:p.toString(),
            input2:b.toString()
        })
    }).then(response => response.json())
        .then((data) => {
            document.getElementById("finalresult").value = data;
        });
}
function calculateRoot() {
    const p = document.getElementById("result").value;
    fetch(base+'/getSqrt', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            input1:p.toString(),

        })
    }).then(response => response.json())
        .then((data) => {

            document.getElementById("result").value = data;
        });
 // document.getElementById("result").value = q;
}

function calculateLog() {

    const p = document.getElementById("result").value;
    fetch(base+'/getLog', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            input1:p.toString(),
        })
    }).then(response => response.json())
        .then((data) => {

            document.getElementById("result").value = data;
        });
}

function calculateFact() {
    const p = document.getElementById("result").value;

    fetch(base+'/getFact', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            input1:p.toString(),
        })
    }).then(response => response.json())
        .then((data) => {
            document.getElementById("result").value = data;
        });


}


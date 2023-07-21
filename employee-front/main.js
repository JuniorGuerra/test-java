// Lógica para realizar la búsqueda de un empleado por ID
function searchEmployee() {
    const employeeId = document.getElementById("employeeId").value;
    if (employeeId === "") {
        getAllEmployees();
    } else {
        getEmployeeById(employeeId);
    }
}

// Función para obtener todos los empleados
function getAllEmployees() {
    console.log("Fetching all employees...");
    fetch("http://127.0.0.1:8080/api/v1/employee")
        .then(response => response.json())
        .then(data => displayEmployees(data.data))
        .catch(error => showError());
}

function showError() {
    var errorMessage = document.getElementById("error-message");
    errorMessage.style.display = "block";
}

// Función para obtener un empleado por ID
function getEmployeeById(employeeId) {
    fetch(`http://127.0.0.1:8080/api/v1/employee/${employeeId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Employee not found.");
            }
            return response.json();
        })
        .then(data => displayEmployees([data.data]))
        .catch(error => showError());
}

// Función para mostrar la lista de empleados en la página
function displayEmployees(employees) {
    const employeesList = document.getElementById("employeesList");
    employeesList.innerHTML = "";

    if (employees.length === 0) {
        employeesList.innerHTML = "<p>No employees found.</p>";
    } else {
        const table = document.createElement("table");
        table.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Age</th>
                <th>Profile Image</th>
                <th>Annual Salary</th>
            </tr>
        `;

        employees.forEach(employee => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${employee.id}</td>
                <td>${employee.employee_name}</td>
                <td>${employee.employee_salary}</td>
                <td>${employee.employee_age}</td>
                <td>${employee.profile_image}</td>
                <td>${calculateAnnualSalary(employee.employee_salary)}</td>
            `;
            table.appendChild(row);
        });

        employeesList.appendChild(table);
    }
}

// Función para calcular el salario anual
function calculateAnnualSalary(monthlySalary) {
    return monthlySalary * 12;
}

// Obtener todos los empleados al cargar la página
getAllEmployees();

const currentUserPanelData = document.getElementById("current_user_panel-data");
const currentAuthorisedUserData = document.getElementById("current_authorised_user-data");

let currentUser = () => {
    fetch ("http://localhost:8080/api/user", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(user => {
            if (user != null) {
                currentUserPanelData.innerHTML = ` 
                                <tr>
                                    <td> ${user.id} </td>
                                    <td> ${user.name} </td>    
                                    <td> ${user.secondName} </td>
                                    <td> ${user.username} </td>
                                    <td> ${user.roles.map((role) => role.roleName === "ROLE_USER" ? "USER" : "ADMIN")} </td>
                                </tr>
                        `
                currentAuthorisedUserData.innerHTML = `
                    <p class="d-inline font-weight-bold">${user.username} with roles ${user.roles.map((role) => role.roleName === "ROLE_USER" ? "USER" : "ADMIN")}</p>`
            }
        })
}
currentUser();
<h1 align="center">:balloon: How to use the API :balloon:</h1>
<h3 align="left">:arrow_down: JSON examples :arrow_down:</h3>
<h4>User</h4>
<p>
{
    "name": "John",
    "birthDate": "dd/MM/yyyy"
}
</p>
<hr>
<h4>Address</h4>
<p>
{
    "street": "Av. Brasil",
    "cep": "15645842",
    "number": "515b",
    "city": "São Paulo",
    "main": true
}
</p>
<hr>



<h3 align="left">:arrow_down: Endpoints :arrow_down:</h3>

<h4 align="left">POST -> HOST/users</h4>
<p align="left">Insert new User</p>

<h4 align="left">PUT -> HOST/users/{id}</h4>
<p align="left">Edit some User</p>

<h4 align="left">GET -> HOST/users/{id}</h4>
<p align="left">Get some User</p>

<h4 align="left">GET -> HOST/users</h4>
<p align="left">Get all Users</p>

<h4 align="left">POST -> HOST/users/{id}/address</h4>
<p align="left">Insert new Address for a User</p>

<h4 align="left">GET -> HOST/users/{id}/address</h4>
<p align="left">Get all User Addresses</p>

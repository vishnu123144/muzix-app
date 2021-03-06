import React, { useState, useEffect } from 'react';
import './EditProfile.css'
import { Link } from 'react-router-dom';


export default function EditProfile() {
    let uname;
    let uemail;
    let epass;

    const [username, setUsername] = useState(uname);
    const [email, setEmail] = useState(uemail);
    const [password, setPassword] = useState(epass);
    // const [newPassword, setnewPassword] = useState('');
    // const [confirmPassword, setconfirmPassword] = useState('');


    useEffect(() => {
        fetch(`http://localhost:8084/user-service/api/v1/${email}`)
            .then(res => res.json())
            .then(data => {
                uname = setUsername(data.username)
                uemail = setEmail(data.email)
                epass = setPassword(data.password)
            });
    }, [])

    // function checkingPasswords()
    // {
    //     if()
    // }
    function EditContact() {
        fetch(`http://localhost:8088/user-service/api/v1/${email}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, email, password })
        }).then(res => {
            if (res.status == 200) {
                alert("Edited Succesfully")
            } else {
                alert("USER NOT FOUND")
            }
        });
    }
    return (
        <div>
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-dark text-danger">
                    <span className="span"><h2 className="fas fa-headphones-alt"></h2></span>
                    <div className="container-fluid">
                        <h3><Link to="/dashboard" style={{ textDecoration: 'none' }}>EndlessMusic</Link></h3>

                        {/* <ul className="navbar-nav ml-auto offset-md-8">
                            <li className="nav-item">
                                <button className=" btn btn-outline-info">
                                    <Link to="/dashboard" className="nav-link text-white">DashBoard</Link></button>
                            </li>
                        </ul> */}
                        <h4 className="nav-item">
                            <button className=" btn btn-outline-info">
                                <Link to="/" className="nav-link text-white">HOME</Link></button>
                        </h4>
                    </div>
                </nav>
            </div>

            <div className="container">
                <div className="row">
                    <div className="col-md-4 offset-md-4">
                        <h2 className="text-center">Edit Profile</h2>
                        <div className="mb-4 mt-4 input-group">
                            <span className="input-group-addon"><i className="fas fa-user-alt fa-2x"></i></span>
                            <input id="user" type="text" onChange={(e) => setUsername(e.target.value)} value={username} className="form-control text-primary" placeholder="Username" />
                        </div>
                        <div className="mb-4 mt-4 input-group">
                            <span className="input-group-addon"><i className="fas fa-envelope fa-2x"></i></span>
                            <input id="email" type="email" onChange={(e) => setEmail(e.target.value)} value={email} className="form-control text-primary" placeholder="Email" />
                        </div>
                        <div className="mb-4 mt-4 input-group">
                            <span className="input-group-addon" > <i className="fas fa-key fa-2x" /></span>
                            <input id="pass" type="password" onChange={(e) => setPassword(e.target.value)} value={password} className="form-control text-primary" placeholder="Password" />
                        </div>
                        <div className="bt-2 offset-md-4">
                            <button onClick={EditContact} className="btn btn-success">Edit Changes</button>
                        </div>
                    </div>
                </div>
            </div>

            <div className="footer">
                <h4>EndLessMusic &copy; copyright </h4>
            </div>
        </div>
    )
}

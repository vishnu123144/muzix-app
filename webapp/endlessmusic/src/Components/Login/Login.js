import React from 'react'
import "./Login.css";
import { useState } from "react";
import {Link,useHistory} from "react-router-dom";
import dashBoard2 from '../dashboard2/Dashboard1';



export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('false');

  let history = useHistory();
  const handleSubmit = () => {
    fetch('http://localhost:8088/user-service/api/v1/login', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email, password }),
    })
      .then((res) => res.json())
      .then((data) => {
        if (data.token) {
          localStorage.setItem('token', data.token);
          localStorage.setItem('email', email);
          setError(false);
          //setIsAuthenticated(true);
          
          if(error==='false')
          {
            history.push('/dashboard');
          }
        } else {
          alert("User Not Valid:")
          setError('true');
        }
      });
    console.log(email, password);
  };

  return (
    <div >
      <div>
        <nav className="navbar navbar-expand-lg navbar-light bg-dark text-danger">
          <span className="span"><h2 className="fas fa-headphones-alt"></h2></span>
          <div className="container-fluid">
            <h3>EndlessMusic</h3>
            {/* <button><h3><i class="fas fa-user bg-light"></i></h3></button> */}
          </div>
          <ul className="navbar-nav ml-auto">
          <li className="nav-item">
              <button  className=" btn btn-outline-info">
              <Link to="/" className="nav-link text-white">Home</Link></button>
            </li>
            <li className="nav-item">
              <button  className=" btn btn-outline-info">
              <Link to="/register" className="nav-link text-white">Register</Link></button>
            </li>
          </ul>
        </nav>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-md-4 offset-md-4">
            <h2 className="text-center">Login page</h2>
            <div className="mb-4 mt-4 input-group">
              <span className="input-group-addon"><i className="fas fa-envelope fa-2x"></i></span>
              <input id="email" type="email" onChange={(e) => setEmail(e.target.value)} value={email} className="form-control text-primary" placeholder="Email"/>
            </div>
            <div className="mb-4 mt-4 input-group">
              <span className="input-group-addon" > <i className="fas fa-key fa-2x" /></span>
              <input id="pass" type="password" onChange={(e) => setPassword(e.target.value)} value={password} className="form-control text-primary" placeholder="Password"/>
            </div>
            <div className="bt-2" id="btn">
              <button onClick={handleSubmit} className="btn btn-success ">Login</button>
            </div>
          </div>
        </div>
      </div>
      
      <div>
        <div className="footer">
          <h4>EndLessMusic &copy; copyright </h4>
        </div>
      </div>
    </div>
  )
}

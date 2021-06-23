import React from 'react'
import { Link } from "react-router-dom";
import './Header.css'
export default function Header() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-dark text-danger">
                <span className="span"><h2 className="fas fa-headphones-alt"></h2></span>
                <div className="container-fluid">
                    <h3>EndlessMusic</h3>
                    {/* <button><h3><i class="fas fa-user bg-light"></i></h3></button> */}
                </div>
                <ul className="navbar-nav ml-auto">
                    {/* <li className="nav-item">
                        <a href="/" className="nav-link">Home</a>
                    </li> */}
                    {/* <li className="nav-item">
                        <button className=" btn btn-outline-info">
                            <Link to="/dashboard" className="nav-link text-white">DashBoard</Link></button>
                    </li> */}
                    <li className="nav-item">
                        <button className=" btn btn-outline-info">
                            <Link to="/register" className="nav-link text-white">REGISTER</Link></button>
                    </li>
                    <li className="nav-item">
                        <button className=" btn btn-outline-info">
                            <Link to="/login" className="nav-link text-white">LOGIN</Link></button>
                    </li>
                </ul>
            </nav>
        </div>
    )
}
import React from 'react'
import './Header.css'

export default function Header() {
    return (
<nav className="navbar navbar-expand-lg navbar-light bg-info">
  <div className="container-fluid">
    <a  className="navbar-brand text-dark" href="#"><i className="fas fa-headphones-alt"></i>   EndLessMusic</a>
    <div className="float-right">
    <i class="fas fa-user-circle"></i>
    </div>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">

        </li>
      </ul>
    </div>
  </div>
</nav> 
)

}


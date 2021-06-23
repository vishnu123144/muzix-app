import React from 'react'
import { useEffect, useState } from "react";
import { v4 as uuidv4 } from 'uuid';
import { useHistory } from 'react-router';
import './Dashboard1.css'
import { Link } from 'react-router-dom';
import DashBoard3 from '../DashBoard3/DashBoard3';


export default function Dashboard() {


    const [artistName, setArtistName] = useState('');
    const [details, setDetails] = useState([]);

    var songUrl;

    useEffect(() => {
        let token = localStorage.getItem('token')
        let emailid = localStorage.getItem('email');
        fetch(`http://localhost:8088/favorite-service/api/v1/${emailid}/createFavouriteList`, {
            headers: {
                'token': token
            }
        })


    }, [])

    function Getdetail() {

        fetch(`http://localhost:8088/search-service/api/v1/search/${artistName}`, {
            mode: 'cors'
            // headers: {
            //     'token': `${localStorage.getItem('token')}`
            // }

        }).then(res => res.json())
            .then(data => setDetails(data.results.trackmatches.track));
    }

    let history = useHistory();
    function addFav(item) {
        let emailid = localStorage.getItem('email')
        var pushingObj = {}
        var sendObj = {}
        let id1 = uuidv4();
        pushingObj.favouriteId = id1

        pushingObj.songTitle = item.name
        pushingObj.artistName = item.artist
        pushingObj.songUrl = item.url
        pushingObj.listeners = item.listeners
        let tracks = [];

        tracks.push(pushingObj)

        let email = emailid
        let songs = tracks




        fetch('http://localhost:8088/favorite-service/api/v1/addsong', {
            mode: 'cors',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            // body: JSON.stringify({sendObj})
            body: JSON.stringify({ email, songs })
        }).then(res => {

            if (res.status == 200) {
                // alert("added succesfully")
                // history.push('/fav')

            }
            else {
                alert("Error in adding")
            }

        });

        console.log(sendObj);
    }

    return (
        <div className="b" id="backg">
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark ">
                <span className="span"><i className="fas fa-headphones-alt"></i></span>
                <div className="container-fluid ">
                    <h3>EndLessMusic</h3>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div id="drop" style={{ paddingLeft: 300 }}>
                        {/* 
                        <select onChange={(e) => setArtistName(e.target.value)} >
                            <option value="1">My playlist</option>
                            <option value="2">songTitle</option>
                            <option value="3" >artistName</option>
                        </select> */}
                    </div>
                    <div>
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        </ul>
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0" style={{ paddingRight: 100, color: "grey" }} >
                            <form className="d-flex" action="#">
                                <input
                                    onChange={(e) => setArtistName(e.target.value)}
                                    type="search"
                                    placeholder="Search"
                                    aria-label="Search"
                                />
                                <button
                                    className="btn btn-outline-success offset-md-1"
                                    type="button"
                                    onClick={Getdetail}
                                >
                                    Search
                                </button>
                            </form>
                        </ul>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            profile
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <Link to="/editProfile" className="dropdown-item" >Edit Profile</Link>
                            <Link to="/fav" class="dropdown-item" >FavoriteList</Link>
                            <Link to="/" class="dropdown-item" >Logout</Link>
                            {/* <li><a class="dropdown-item" href="#">Something else here</a></li> */}
                        </ul>
                    </div>

                    {/* <li className="nav-item">
                        <button className=" btn btn-outline-info">
                            <Link to="/fav" className="nav-link text-white">Fav</Link></button>
                    </li> */}
                    {/* <li className="nav-item">
                        <button className=" btn btn-outline-info">
                        <Link to="/editProfile" className="nav-link text-white">Edit</Link></button>
                    </li> */}
                    {/* <div className="dropdown" style={{ paddingLeft: 10, color: "grey" }}>
                        <p>
                            <button className="dropbtn"><i className="fas fa-user bg-light"></i></button>
                        </p>
                        <p>
                            <Link to="/editProfile">EditProfile</Link>
                        </p>
                    </div> */}
                </div>
            </nav>
            <section id="backg">
                <div className="row">
                    {
                        details.map(item => (
                            <div className="col-md-3 mb-3">
                                <div className="card" style={{ backgroundColor: "CornSilk" }}>
                                    <div className="card-body" id="cad" style={{ color: "black" }} >
                                        <img src="./images/background red.jpg" style={{ width: '180px', height: '150px' }} />
                                        {/* <button type="button" onClick={addFav.bind(this, item)}></button> */}
                                        <i class="far fa-heart float-end " onClick={addFav.bind(this, item)}></i>

                                        <h6 className="card-title" style={{ color: "green" }}  ><h6 style={{ color: "blue" }}>songTitle:</h6>{item.name}</h6>
                                        <h6 className="card-text" style={{ color: "black" }} ><span style={{ color: "deeppink" }}>artistName:</span>  {item.artist}</h6>
                                        <a href={item.url} target="-" ><i class="far fa-play-circle"></i></a>
                                        <p className="card-text " style={{ color: "blue" }} >listeners:  {item.listeners}</p>
                                    </div>
                                </div>
                            </div>
                        ))
                    }
                </div>
            </section>
            <DashBoard3/>
            <div className="footer" id="footeredit">
                <h4>EndLessMusic &copy; copyright </h4>
            </div>
        </div>
    )
}

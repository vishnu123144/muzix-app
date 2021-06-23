import React, { useState, useEffect } from 'react'
import FavSong from '../FavSong/FavSong';
import { Link } from 'react-router-dom';
import './Fav.css'
export default function Fav() {

    const [favSongs, setfavSongs] = useState([]);

    //const [favSongs, setFavSongs] = useState([])
   
    useEffect(() => {
        let token = localStorage.getItem('token');
        let emailid = localStorage.getItem('email')
        // let emailid=localStorage.getItem('email')
        fetch(`http://localhost:8088/favorite-service/api/v1/favourite/${emailid}/getAllFavourites`, {
            headers: {
                'token': token
            }
        })
            .then(res => res.json())
            .then(data => {
                setfavSongs(data.songs);
                // localStorage.getItem('token', data.token);
                console.log(data);
                //favSongs=data.songs;
               //console.log(favSongs);

            })
    }, [])

    function DeleteFavSong(id) {
        //console.log(id, "Welcome to delete");
        let emailid = localStorage.getItem('email')
         let filteredSongs = favSongs.filter(x => x.favouriteId !== id);
      //  let filteredSongs = favSongs.filter(x => console.log(x.favouriteId !==id));
        console.log(filteredSongs);
        setfavSongs([...filteredSongs]);
        let token = localStorage.getItem('token');
        fetch(`http://localhost:8088/favorite-service/api/v1/favourite/${emailid}/deleteFromFavourite/${id}`, {
            method: 'DELETE',
            headers: {
                'token': token
            }
        })
    }
    return (
        <div>
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-dark text-danger">
                    <span className="span"><h2 className="fas fa-headphones-alt"></h2></span>
                    <div className="container-fluid">
                    <h3><Link to="/dashboard" style={{textDecoration:'none'}}>EndlessMusic</Link></h3>
                        {/* <button><h3><i class="fas fa-user bg-light"></i></h3></button> */}
                    </div>
                    {/* <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <button className=" btn btn-outline-info">
                                <Link to="/dashboard" className="nav-link text-white">DashBoard</Link></button>
                        </li>
                        <li className="nav-item">
                            <button className=" btn btn-outline-info">
                                <Link to="/register" className="nav-link text-white">Register</Link></button>
                        </li>
                    </ul> */}
                </nav>
            </div>

            <div className="container">
                <h2 className="bg-secondary text-dark text-center">Favourite Songs</h2>
                <div className="container">
                    <div className="row">
                        {
                            favSongs.map((item) =>(
                                <FavSong DeleteFav={DeleteFavSong}
                                    key={item.favouriteId}
                                    favouriteId={item.favouriteId}
                                    songTitle={item.songTitle}
                                    artistName={item.artistName}
                                    songUrl={item.songUrl}
                                    listeners={item.listeners}
                                />)
                            )}
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
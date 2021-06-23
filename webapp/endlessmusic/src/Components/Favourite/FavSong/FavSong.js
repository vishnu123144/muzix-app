import React from 'react'
//import { Link } from 'react-router-dom';
import './FavSong.css'

export default function FavSong(props) {
    function DeleteFavsongsHandler(favouriteId) {
        props.DeleteFav(favouriteId);
    }
    return (
        

        <div className="col-md-3 mb-2" id="backbg">
            <div className="card mb-2" style={{backgroundColor:"CornSilk"}}>
                <div className="card-body mb-2" id="content">
                    <img src="./images/background red.jpg" style={{width:'180px',height:'150px'}}/>
                    <i className="far fa-times-circle fa-lg float-end text-danger" onClick={DeleteFavsongsHandler.bind(this, props.favouriteId)}></i>
                    <h6 className="card-title text-success text">{props.favouriteId}</h6>
                    <h6 className="card-text text-primary">{props.songTitle}</h6>
                    <h6 className="card-text ">{props.artistName}</h6>
                    <h6 className="card-text text-danger offset-md-9">{props.listeners}</h6>
                    <i class="fas fa-heart text-danger offset-md-10"></i>
                </div>
            </div>
        </div>
    )
}

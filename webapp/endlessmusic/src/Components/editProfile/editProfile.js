import React from 'react';
import './editProfile.css';

export default function editProfile() {
    return (
            <div className="container mt-3">
            <div className="row">
                <div className="col-md-4 offset-md-8 text-light">
                    <div className="mb-2">
                        <h2 className="text-dark text-center">Edit Profile</h2>
                    </div>
                    <div className="mb-2">
                        <input  type="text"  className="form-control " placeholder="username"/>
                    </div>
                    <div className="mb-2">
                        <input  type="text"  className="form-control" placeholder="email-id"/>
                    </div>
                    <div className="mb-2">
                        <input  type="password" className="form-control" placeholder="password"/>
                    </div>
                    <div className="mb-2">
                        <input  type="text"  className="form-control" placeholder="new password"/>
                    </div>
                    <div className="mb-2">
                        <input  type="text"  className="form-control" placeholder="confirm password"/>
                    </div>

                    <div className="bt-10">
                        <button className="btn btn-success">Register</button>
                    </div>
                    </div>
                </div>
            </div>
    )
}

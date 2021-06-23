//import logo from './logo.svg';
import { BrowserRouter as Router,Route,Switch } from "react-router-dom";
import React from "react";

import EditProfile from './Components/EditProfile/EditProfile';
 import Login from './Components/Login/Login';
import Home from './Components/Home/Home';
import Register  from "./Components/Register/Register";
import Fav from './Components/Favourite/Fav/Fav';
import dashBoard1 from './Components/dashboard2/Dashboard1';

function App() {
  return (
    <div>
       <Router>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/register" component={Register}/>
            <Route exact path="/editProfile" component={EditProfile}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/fav" component={Fav}/>
            <Route exact path="/dashboard" component={dashBoard1}/>
          </Switch>
        </Router> 
    </div>
  );
}

export default App;

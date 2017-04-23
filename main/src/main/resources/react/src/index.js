import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import { hashHistory, Router, Route } from "react-router"
import App from './components/Main';
import User from "./components/user/User";
// import Home from "./components/home/Home";
import Login from "./components/home/Login";
// Render the main component into the dom
ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/login" component={Login} />
        <Route path="/" component={App}>
            <Route path={"user"} components={User} />
        </Route>
    </Router>
    , document.getElementById('app'));

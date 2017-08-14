import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import { hashHistory, Router, Route } from "react-router"
import App from './components/Main';
import Users from "./components/user/Users";
import Login from "./components/home/Login";
import Roles from "./components/user/Roles";
import registerServiceWorker from './registerServiceWorker';
ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/login" component={Login} />
        <Route path="/" component={App}>
            <Route path={"users"} components={Users} />
            <Route path={"roles"} components={Roles} />
        </Route>
    </Router>
    , document.getElementById('root'));
registerServiceWorker();
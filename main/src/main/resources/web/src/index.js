import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route } from "react-router"

import App from './components/Main';
import Users from "./components/user/Users";
import Login from "./components/home/Login";
import Roles from "./components/user/Roles";
import registerServiceWorker from './registerServiceWorker';
import createBrowserHistory from 'history/createBrowserHistory'

const history = createBrowserHistory()
ReactDOM.render(
    <Router history={history}>
        <div>
            <Route path="/login" component={Login} />
            <Route path="/" component={App}>
                <Route path={"users"} components={Users} />
                <Route path={"roles"} components={Roles} />
            </Route>
        </div>
    </Router>
    , document.getElementById('root'));
registerServiceWorker();
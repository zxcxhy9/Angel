import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'
import Home from './pages/Home';
import About from './pages/About';
import Login from './pages/Login';
import ControlPanel from "./pages/ControlPanel";
import CarList from './pages/CarList';

const Routes = () => (
    <Router>
        <Link to="/" >首页</Link>
        <Link to="/login">登陆</Link>
        <Link to="/about">关于</Link>
        <Link to="/controlPanel">controlPanel</Link>
        <Link to="/carList">carList</Link>
        <Route exact path="/" component={Home} />
        <Route path="/login" component={Login} />
        <Route path="/about" component={About} />
        <Route path="/controlPanel" component={ControlPanel} />
        <Route path="/carList" component={CarList} />
    </Router>
)

export default Routes;
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/App.css';

import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import NavBar from "./fragments/NavBar";

import Home from "./pages/Home";

const root = ReactDOM.createRoot(
    document.getElementById("root")!
);

root.render(
    <React.StrictMode>
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);